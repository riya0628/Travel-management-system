package travel_management_system;

import javax.swing.*;
import java.awt.*;
import java.sql.*;
import java.awt.event.*; // Imported for ActionListener

public class ViewPackage extends JFrame implements ActionListener {

    JButton back;

    // Constructor to take 'username' as input
    ViewPackage(String username) {
        
        // Frame settings
        setBounds(450, 200, 900, 450);
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        
        JLabel text = new JLabel("View Package and Details");
        text.setFont(new Font("Tahoma", Font.BOLD, 20));
        text.setBounds(60, 0, 300, 30);
        add(text); // Add the label to the frame

        // Labels for displaying customer details
        JLabel lblusername = new JLabel("Username:");
        lblusername.setBounds(30, 50, 150, 25);
        add(lblusername);

        JLabel labelusername = new JLabel("");  // Placeholder for dynamic content
        labelusername.setBounds(220, 50, 150, 25);
        add(labelusername);

        JLabel lblpackage = new JLabel("Package :");
        lblpackage.setBounds(30, 90, 150, 25);
        add(lblpackage);

        JLabel labelpackage = new JLabel("");  // Placeholder for dynamic conte
        labelpackage.setBounds(220, 90, 150, 25);
        add(labelpackage);

        JLabel lblpersons= new JLabel("Total Person:");
        lblpersons.setBounds(30, 130, 150, 25);
        add(lblpersons);

        JLabel labelpersons = new JLabel("");  // Placeholder for dynamic content
        labelpersons.setBounds(220, 130, 150, 25);
        add(labelpersons);

        JLabel lblid = new JLabel("Id:");
        lblid.setBounds(30, 170, 150, 25);
        add(lblid);

        JLabel labelid= new JLabel("");  // Placeholder for dynamic content
        labelid.setBounds(220, 170, 150, 25);
        add(labelid);

        JLabel lblnumber = new JLabel("Number:");
        lblnumber.setBounds(30, 230, 150, 25);
        add(lblnumber);

        JLabel labelnumber = new JLabel("");  // Placeholder for dynamic content
        labelnumber.setBounds(220, 210, 150, 25);
        add(labelnumber);

        JLabel lblphone = new JLabel("Phone:");
        lblphone.setBounds(30, 250, 150, 25);
        add(lblphone);

        JLabel labelphone = new JLabel("");  // Placeholder for dynamic content
        labelphone.setBounds(220, 250, 150, 25);
        add(labelphone);

        JLabel lblprice = new JLabel("Price:");
        lblprice.setBounds(30, 290, 150, 25);
        add(lblprice);
JLabel labelprice = new JLabel("Price:");
        labelprice.setBounds(220, 290, 150, 25);
        add(labelprice);
        

        back = new JButton("Back");
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
        back.setBounds(130, 360, 100, 25);
        back.addActionListener(this);  // Added action listener for the back button
        add(back);

        

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/bookedDetails.jpg"));
        Image i2 = i1.getImage().getScaledInstance(500, 400, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(450, 20, 500, 400);
        add(image);

        // Fetch customer details from the database
        try {
            Conn conn = new Conn();
            String query = "SELECT * FROM BookPackage WHERE username = '" + username + "'";
            ResultSet rs = conn.s.executeQuery(query);

            if (rs.next()) {
                labelusername.setText(rs.getString("username"));
                labelid.setText(rs.getString("id"));
                labelnumber.setText(rs.getString("number"));
                labelpackage.setText(rs.getString("package"));
                labelprice.setText(rs.getString("price"));
                labelphone.setText(rs.getString("phone"));
                labelpersons.setText(rs.getString("persons"));
               
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        // Make the frame visible
        setVisible(true);
    }

    // Implement the actionPerformed method for handling button clicks
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == back) {
            setVisible(false);  // Close the window on back button click
        }
    }

    // Main method to test the ViewPacakge class
    public static void main(String[] args) {
        new ViewPackage("riya25");  // Pass the username dynamically or test with a specific one
    }
}
