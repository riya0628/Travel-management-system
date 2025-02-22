package travel_management_system;

import javax.swing.*;
import java.awt.event.*;
import java.io.IOException;

public class Paytm extends JFrame implements ActionListener {
    
    JButton back;
    
    Paytm() {
        // Frame settings
        setBounds(500, 200, 800, 600);
        setLayout(null); // Explicitly setting layout to null

        JEditorPane pane = new JEditorPane();
        pane.setEditable(false);

        // Attempt to load the Paytm page
        try {
            pane.setPage("https://paytm.com/rent-payment");
        } catch (IOException e) {
            pane.setContentType("text/html");
            pane.setText("<html>Could not load the page, Error 404<html>");
        }

        // Add scroll pane for the editor pane
        JScrollPane sp = new JScrollPane(pane);
        sp.setBounds(0, 0, 800, 500);  // Set bounds for scroll pane
        add(sp);

        // Add back button
        back = new JButton("Back");
        back.setBounds(610, 520, 80, 40);  // Proper position for the button
        back.addActionListener(this);
       add(back);

        // Frame visibility
        setVisible(true);
    }

    // Handling button click
    @Override
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == back) {
            setVisible(false);  // Hide current frame
            new Payment();  // Redirect to Payment screen (assuming Payment class exists)
        }
    }

    public static void main(String[] args) {
        new Paytm();
    }
}
