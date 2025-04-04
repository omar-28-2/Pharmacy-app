import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class UpdateDrugFrame extends JFrame implements ActionListener {

    private JLabel idLabel, priceLabel, quantityLabel;
    private JTextField idField, priceField, quantityField;
    private JButton updateButton;
    private JButton backButton;

    private Pharmacy pharmacy;

    public UpdateDrugFrame(Pharmacy pharmacy) {
        this.pharmacy = pharmacy;

        setTitle("Update Drug");
        setSize(300, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        setLocationRelativeTo(null);

        // Initialize components
        idLabel = new JLabel("ID:");
        idField = new JTextField(10);
        priceLabel = new JLabel("Price:");
        priceField = new JTextField(10);
        quantityLabel = new JLabel("Quantity:");
        quantityField = new JTextField(10);
        updateButton = new JButton("Update");
        backButton = new JButton("Back");

        // Set layout
        setLayout(new GridLayout(5, 2));

        // Add components to the frame
        add(idLabel);
        add(idField);
        add(priceLabel);
        add(priceField);
        add(quantityLabel);
        add(quantityField);
        add(updateButton);
        add(backButton);

        // Add action listener for the update button
        updateButton.addActionListener(this);
        backButton.addActionListener(this);
    }

    // Getters for input fields
    public int getIdInput() {
        return Integer.parseInt(idField.getText());
    }

    public double getPriceInput() {
        return Double.parseDouble(priceField.getText());
    }

    public int getQuantityInput() {
        return Integer.parseInt(quantityField.getText());
    }

    // Method to handle the update action
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == updateButton) {
            String idText = idField.getText();
            String priceText = priceField.getText();
            String quantityText = quantityField.getText();

            // Check if any field is empty
            if (idText.isEmpty() || priceText.isEmpty() || quantityText.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Please fill in all fields!", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }

            int id = Integer.parseInt(idText);
            double price = Double.parseDouble(priceText);
            int quantity = Integer.parseInt(quantityText);

            try {
                boolean updated = pharmacy.updateDrug(id, price, quantity);
                if (updated) {
                    JOptionPane.showMessageDialog(this, "Drug updated successfully!");

                    dispose();
                    MainFrame mainFrame = new MainFrame(pharmacy);
                    mainFrame.setVisible(true);
                } else {
                    JOptionPane.showMessageDialog(this, "Drug with ID " + id + " not found!", "Error", JOptionPane.ERROR_MESSAGE);
                }
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(this, "Please enter valid numeric values for Price and Quantity!", "Error", JOptionPane.ERROR_MESSAGE);
            } catch (IllegalArgumentException ex) {
                JOptionPane.showMessageDialog(this, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            }
        } else if (e.getSource() == backButton) {
            dispose();
            MainFrame mainFrame = new MainFrame(pharmacy);
            mainFrame.setVisible(true);
        }
    }
}
