import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Stack;

public class TransactionHistoryFrame extends JFrame implements ActionListener {

    private JTextArea historyTextArea;

    JButton backButton;

    private Pharmacy pharmacy;

    public TransactionHistoryFrame(Pharmacy pharmacy) {
        this.pharmacy = pharmacy;

        setTitle("Transaction History");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        setLocationRelativeTo(null);

        // Initialize components
        historyTextArea = new JTextArea();
        historyTextArea.setEditable(false);

        // Create back button
        backButton = new JButton("Back");

        // Set layout
        setLayout(new BorderLayout());

        // Add components to the frame
        JScrollPane scrollPane = new JScrollPane(historyTextArea);
        add(scrollPane, BorderLayout.CENTER);
        add(backButton, BorderLayout.SOUTH);

        // Add action listener for the back button
        backButton.addActionListener(this);

        // Display transaction history
        displayTransactionHistory();
    }

  
    // Method to display transaction history in the text area
    private void displayTransactionHistory() {
        StringBuilder history = new StringBuilder();
        Stack<String> transactions = new Stack<>();
        transactions.addAll(pharmacy.getTransactionHistory());
        while (!transactions.isEmpty()) {
            history.append(transactions.pop()).append("\n");
        }
        historyTextArea.setText(history.toString());
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == backButton) {
            dispose();
            MainFrame mainFrame = new MainFrame(pharmacy);
            mainFrame.setVisible(true);
        }
    }
}
