# Pharmacy Management System

![Technology](https://img.shields.io/badge/Built%20with-Java-blue)

## 📋 Project Description

The **Pharmacy Management System** is a Java Swing-based desktop application designed to streamline the operations of a pharmacy. It allows pharmacists to manage drugs, handle sales transactions, monitor inventory levels, and maintain a transaction history through an intuitive graphical interface.

## 🎯 Features

- 🧾 **Inventory Management**: Add, update, remove, and view available drugs.
- 🛒 **Sales & Orders**: Place orders and record transactions.
- 📦 **Capacity Management**: Set and monitor pharmacy inventory capacity.
- 📈 **Transaction Logs**: View and track all past transactions.
- 💻 **User Interface**: Clean and interactive GUI using Java Swing.

## 🗂️ Project Structure

```
Pharmacy-app/
└── src/
    └── main/
        └── java/
            └── app/
                ├── Main.java
                ├── Pharmacy.java
                ├── Drug.java
                └── frames/
                    ├── WelcomeFrame.java
                    ├── MainFrame.java
                    ├── AddDrugFrame.java
                    ├── RemoveDrugFrame.java
                    ├── UpdateDrugFrame.java
                    ├── ViewInventoryFrame.java
                    ├── PlaceOrderFrame.java
                    ├── TransactionHistoryFrame.java
                    ├── TotalSalesFrame.java
                    ├── CapacityFrame.java
```

## 🚀 How to Run

### 🧰 Prerequisites

- Java Development Kit (JDK 8+)
- Any Java-compatible IDE (IntelliJ, Eclipse, NetBeans) or terminal

### ▶️ Run via Terminal

1. Open terminal and navigate to the `src/main/java` directory:
   ```bash
   cd src/main/java
   ```

2. Compile the files:
   ```bash
   javac app/*.java app/frames/*.java
   ```

3. Run the main program:
   ```bash
   java app.Main
   ```

### 💡 Tip for IDE Users

- Import the `Pharmacy-app` folder as a Java project.
- Set the main class to `app.Main`.
- Click Run.

## 🔮 Future Enhancements

- Database integration for persistent data
- User authentication system
- Exportable sales and inventory reports
- Cloud sync for multiple branches

---

🚀 **Efficient Pharmacy Management Starts Here!**
