import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class WelcomeFrame extends JFrame implements ActionListener {

    private JButton welcomeButton;
    private Pharmacy pharmacy;

    public WelcomeFrame(Pharmacy pharmacy) {
        this.pharmacy = pharmacy;

        setTitle("Welcome to Pharmacy Management System");
        setSize(450, 300);  // Increase frame size
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        setLocationRelativeTo(null);

        // Initialize components
        welcomeButton = new JButton("WELCOME TO OUR PHARMACY");
        welcomeButton.setPreferredSize(new Dimension(300, 50));  // Set button size

        // Set layout and add components to the frame
        setLayout(new GridBagLayout());  // Center the button
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        add(welcomeButton, gbc);

        welcomeButton.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == welcomeButton) {
            dispose();
            CapacityFrame capacityFrame = new CapacityFrame(pharmacy);
            capacityFrame.setVisible(true);
        }
    }
}