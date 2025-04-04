import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PlaceOrderFrame extends JFrame implements ActionListener {

    private JLabel idLabel, quantityLabel, categoryLabel;
    private JTextField idField, quantityField, categoryField;
    private JButton placeOrderButton;
    private JButton backButton;

    private Pharmacy pharmacy;

    public PlaceOrderFrame(Pharmacy pharmacy) {
        this.pharmacy = pharmacy;

        setTitle("Place Order");
        setSize(300, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        setLocationRelativeTo(null);

        // Initialize components
        idLabel = new JLabel("ID:");
        idField = new JTextField(10);
        quantityLabel = new JLabel("Quantity:");
        quantityField = new JTextField(10);
        categoryLabel = new JLabel("Category:");
        categoryField = new JTextField(10);
        placeOrderButton = new JButton("Place Order");

        backButton = new JButton("Back");

        // Set layout
        setLayout(new GridLayout(5, 2));

        // Add components to the frame
        add(idLabel);
        add(idField);
        add(quantityLabel);
        add(quantityField);
        add(categoryLabel);
        add(categoryField);
        add(placeOrderButton);
        add(backButton);

        // Add action listener for the place order button
        placeOrderButton.addActionListener(this);
        backButton.addActionListener(this);
    }

    // Getters for input fields
    public int getIdInput() {
        return Integer.parseInt(idField.getText());
    }

    public int getQuantityInput() {
        return Integer.parseInt(quantityField.getText());
    }

    public String getCategoryInput() {
        return categoryField.getText();
    }

    @Override
public void actionPerformed(ActionEvent e) {
    if (e.getSource() == placeOrderButton) {
        String idText = idField.getText();
        String quantityText = quantityField.getText();
        String category = categoryField.getText();

        // Check if any field is empty
        if (idText.isEmpty() || quantityText.isEmpty() || category.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please fill in all fields!", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        int id;
        int quantity;
        try {
            id = Integer.parseInt(idText);
            quantity = Integer.parseInt(quantityText);

            // Check for negative values
            if (id < 0 || quantity <= 0) {
                JOptionPane.showMessageDialog(this, "Please enter valid values for ID and quantity!", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }

            // Attempt to place the order
            boolean orderPlaced = pharmacy.placeOrder(id, quantity, category);
            if (orderPlaced) {
                JOptionPane.showMessageDialog(this, "Order placed successfully!");
            } else {
                JOptionPane.showMessageDialog(this, "Failed to place order! Please check ID and quantity.", "Error", JOptionPane.ERROR_MESSAGE);
            }

            // Dispose current frame and show main frame
            dispose();
            MainFrame mainFrame = new MainFrame(pharmacy);
            mainFrame.setVisible(true);
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Please enter valid numeric values for ID and quantity!", "Error", JOptionPane.ERROR_MESSAGE);
        } catch (IllegalArgumentException ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    } else if (e.getSource() == backButton) {
        // Navigate back to main frame
        dispose();
        MainFrame mainFrame = new MainFrame(pharmacy);
        mainFrame.setVisible(true);
    }
}


    // Method to add action listener to the place order button
    // public void addPlaceOrderButtonListener(ActionListener listener) {
    //     placeOrderButton.addActionListener(listener);
    // }
}
