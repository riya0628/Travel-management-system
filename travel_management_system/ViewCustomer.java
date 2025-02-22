package travel_management_system;

import javax.swing.*;
import java.awt.*;
import java.sql.*;
import java.awt.event.*; // Imported for ActionListener

public class ViewCustomer extends JFrame implements ActionListener {

    JButton back;

    // Constructor to take 'username' as input
    ViewCustomer(String username) {
        // Frame settings
        setBounds(450, 180, 870, 625);
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);

        // Labels for displaying customer details
        JLabel lblusername = new JLabel("Username:");
        lblusername.setBounds(30, 50, 150, 25);
        add(lblusername);

        JLabel labelusername = new JLabel("");  // Placeholder for dynamic content
        labelusername.setBounds(220, 50, 150, 25);
        add(labelusername);

        JLabel lblid = new JLabel("ID:");
        lblid.setBounds(30, 110, 150, 25);
        add(lblid);

        JLabel labelid = new JLabel("");  // Placeholder for dynamic content
        labelid.setBounds(220, 110, 150, 25);
        add(labelid);

        JLabel lblnumber = new JLabel("Number:");
        lblnumber.setBounds(30, 170, 150, 25);
        add(lblnumber);

        JLabel labelnumber = new JLabel("");  // Placeholder for dynamic content
        labelnumber.setBounds(220, 170, 150, 25);
        add(labelnumber);

        JLabel lblname = new JLabel("Name:");
        lblname.setBounds(30, 230, 150, 25);
        add(lblname);

        JLabel labelname = new JLabel("");  // Placeholder for dynamic content
        labelname.setBounds(220, 230, 150, 25);
        add(labelname);

        JLabel lblgender = new JLabel("Gender:");
        lblgender.setBounds(30, 290, 150, 25);
        add(lblgender);

        JLabel labelgender = new JLabel("");  // Placeholder for dynamic content
        labelgender.setBounds(220, 290, 150, 25);
        add(labelgender);

        JLabel lblcountry = new JLabel("Country:");
        lblcountry.setBounds(500, 50, 150, 25);
        add(lblcountry);

        JLabel labelcountry = new JLabel("");  // Placeholder for dynamic content
        labelcountry.setBounds(690, 50, 150, 25);
        add(labelcountry);

        JLabel lbladdress = new JLabel("Address:");
        lbladdress.setBounds(500, 110, 150, 25);
        add(lbladdress);

        JLabel labeladdress = new JLabel("");  // Placeholder for dynamic content
        labeladdress.setBounds(690, 110, 150, 25);
        add(labeladdress);

        JLabel lblphone = new JLabel("Phone:");
        lblphone.setBounds(500, 170, 150, 25);
        add(lblphone);

        JLabel labelphone = new JLabel("");  // Placeholder for dynamic content
        labelphone.setBounds(690, 170, 150, 25);
        add(labelphone);

        JLabel lblemail = new JLabel("Email:");
        lblemail.setBounds(500, 230, 150, 25);
        add(lblemail);

        JLabel labelemail = new JLabel("");  // Placeholder for dynamic content
        labelemail.setBounds(690, 230, 370, 25);
        add(labelemail);

        back = new JButton("Back");
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
        back.setBounds(350, 350, 100, 25);
        back.addActionListener(this);  // Added action listener for the back button
        add(back);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/Viewall.jpg"));
        Image i2 = i1.getImage().getScaledInstance(600, 200, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(20, 400, 600, 200);
        add(image);

        ImageIcon i4 = new ImageIcon(ClassLoader.getSystemResource("icons/Viewall.jpg"));
        Image i5 = i4.getImage().getScaledInstance(600, 200, Image.SCALE_DEFAULT);
        ImageIcon i6 = new ImageIcon(i5);
        JLabel image2 = new JLabel(i6);
        image2.setBounds(600, 400, 600, 200);
        add(image2);

        // Fetch customer details from the database
        try {
            Conn conn = new Conn();
            String query = "SELECT * FROM Cx WHERE username = '" + username + "'";
            ResultSet rs = conn.s.executeQuery(query);

            if (rs.next()) {
                labelusername.setText(rs.getString("username"));
                labelid.setText(rs.getString("id"));
                labelnumber.setText(rs.getString("number"));
                labelname.setText(rs.getString("name"));
                labelgender.setText(rs.getString("gender"));
                labelcountry.setText(rs.getString("country"));
                labeladdress.setText(rs.getString("address"));
                labelphone.setText(rs.getString("phone"));
                labelemail.setText(rs.getString("email"));
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

    // Main method to test the ViewCustomer class
    public static void main(String[] args) {
        new ViewCustomer("riya25");  // Pass the username dynamically or test with a specific one
    }
}
