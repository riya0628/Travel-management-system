package travel_management_system;

import javax.swing.*;
import java.awt.*;

public class Loading extends JFrame implements Runnable {

    Thread t;
    JProgressBar bar;  // Corrected from JProgressor to JProgressBar
    String username;

    // Constructor for the Loading class
    public Loading(String username) {
        this.username = username;
        t = new Thread(this);  // Pass 'this' to Thread constructor
        setBounds(500, 200, 650, 400);
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);

        // Title label
        JLabel text = new JLabel("Travel and Tourism Application");
        text.setBounds(50, 20, 600, 40);
        text.setForeground(Color.BLUE);
        text.setFont(new Font("Raleway", Font.BOLD, 35));
        add(text);

        // Progress bar
        bar = new JProgressBar();
        bar.setBounds(150, 100, 300, 35);
        bar.setStringPainted(true);
        add(bar);

        // Loading label
        JLabel loadingLabel = new JLabel("Loading, please wait...");
        loadingLabel.setBounds(230, 130, 150, 30);
        loadingLabel.setForeground(Color.RED);
        loadingLabel.setFont(new Font("Raleway", Font.BOLD, 16));
        add(loadingLabel);

        // Welcome message
        JLabel Username = new JLabel("Welcome, " + username + "!");
        Username.setBounds(20, 310, 400, 40);
        Username.setForeground(Color.RED);
        Username.setFont(new Font("Raleway", Font.BOLD, 16));
        add(Username);

        t.start();  // Start the thread
        setVisible(true);
    }

    // Runnable method for progress bar loading
    public void run() {
        try {
            for (int i = 1; i <= 101; i++) {  // Loop through 101% for smoother transition
                int max = bar.getMaximum();  // Get maximum value of the progress bar
                int value = bar.getValue();  // Get current value of the progress bar

                if (value < max) {
                    bar.setValue(value + 1);  // Increment the progress bar value
                } else {
                    setVisible(false);  // Close the loading screen when complete
                    // Open the Dashboard once loading is complete
                    new Dashboard(username);
                }

                Thread.sleep(50);  // Pause for 50 milliseconds
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Main method to launch the application
    public static void main(String[] args) {
        new Loading("Riya25");  // Pass username as an argument
    }
}
