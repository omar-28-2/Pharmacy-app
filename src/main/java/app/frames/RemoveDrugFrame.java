import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class RemoveDrugFrame extends JFrame implements ActionListener {

    private JLabel idLabel;
    private JTextField idField;
    private JButton removeButton;

    private JButton backButton; // Back button

    private Pharmacy pharmacy;

    public RemoveDrugFrame(Pharmacy pharmacy) {
        this.pharmacy = pharmacy;

        setTitle("Remove Drug");
        setSize(300, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        setLocationRelativeTo(null);

        // Initialize components
        idLabel = new JLabel("ID:");
        idField = new JTextField(10);
        removeButton = new JButton("Remove");
        backButton = new JButton("Back"); // Initialize the back button

        // Set layout
        setLayout(new GridLayout(5, 2));

        // Add components to the frame
        add(idLabel);
        add(idField);
        add(removeButton);
        add(backButton); // Add the back button

        // Add action listener for remove button
        removeButton.addActionListener(this);
        backButton.addActionListener(this); // Add action listener for the back button
    }

    // Getter for ID input
    public int getIdInput() {
        return Integer.parseInt(idField.getText());
    }

    @Override
public void actionPerformed(ActionEvent e) {
    if (e.getSource() == removeButton) {
        String idText = idField.getText();

        // Check if ID field is empty
        if (idText.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please enter the ID!", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        int id;
        try {
            id = Integer.parseInt(idText);

            // Check if the entered ID corresponds to a drug in the inventory
            boolean removed = pharmacy.removeDrug(id);
            if (removed) {
                JOptionPane.showMessageDialog(this, "Drug removed successfully!");
            } else {
                JOptionPane.showMessageDialog(this, "Drug with ID " + id + " not found!", "Error", JOptionPane.ERROR_MESSAGE);
            }

            dispose();
            MainFrame mainFrame = new MainFrame(pharmacy);
            mainFrame.setVisible(true);
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Invalid ID format! Please enter a valid number.", "Error", JOptionPane.ERROR_MESSAGE);
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
