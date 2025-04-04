import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ViewInventoryFrame extends JFrame implements ActionListener {

    private JTextArea inventoryTextArea;

    JButton backButton;

    private Pharmacy pharmacy;

    public ViewInventoryFrame(Pharmacy pharmacy) {
        this.pharmacy = pharmacy;

        setTitle("View Inventory");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        setLocationRelativeTo(null);

        // Initialize components
        inventoryTextArea = new JTextArea();
        inventoryTextArea.setEditable(false);

        // Create back button
        backButton = new JButton("Back");

        // Set layout
        setLayout(new BorderLayout());

        // Add components to the frame
        JScrollPane scrollPane = new JScrollPane(inventoryTextArea);
        add(scrollPane, BorderLayout.CENTER);
        add(backButton, BorderLayout.SOUTH);

        // Add action listener for the back button
        backButton.addActionListener(this);

        // Display inventory
        displayInventory();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == backButton) {
            dispose();
            MainFrame mainFrame = new MainFrame(pharmacy);
            mainFrame.setVisible(true);
        }
    }

    
    // Method to display inventory in the text area
    private void displayInventory() {
        StringBuilder inventory = new StringBuilder();
        for (Drug drug : pharmacy.getDrugList()) {
            inventory.append(drug.getName()).append(" (ID: ").append(drug.getId()).append("): ")
                    .append(drug.getQuantity()).append(" units @ $").append(drug.getPrice()).append(" each\n");
        }
        inventoryTextArea.setText(inventory.toString());
    }
    

    // Method to display inventory in the text area
    // public void displayInventory(String inventory) {
    //     inventoryTextArea.setText(inventory);
    // }
}
