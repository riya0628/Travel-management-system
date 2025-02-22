 package travel_management_system;

import javax.swing.*;
import java.awt.*;
import java.sql.*;
import java.awt.event.*;

public class ViewBookedHotel extends JFrame implements ActionListener {

    JButton back;

    // Constructor to take 'username' as input
    ViewBookedHotel(String username) {
        
        // Frame settings
        setBounds(400, 200, 1000, 600);
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        
        JLabel text = new JLabel("View Booked Hotel Details");
        text.setFont(new Font("Tahoma", Font.BOLD, 20));
        text.setBounds(60, 0, 300, 30);
        add(text);

        // Labels for displaying customer details
        JLabel lblusername = new JLabel("Username:");
        lblusername.setBounds(30, 50, 150, 25);
        add(lblusername);

        JLabel labelusername = new JLabel("");
        labelusername.setBounds(220, 50, 150, 25);
        add(labelusername);

        JLabel lblpackage = new JLabel("Hotel Name:");
        lblpackage.setBounds(30, 90, 150, 25);
        add(lblpackage);

        JLabel labelpackage = new JLabel("");
        labelpackage.setBounds(220, 90, 150, 25);
        add(labelpackage);

        JLabel lblpersons = new JLabel("Total Person:");
        lblpersons.setBounds(30, 130, 150, 25);
        add(lblpersons);

        JLabel labelpersons = new JLabel("");
        labelpersons.setBounds(220, 130, 150, 25);
        add(labelpersons);

        JLabel lblid = new JLabel("ID:");
        lblid.setBounds(30, 170, 150, 25);
        add(lblid);

        JLabel labelid = new JLabel("");
        labelid.setBounds(220, 170, 150, 25);
        add(labelid);

        JLabel lbldays = new JLabel("Total Days:");
        lbldays.setBounds(30, 210, 150, 25);
        add(lbldays);

        JLabel labeldays = new JLabel("");
        labeldays.setBounds(220, 210, 150, 25);
        add(labeldays);

        JLabel lblac = new JLabel("AC/Non-AC:");
        lblac.setBounds(30, 250, 150, 25);
        add(lblac);

        JLabel labelac = new JLabel("");
        labelac.setBounds(220, 250, 150, 25);
        add(labelac);

        JLabel lblfood = new JLabel("Food Included ?:");
        lblfood.setBounds(30, 290, 150, 25);
        add(lblfood);

        JLabel labelfood = new JLabel("");
        labelfood.setBounds(220, 290, 150, 25);
        add(labelfood);

        JLabel lblphone = new JLabel("Phone:");
        lblphone.setBounds(30, 330, 150, 25);
        add(lblphone);

        JLabel labelphone = new JLabel("");
        labelphone.setBounds(220, 330, 150, 25);
        add(labelphone);

        JLabel lblprice = new JLabel("Total Cost :");
        lblprice.setBounds(30, 370, 150, 25);
        add(lblprice);

        JLabel labelprice = new JLabel("");
        labelprice.setBounds(220, 370, 150, 25);
        add(labelprice);

        back = new JButton("Back");
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
        back.setBounds(130, 420, 100, 25);
        back.addActionListener(this);
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
            String query = "SELECT * FROM bookhotel WHERE username = '" + username + "'";
            ResultSet rs = conn.s.executeQuery(query);

            if (rs.next()) {
                labelusername.setText(rs.getString("username"));
                labelpackage.setText(rs.getString("hotel"));
                labelpersons.setText(rs.getString("persons"));
                labelid.setText(rs.getString("id"));
                labeldays.setText(rs.getString("days"));
                labelac.setText(rs.getString("ac"));
                labelfood.setText(rs.getString("food"));
                labelphone.setText(rs.getString("phone"));
                labelprice.setText(rs.getString("price"));
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
            setVisible(false);
        }
    }

    // Main method to test the ViewBookedHotel class
    public static void main(String[] args) {
        new ViewBookedHotel("riya25");
    }
}
