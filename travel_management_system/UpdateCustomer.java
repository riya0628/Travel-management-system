package travel_management_system;

import javax.swing.*;
import java.awt.*;
import java.sql.*;
import java.awt.event.*;

public class UpdateCustomer extends JFrame implements ActionListener {
    JLabel lblusername, lblname, labelname, lblnumber, labelusername, lblid, lblgender, lblcountry, lbladdress, lblphone, lblemail;
    JTextField tfnumber, tfcountry, tfphone, tfemail, tfaddress;
    JButton add, back;
    JTextField tfid, tfgender;

    // Constructor
    UpdateCustomer(String username) {
        setBounds(500, 200, 850, 550);
        setLayout(null);
        getContentPane().setBackground(Color.WHITE);

        JLabel text = new JLabel("UPDATE CUSTOMER DETAILS");
        text.setBounds(50, 0, 300, 25);
        text.setFont(new Font("Tahoma", Font.PLAIN, 20));
        add(text);

        // Username label
        lblusername = new JLabel("Username");
        lblusername.setBounds(30, 50, 150, 25);
        add(lblusername);

        labelusername = new JLabel();
        labelusername.setBounds(220, 50, 150, 25);
        add(labelusername);

        // ID label and text field
        lblid = new JLabel("ID");
        lblid.setBounds(30, 90, 150, 25);
        add(lblid);

        tfid = new JTextField();
        tfid.setBounds(220, 90, 150, 25);
        add(tfid);

        // Number label and text field
        lblnumber = new JLabel("Number");
        lblnumber.setBounds(30, 130, 150, 25);
        add(lblnumber);

        tfnumber = new JTextField();
        tfnumber.setBounds(220, 130, 150, 25);
        add(tfnumber);

        // Name label
        lblname = new JLabel("Name");
        lblname.setBounds(30, 170, 150, 25);
        add(lblname);

        labelname = new JLabel(); // Initialize labelname
        labelname.setBounds(220, 170, 150, 25);
        add(labelname);

        // Gender label and text field
        lblgender = new JLabel("Gender");
        lblgender.setBounds(30, 210, 150, 25);
        add(lblgender);

        tfgender = new JTextField();
        tfgender.setBounds(220, 210, 150, 25);
        add(tfgender);

        // Country label and text field
        lblcountry = new JLabel("Country");
        lblcountry.setBounds(30, 250, 150, 25);
        add(lblcountry);

        tfcountry = new JTextField();
        tfcountry.setBounds(220, 250, 150, 25);
        add(tfcountry);

        // Address label and text field
        lbladdress = new JLabel("Address");
        lbladdress.setBounds(30, 290, 150, 25);
        add(lbladdress);

        tfaddress = new JTextField();
        tfaddress.setBounds(220, 290, 150, 25);
        add(tfaddress);

        // Phone label and text field
        lblphone = new JLabel("Phone");
        lblphone.setBounds(30, 330, 150, 25);
        add(lblphone);

        tfphone = new JTextField();
        tfphone.setBounds(220, 330, 150, 25);
        add(tfphone);

        // Email label and text field
        lblemail = new JLabel("E Mail");
        lblemail.setBounds(30, 370, 150, 25);
        add(lblemail);

        tfemail = new JTextField();
        tfemail.setBounds(220, 370, 150, 25);
        add(tfemail);

        // Buttons
        add = new JButton("Update");
        add.setBackground(Color.BLACK);
        add.setForeground(Color.WHITE);
        add.setBounds(70, 430, 100, 25);
        add(add);
        add.addActionListener(this);

        back = new JButton("Back");
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
        back.setBounds(220, 430, 100, 25);
        add(back);
        back.addActionListener(this);

        // Image
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/update.png"));
        Image i2 = i1.getImage().getScaledInstance(400, 300, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(400, 100, 450, 300);
        add(image);

        // Fetch customer details from the database
        try {
            Conn c = new Conn(); // Assuming Conn is your database connection class
            ResultSet rs = c.s.executeQuery("SELECT * FROM Cx WHERE username='" + username + "'");
            while (rs.next()) {
                labelusername.setText(rs.getString("username"));
                labelname.setText(rs.getString("name"));
                tfid.setText(rs.getString("id"));
                tfnumber.setText(rs.getString("number"));
                tfgender.setText(rs.getString("gender"));
                tfcountry.setText(rs.getString("country"));
                tfaddress.setText(rs.getString("address"));
                tfphone.setText(rs.getString("phone"));
                tfemail.setText(rs.getString("email"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        setVisible(true);
    }

    // Action performed method for buttons
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == add) {
            String username = labelusername.getText();
            String id = tfid.getText();
            String number = tfnumber.getText();
            String name = labelname.getText();
            String gender = tfgender.getText();
            String country = tfcountry.getText();
            String address = tfaddress.getText();
            String phone = tfphone.getText();
            String email = tfemail.getText();

            try {
                Conn c = new Conn();
                String query = "UPDATE Cx SET        username = '"+username+"',id='" + id + "', number='" + number + "',name='"+name+"', gender='" + gender + "', country='" + country + "', address='" + address + "', phone='" + phone + "', email='" + email + "' WHERE username='" + username + "'";
                c.s.executeUpdate(query);
                JOptionPane.showMessageDialog(null, "Customer Details Updated Successfully");
                setVisible(false);
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else if (ae.getSource() == back) {
            setVisible(false);
        }
    }

    public static void main(String[] args) {
        new UpdateCustomer("riya25"); // Corrected class name in object creation
    }
}
