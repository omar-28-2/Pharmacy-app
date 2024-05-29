import javax.swing.SwingUtilities;

public class Main {
    // Define the default capacity constant
    private static final int DEFAULT_CAPACITY = 100;
    public static void main(String[] args) {

        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                Pharmacy pharmacy = new Pharmacy(DEFAULT_CAPACITY); // Set the default capacity here
                WelcomeFrame welcomeFrame = new WelcomeFrame(pharmacy);
                welcomeFrame.setVisible(true);
            }
        });
    }
}
