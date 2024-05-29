import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AddDrugFrame extends JFrame implements ActionListener {

    private JLabel nameLabel, idLabel, priceLabel, quantityLabel;
    private JTextField nameField, idField, priceField, quantityField;
    private JButton addButton;
    private JButton backButton;

    private Pharmacy pharmacy;

    public AddDrugFrame(Pharmacy pharmacy) {
        this.pharmacy = pharmacy;

        setTitle("Add Drug");
        setSize(300, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        setLocationRelativeTo(null);

        // Initialize components
        nameLabel = new JLabel("Name:");
        idLabel = new JLabel("ID:");
        priceLabel = new JLabel("Price:");
        quantityLabel = new JLabel("Quantity:");

        nameField = new JTextField(10);
        idField = new JTextField(10);
        priceField = new JTextField(10);
        quantityField = new JTextField(10);

        addButton = new JButton("Add");
        backButton = new JButton("Back");

        // Set layout
        setLayout(new GridLayout(5, 2));

        // Add components to the frame
        add(nameLabel);
        add(nameField);
        add(idLabel);
        add(idField);
        add(priceLabel);
        add(priceField);
        add(quantityLabel);
        add(quantityField);
        add(addButton);
        add(backButton);

        // Add action listener for add button
        addButton.addActionListener(this);
        backButton.addActionListener(this);
    }

    // Getters for components
    public String getNameInput() {
        return nameField.getText();
    }

    public int getIdInput() {
        return Integer.parseInt(idField.getText());
    }

    public double getPriceInput() {
        return Double.parseDouble(priceField.getText());
    }

    public int getQuantityInput() {
        return Integer.parseInt(quantityField.getText());
    }

    public void addAddButtonListener(ActionListener listener) {
        addButton.addActionListener(listener);
    }

@Override
public void actionPerformed(ActionEvent e) {
    if (e.getSource() == addButton) {
        String name = nameField.getText();
        String idText = idField.getText();
        String priceText = priceField.getText();
        String quantityText = quantityField.getText();

        // Check if any field is empty
        if (name.isEmpty() || idText.isEmpty() || priceText.isEmpty() || quantityText.isEmpty()) {
            JOptionPane.showMessageDialog(AddDrugFrame.this, "Please fill in all fields!", "Error",
                    JOptionPane.ERROR_MESSAGE);
            return;
        }

        int id;
        double price;
        int quantity;

        try {
            id = Integer.parseInt(idText);
            price = Double.parseDouble(priceText);
            quantity = Integer.parseInt(quantityText);

            // Check for negative values
            if (id < 0 || price < 0 || quantity < 0) {
                JOptionPane.showMessageDialog(AddDrugFrame.this, "Please enter positive values for ID, price, and quantity!", "Error",
                        JOptionPane.ERROR_MESSAGE);
                return;
            }

            // Check for duplicate ID
            if (pharmacy.containsDrug(id)) {
                JOptionPane.showMessageDialog(AddDrugFrame.this, "Drug with the same ID already exists!", "Error",
                        JOptionPane.ERROR_MESSAGE);
                return;
            }

            // Add the drug to the pharmacy
            Drug drug = new Drug(name, id, quantity, price);
            pharmacy.addDrug(drug);
            JOptionPane.showMessageDialog(AddDrugFrame.this, "Drug added successfully!");

            dispose();
            MainFrame mainFrame = new MainFrame(pharmacy);
            mainFrame.setVisible(true);
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(AddDrugFrame.this, "Invalid input format! Please enter valid numbers for ID, price, and quantity.", "Error",
                    JOptionPane.ERROR_MESSAGE);
        } catch (IllegalArgumentException ex) {
            JOptionPane.showMessageDialog(AddDrugFrame.this, ex.getMessage(), "Error",
                    JOptionPane.ERROR_MESSAGE);
        }
    } else if (e.getSource() == backButton) {
        dispose();
        MainFrame mainFrame = new MainFrame(pharmacy);
        mainFrame.setVisible(true);
    }
}
}
