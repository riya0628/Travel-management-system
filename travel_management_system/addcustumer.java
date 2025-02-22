package travel_management_system;

import javax.swing.*;
import java.awt.*;
import java.sql.*;
import java.awt.event.*;

public class addcustumer extends JFrame implements ActionListener {
    JLabel lblusername, lblname, labelname, lblnumber, labelusername, lblid, lblgender, lblcountry, lbladdress, lblphone, lblemail;
    JComboBox<String> comboid;
    JTextField tfnumber, tfcountry, tfphone, tfemail, tfaddress;
    JRadioButton rmale, rfemale;
    JButton addButton, backButton; // Renamed for clarity

    addcustumer(String username) {
        setBounds(450, 200, 850, 550);
        setLayout(null);
        getContentPane().setBackground(Color.WHITE);

        lblusername = new JLabel("Username");
        lblusername.setBounds(30, 50, 150, 25);
        add(lblusername);

        labelusername = new JLabel();
        labelusername.setBounds(220, 50, 150, 25);
        add(labelusername);

        lblid = new JLabel("ID");
        lblid.setBounds(30, 90, 150, 25);
        add(lblid);

        comboid = new JComboBox<>(new String[]{"Passport", "Aadhar Card", "Pan Card", "Ration Card"});
        comboid.setBounds(220, 90, 150, 25);
        comboid.setBackground(Color.WHITE);
        add(comboid);

        lblnumber = new JLabel("Number");
        lblnumber.setBounds(30, 130, 150, 25);
        add(lblnumber);

        tfnumber = new JTextField();
        tfnumber.setBounds(220, 130, 150, 25);
        add(tfnumber);

        lblname = new JLabel("Name");
        lblname.setBounds(30, 170, 150, 25);
        add(lblname);

        labelname = new JLabel();
        labelname.setBounds(220, 170, 150, 25);
        add(labelname);

        lblgender = new JLabel("Gender");
        lblgender.setBounds(30, 210, 150, 25);
        add(lblgender);

        rmale = new JRadioButton("Male");
        rmale.setBounds(220, 210, 70, 25);
        rmale.setBackground(Color.WHITE);
        add(rmale);

        rfemale = new JRadioButton("Female");
        rfemale.setBounds(300, 210, 70, 25);
        rfemale.setBackground(Color.WHITE);
        add(rfemale);

        ButtonGroup bg = new ButtonGroup();
        bg.add(rmale);
        bg.add(rfemale);

        lblcountry = new JLabel("Country");
        lblcountry.setBounds(30, 250, 150, 25);
        add(lblcountry);

        tfcountry = new JTextField();
        tfcountry.setBounds(220, 250, 150, 25);
        add(tfcountry);

        lbladdress = new JLabel("Address");
        lbladdress.setBounds(30, 290, 150, 25);
        add(lbladdress);

        tfaddress = new JTextField();
        tfaddress.setBounds(220, 290, 150, 25);
        add(tfaddress);

        lblphone = new JLabel("Phone");
        lblphone.setBounds(30, 330, 150, 25);
        add(lblphone);

        tfphone = new JTextField();
        tfphone.setBounds(220, 330, 150, 25);
        add(tfphone);

        lblemail = new JLabel("E-Mail");
        lblemail.setBounds(30, 370, 150, 25);
        add(lblemail);

        tfemail = new JTextField();
        tfemail.setBounds(220, 370, 150, 25);
        add(tfemail);

        addButton = new JButton("Add"); // Renamed for clarity
        addButton.setBackground(Color.BLACK);
        addButton.setForeground(Color.WHITE);
        addButton.setBounds(70, 430, 100, 25);
        add(addButton);
        addButton.addActionListener(this);

        backButton = new JButton("Back"); // Renamed for clarity
        backButton.setBackground(Color.BLACK);
        backButton.setForeground(Color.WHITE);
        backButton.setBounds(220, 430, 100, 25);
        add(backButton);
        backButton.addActionListener(this);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/newcustomer.jpg"));
        Image i2 = i1.getImage().getScaledInstance(400, 500, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(400, 40, 450, 420);
        add(image);

        // Fetch customer data from the database
        try {
            Conn c = new Conn();
            ResultSet rs = c.s.executeQuery("SELECT * FROM Taccount WHERE username='" + username + "'");
            while (rs.next()) {
                labelusername.setText(rs.getString("username"));
                labelname.setText(rs.getString("name"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == addButton) { // Changed to renamed button
            String username = labelusername.getText();
            String id = (String) comboid.getSelectedItem();
            String number = tfnumber.getText();
            String name = labelname.getText();
            String gender = rmale.isSelected() ? "Male" : "Female"; // Simplified gender assignment
            String country = tfcountry.getText();
            String address = tfaddress.getText();
            String phone = tfphone.getText();
            String email = tfemail.getText();

            try {
                Conn c = new Conn();
                String query = "INSERT INTO Cx VALUES('" + username + "', '" + id + "', '" + number + "', '" + name + "', '" + gender + "', '" + country + "', '" + address + "', '" + phone + "', '" + email + "')";
                c.s.executeUpdate(query);
                JOptionPane.showMessageDialog(null, "Customer Details Added Successfully");
                setVisible(false);
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else if (ae.getSource() == backButton) { // Changed to renamed button
            setVisible(false);
        }
    }

    public static void main(String[] args) {
        new addcustumer("riya25"); // Object creation
    }
}
