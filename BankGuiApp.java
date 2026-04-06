import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class BankGuiApp extends JFrame implements ActionListener {

    private JPanel panel;
    private JButton depositButton, withdrawButton, showBalanceButton, exitButton;
    private JTextField amountField;
    private JLabel balanceLabel;

    private double balance;

    public BankGuiApp() {
        // starting balance (user enters this first)
        String input = JOptionPane.showInputDialog("Enter your starting balance:");
        balance = Double.parseDouble(input);

        setTitle("Simple Bank App");
        setSize(350, 250);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        panel = new JPanel();
        panel.setLayout(new GridLayout(5, 1));

        amountField = new JTextField();
        balanceLabel = new JLabel("Balance: $" + balance);

        depositButton = new JButton("Deposit");
        withdrawButton = new JButton("Withdraw");
        showBalanceButton = new JButton("Show Balance");
        exitButton = new JButton("Exit");

        depositButton.addActionListener(this);
        withdrawButton.addActionListener(this);
        showBalanceButton.addActionListener(this);
        exitButton.addActionListener(this);

        panel.add(new JLabel("Enter Amount:"));
        panel.add(amountField);
        panel.add(depositButton);
        panel.add(withdrawButton);
        panel.add(showBalanceButton);
        panel.add(balanceLabel);
        panel.add(exitButton);

        add(panel);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        try {
            double amount = Double.parseDouble(amountField.getText());

            if (e.getSource() == depositButton) {
                balance += amount;
                balanceLabel.setText("Balance: $" + balance);
            }

            if (e.getSource() == withdrawButton) {
                if (amount > balance) {
                    JOptionPane.showMessageDialog(this, "Not enough funds.");
                } else {
                    balance -= amount;
                    balanceLabel.setText("Balance: $" + balance);
                }
            }

            if (e.getSource() == showBalanceButton) {
                balanceLabel.setText("Balance: $" + balance);
            }

            if (e.getSource() == exitButton) {
                JOptionPane.showMessageDialog(this, "Final Balance: $" + balance);
                System.exit(0);
            }

        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Please enter a valid number.");
        }
    }

    public static void main(String[] args) {
        new BankGuiApp();
    }
}