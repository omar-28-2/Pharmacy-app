import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class MainFrame extends JFrame implements ActionListener {

    private JButton addDrugButton;
    private JButton removeDrugButton;
    private JButton placeOrderButton;
    private JButton updateButton;
    private JButton viewInventoryButton;
    private JButton transactionHistoryButton;
    private JButton totalSalesButton;

    private Pharmacy pharmacy;

    public MainFrame(Pharmacy pharmacy) {
        this.pharmacy = pharmacy;

        setTitle("Pharmacy Management System");
        setSize(300, 250);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        setLocationRelativeTo(null);

        // Initialize components
        addDrugButton = new JButton("Add Drug");
        removeDrugButton = new JButton("Remove Drug");
        placeOrderButton = new JButton("Place Order");
        updateButton = new JButton("Update Inventory"); // Initializing update button
        viewInventoryButton = new JButton("View Inventory");
        transactionHistoryButton = new JButton("Transaction History");
        totalSalesButton = new JButton("Total Sales");

        // Set layout
        setLayout(new GridLayout(7, 1));

        // Add components to the frame
        add(addDrugButton);
        add(removeDrugButton);
        add(placeOrderButton);
        add(updateButton); // Adding update button
        add(viewInventoryButton);
        add(transactionHistoryButton);
        add(totalSalesButton);

        // Add action listeners for buttons
        addDrugButton.addActionListener(this);
        removeDrugButton.addActionListener(this);
        placeOrderButton.addActionListener(this);
        updateButton.addActionListener(this); // Adding action listener for update button
        viewInventoryButton.addActionListener(this);
        transactionHistoryButton.addActionListener(this);
        totalSalesButton.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == addDrugButton) {
            openAddDrugFrame();
        } else if (e.getSource() == removeDrugButton) {
            openRemoveDrugFrame();
        } else if (e.getSource() == placeOrderButton) {
            openPlaceOrderFrame();
        } else if (e.getSource() == viewInventoryButton) {
            openViewInventoryFrame();
        } else if (e.getSource() == transactionHistoryButton) {
            openTransactionHistoryFrame();
        } else if (e.getSource() == totalSalesButton) {
            openTotalSalesFrame();
        } else if (e.getSource() == updateButton) { // Check if update button is clicked
            updateInventory(); // Call method to perform update action
        }
    }

    private void openAddDrugFrame() {
        AddDrugFrame addDrugFrame = new AddDrugFrame(pharmacy);
        addDrugFrame.setVisible(true);
        this.setVisible(false);
    }

    private void openRemoveDrugFrame() {
        RemoveDrugFrame removeDrugFrame = new RemoveDrugFrame(pharmacy);
        removeDrugFrame.setVisible(true);
        this.setVisible(false);
    }

    private void openPlaceOrderFrame() {
        PlaceOrderFrame placeOrderFrame = new PlaceOrderFrame(pharmacy);
        placeOrderFrame.setVisible(true);
        this.setVisible(false);
    }

    private void updateInventory() {
        UpdateDrugFrame updateFrame = new UpdateDrugFrame(pharmacy);
        updateFrame.setVisible(true);
        this.setVisible(false);
    }

    private void openViewInventoryFrame() {
        ViewInventoryFrame viewInventoryFrame = new ViewInventoryFrame(pharmacy);
        viewInventoryFrame.setVisible(true);
        this.setVisible(false);
    }

    private void openTransactionHistoryFrame() {
        TransactionHistoryFrame transactionHistoryFrame = new TransactionHistoryFrame(pharmacy);
        transactionHistoryFrame.setVisible(true);
        this.setVisible(false);
    }

    private void openTotalSalesFrame() {
        TotalSalesFrame totalSalesFrame = new TotalSalesFrame(Pharmacy.totalSales, pharmacy);
        totalSalesFrame.setVisible(true);
        this.setVisible(false);
    }
}