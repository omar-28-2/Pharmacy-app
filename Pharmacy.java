import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Pharmacy {
    
    private List<Drug> drugList;
    private int capacity;
    public static double totalSales = 0.0;
    private Stack<String> transactionHistory;

    public Pharmacy(int capacity) {
        this.capacity = capacity;
        this.drugList = new ArrayList<>();
        this.transactionHistory = new Stack<>();
    }

    public int getCapacity() {
        return capacity;
    }

    public static double getTotalSales() {
        return totalSales;
    }

    // Getter for drugList
    public List<Drug> getDrugList() {
        return drugList;
    }

    // Getter for transactionHistory
    public Stack<String> getTransactionHistory() {
        return transactionHistory;
    }

    public boolean addDrug(Drug drug) throws IllegalArgumentException {
        if (drugList.size() < capacity) {
            drugList.add(drug);
            return true;
        } else {
            throw new IllegalArgumentException("Pharmacy is full, cannot add more drugs.");
        }
    }

    public boolean removeDrug(int id) {
        for (Drug drug : drugList) {
            if (drug.getId() == id) {
                drugList.remove(drug);
                return true;
            }
        }
        return false; // Drug not found
    }

    public boolean placeOrder(int id, int quantity, String category) {
        for (Drug drug : drugList) {
            if (drug.getId() == id) {
                double price = drug.getPrice();
                if (category.equalsIgnoreCase("drug")) {
                    // If category is "drug", use the regular price
                    price = drug.getPrice();
                } else if (category.equalsIgnoreCase("cosmetics")) {
                    // If category is "cosmetics", apply a 20% markup
                    price = drug.getPrice() * 1.2;
                } else {
                    // If category is neither "drug" nor "cosmetics", return false
                    return false;
                }
                
                if (drug.getQuantity() >= quantity) {
                    // Update available quantity
                    drug.setQuantity(drug.getQuantity() - quantity);
    
                    // Calculate total cost of the order
                    double totalCost = quantity * price;
    
                    // Increment total sales
                    totalSales += totalCost;
    
                    // Add transaction to history
                    String transaction = "Ordered " + quantity + " units of " + drug.getName() +
                            " (ID: " + id + ") for $" + totalCost;
                    addTransaction(transaction);
    
                    return true;
                } else {
                    return false; // Insufficient quantity
                }
            }
        }
        return false; // Drug not found
    }

    // Update drug price and quantity
    public boolean updateDrug(int id, double price, int quantity) {
        for (Drug drug : drugList) {
            if (drug.getId() == id) {
                drug.setPrice(price);
                drug.setQuantity(quantity);
                return true;
            }
        }
        return false; // Drug not found
    }

    public boolean containsDrug(int id) {
        for (Drug drug : drugList) {
            if (drug.getId() == id) {
                return true;
            }
        }
        return false;
    }

    public String viewInventory() {
        StringBuilder inventory = new StringBuilder();
        for (Drug drug : drugList) {
            inventory.append(drug.getName()).append(" (ID: ").append(drug.getId()).append("): ")
                    .append(drug.getQuantity()).append(" units\n");
        }
        return inventory.toString();
    }

    public void addTransaction(String transaction) {
        transactionHistory.push(transaction);
    }

    public String viewTransactionHistory() {
        StringBuilder history = new StringBuilder();
        for (String transaction : transactionHistory) {
            history.append(transaction).append("\n");
        }
        return history.toString();
    }
}
