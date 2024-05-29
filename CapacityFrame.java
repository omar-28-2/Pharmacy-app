import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CapacityFrame extends JFrame implements ActionListener {

    private JLabel capacityLabel;
    private JTextField capacityField;
    private JButton submitButton;

    private Pharmacy pharmacy;

    public CapacityFrame(Pharmacy pharmacy) {
        this.pharmacy = pharmacy;

        setTitle("Pharmacy Capacity");
        setSize(250, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        setLocationRelativeTo(null);

        // Initialize components
        capacityLabel = new JLabel("Enter Pharmacy Capacity:");
        capacityField = new JTextField(10);
        submitButton = new JButton("Submit");

        // Set layout
        setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10);

        // Add components to the frame
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.anchor = GridBagConstraints.CENTER;
        add(capacityLabel, gbc);

        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        add(capacityField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.fill = GridBagConstraints.NONE;
        add(submitButton, gbc);

        submitButton.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == submitButton) {
            dispose();
            MainFrame mainFrame = new MainFrame(pharmacy);
            mainFrame.setVisible(true);
        }
    }
}
