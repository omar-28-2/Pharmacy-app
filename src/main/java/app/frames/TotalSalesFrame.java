import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TotalSalesFrame extends JFrame implements ActionListener{

    private JLabel totalSalesLabel;
    private JButton backButton;
    private Pharmacy pharmacy;

    public TotalSalesFrame(double totalSales, Pharmacy pharmacy) {
        this.pharmacy = pharmacy;

        setTitle("Total Sales");
        setSize(300, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        setLocationRelativeTo(null);

        // Initialize components
        totalSalesLabel = new JLabel("Total Sales: $" + totalSales);

        backButton = new JButton("Back");

        // Set layout
        setLayout(new BorderLayout());

        // Add components to the frame
        add(totalSalesLabel, BorderLayout.CENTER);
        add(backButton, BorderLayout.SOUTH);

        // Add action listener for the back button
        backButton.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == backButton) {
            // Navigate back to the main frame
            dispose();
            MainFrame mainFrame = new MainFrame(pharmacy);
            mainFrame.setVisible(true);
        }
    }
}
