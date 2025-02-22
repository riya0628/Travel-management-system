package travel_management_system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class BookHotel extends JFrame implements ActionListener {
    Choice chotel, cac, cfood;
    JTextField tfpersons, tfdays;
    String username;
    JLabel labelusername, labelid, labelnumber, labelphone, labelprice;
    JButton checkprice, bookHotel, back;

    // Constructor matching the class name
    BookHotel(String username) {
        this.username = username;
        setBounds(350, 200, 1100, 600);
        setLayout(null);

        JLabel text = new JLabel("Book Hotel");
        text.setBounds(100, 10, 200, 30);
        text.setFont(new Font("Tahoma", Font.BOLD, 20));
        add(text);

        JLabel lblusername = new JLabel("Username:");
        lblusername.setFont(new Font("Tahoma", Font.PLAIN, 16));
        lblusername.setBounds(40, 70, 100, 25);
        add(lblusername);

        labelusername = new JLabel("");
        labelusername.setFont(new Font("Tahoma", Font.PLAIN, 16));
        labelusername.setBounds(250, 70, 200, 20);
        add(labelusername);

        JLabel lblhotel = new JLabel("Select Hotel:");
        lblhotel.setFont(new Font("Tahoma", Font.PLAIN, 16));
        lblhotel.setBounds(40, 110, 150, 20);
        add(lblhotel);

        chotel = new Choice();
        chotel.setBounds(250, 110, 200, 20);
        add(chotel);

        // Retrieve hotel names from the database
        try {
            Conn c = new Conn();
            ResultSet rs = c.s.executeQuery("select * from hotel");
            while (rs.next()) {
                chotel.add(rs.getString("name"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        JLabel lblpersons = new JLabel("Total Persons:");
        lblpersons.setFont(new Font("Tahoma", Font.PLAIN, 16));
        lblpersons.setBounds(40, 150, 150, 25);
        add(lblpersons);

        tfpersons = new JTextField("1");
        tfpersons.setBounds(250, 150, 200, 25);
        add(tfpersons);

        JLabel lbldays = new JLabel("Number of Days:");
        lbldays.setFont(new Font("Tahoma", Font.PLAIN, 16));
        lbldays.setBounds(40, 190, 150, 25);
        add(lbldays);

        tfdays = new JTextField("1");
        tfdays.setBounds(250, 190, 200, 25);
        add(tfdays);

        JLabel lblac = new JLabel("AC/Non-AC:");
        lblac.setFont(new Font("Tahoma", Font.PLAIN, 16));
        lblac.setBounds(40, 230, 150, 25);
        add(lblac);

        cac = new Choice();
        cac.add("AC");
        cac.add("Non-AC");
        cac.setBounds(250, 230, 200, 20);
        add(cac);

        JLabel lblfood = new JLabel("Food Included:");
        lblfood.setFont(new Font("Tahoma", Font.PLAIN, 16));
        lblfood.setBounds(40, 270, 150, 25);
        add(lblfood);

        cfood = new Choice();
        cfood.add("Yes");
        cfood.add("No");
        cfood.setBounds(250, 270, 200, 20);
        add(cfood);

        JLabel lblid = new JLabel("ID:");
        lblid.setFont(new Font("Tahoma", Font.PLAIN, 16));
        lblid.setBounds(40, 310, 150, 25);
        add(lblid);

        labelid = new JLabel("");
        labelid.setFont(new Font("Tahoma", Font.PLAIN, 16));
        labelid.setBounds(250, 310, 200, 25);
        add(labelid);

        JLabel lblnumber = new JLabel("Number:");
        lblnumber.setFont(new Font("Tahoma", Font.PLAIN, 16));
        lblnumber.setBounds(40, 350, 150, 25);
        add(lblnumber);

        labelnumber = new JLabel("");
        labelnumber.setFont(new Font("Tahoma", Font.PLAIN, 16));
        labelnumber.setBounds(250, 350, 200, 25);
        add(labelnumber);

        JLabel lblphone = new JLabel("Phone:");
        lblphone.setFont(new Font("Tahoma", Font.PLAIN, 16));
        lblphone.setBounds(40, 390, 150, 25);
        add(lblphone);

        labelphone = new JLabel("");
        labelphone.setFont(new Font("Tahoma", Font.PLAIN, 16));
        labelphone.setBounds(250, 390, 200, 25);
        add(labelphone);

        JLabel lbltotal = new JLabel("Total Price:");
        lbltotal.setFont(new Font("Tahoma", Font.PLAIN, 16));
        lbltotal.setBounds(40, 430, 150, 25);
        add(lbltotal);

        labelprice = new JLabel("");
        labelprice.setFont(new Font("Tahoma", Font.PLAIN, 16));
        labelprice.setBounds(250, 430, 150, 25);
        add(labelprice);

        // Retrieve customer information from the database
        try {
            Conn conn = new Conn();
            String query = "SELECT * FROM Cx WHERE username = '" + username + "'";
            ResultSet rs = conn.s.executeQuery(query);

            if (rs.next()) {
                labelusername.setText(rs.getString("username"));
                labelid.setText(rs.getString("id"));
                labelnumber.setText(rs.getString("number"));
                labelphone.setText(rs.getString("phone"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        checkprice = new JButton("Check Price");
        checkprice.setBackground(Color.BLACK);
        checkprice.setForeground(Color.WHITE);
        checkprice.setBounds(60, 490, 120, 25);
        checkprice.addActionListener(this);
        add(checkprice);

        bookHotel = new JButton("Book Hotel");
        bookHotel.setBackground(Color.BLACK);
        bookHotel.setForeground(Color.WHITE);
        bookHotel.setBounds(200, 490, 120, 25);
        bookHotel.addActionListener(this);
        add(bookHotel);

        back = new JButton("Back");
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
        back.setBounds(340, 490, 120, 25);
        back.addActionListener(this);
        add(back);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/book.jpg"));
        Image i2 = i1.getImage().getScaledInstance(600, 400, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel l12 = new JLabel(i3);
        l12.setBounds(500, 50, 600, 400);
        add(l12);

        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == checkprice) {
            try {
                Conn c = new Conn();
                ResultSet rs = c.s.executeQuery("SELECT * FROM hotel WHERE name = '" + chotel.getSelectedItem() + "'");

                if (rs.next()) {
                    int cost = Integer.parseInt(rs.getString("costperperson"));
                    int food = Integer.parseInt(rs.getString("foodincluded"));
                    int acroom = Integer.parseInt(rs.getString("acroom"));

                    int persons = Integer.parseInt(tfpersons.getText());
                    int days = Integer.parseInt(tfdays.getText());

                    String acselected = cac.getSelectedItem();
                    String foodselected = cfood.getSelectedItem();

                    int total = cost * persons * days;
                    if (acselected.equals("AC")) {
                        total += acroom * persons * days;
                    }
                    if (foodselected.equals("Yes")) {
                        total += food * persons * days;
                    }

                    labelprice.setText("Rs " + total);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else if (ae.getSource() == bookHotel) {
            try {
                Conn c = new Conn();
                c.s.executeUpdate("INSERT INTO bookhotel VALUES ('" + labelusername.getText() + "', '" + chotel.getSelectedItem() + "', '" + tfpersons.getText() + "', '" + tfdays.getText() + "', '" + cac.getSelectedItem() + "', '" + cfood.getSelectedItem() + "', '" + labelid.getText() + "', '" + labelnumber.getText() + "', '" + labelphone.getText() + "', '" + labelprice.getText() + "')");
                JOptionPane.showMessageDialog(null, "Hotel Booked Successfully");
                setVisible(false);
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else if (ae.getSource() == back) {
            setVisible(false);
        }
    }

    public static void main(String[] args) {
        new BookHotel("riya25"); // Pass the username as a string
    }
}
