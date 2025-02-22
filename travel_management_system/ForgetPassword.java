package travel_management_system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class ForgetPassword extends JFrame implements ActionListener {
    JTextField tfname, tfquestion, tfusername, tfanswer, tfpassword;
    JButton search, retrieve, back;

    ForgetPassword() {
        setBounds(350, 200, 850, 380);
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/forgotpassword.jpg"));
        Image i2 = i1.getImage().getScaledInstance(200, 200, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(580, 70, 200, 200);
        add(image);

        JPanel p1 = new JPanel();
        p1.setLayout(null);
        p1.setBounds(30, 30, 500, 300); 
        add(p1);

        JLabel lbusername = new JLabel("Username");
        lbusername.setBounds(40, 20, 100, 25);
        lbusername.setFont(new Font("SAN SERIF", Font.PLAIN, 20));
        p1.add(lbusername);

        tfusername = new JTextField();
        tfusername.setBounds(220, 20, 150, 25);
        tfusername.setBorder(BorderFactory.createEmptyBorder());
        p1.add(tfusername);

        search = new JButton("Search");
        search.setBackground(Color.GRAY);
        search.setForeground(Color.WHITE);
        search.setBounds(380, 20, 100, 25);
        search.addActionListener(this);
        p1.add(search);

        JLabel lblname = new JLabel("Name");
        lblname.setBounds(40, 60, 100, 25);
        lblname.setFont(new Font("SAN SERIF", Font.PLAIN, 20));
        p1.add(lblname);

        tfname = new JTextField();
        tfname.setBounds(220, 60, 150, 25);
        tfname.setBorder(BorderFactory.createEmptyBorder());
        p1.add(tfname);

        JLabel lblquestion = new JLabel("Security Ques");
        lblquestion.setBounds(40, 100, 150, 25);
        lblquestion.setFont(new Font("SAN SERIF", Font.PLAIN, 20));
        p1.add(lblquestion);

        tfquestion = new JTextField();
        tfquestion.setBounds(220, 100, 150, 25);
        tfquestion.setBorder(BorderFactory.createEmptyBorder());
        p1.add(tfquestion);

        JLabel lblanswer = new JLabel("Your Answer");
        lblanswer.setBounds(40, 140, 150, 25);
        lblanswer.setFont(new Font("SAN SERIF", Font.PLAIN, 20));
        p1.add(lblanswer);

        tfanswer = new JTextField();
        tfanswer.setBounds(220, 140, 150, 25);
        p1.add(tfanswer);

        retrieve = new JButton("Retrieve");
        retrieve.setBounds(380, 140, 100, 25);
        retrieve.setBackground(Color.GRAY);
        retrieve.setForeground(Color.WHITE);
        retrieve.addActionListener(this);
        p1.add(retrieve);

        JLabel lblpassword = new JLabel("Password");
        lblpassword.setBounds(40, 180, 150, 25);
        lblpassword.setFont(new Font("SAN SERIF", Font.PLAIN, 20));
        p1.add(lblpassword);

        tfpassword = new JTextField();
        tfpassword.setBounds(220, 180, 150, 25);
        tfpassword.setBorder(BorderFactory.createEmptyBorder());
        p1.add(tfpassword);

        back = new JButton("Back");
        back.setBackground(Color.GRAY);
        back.setForeground(Color.WHITE);
        back.setBounds(150, 230, 100, 25);
        back.addActionListener(this);
        p1.add(back);

        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == search) {
            try {
                // SQL query to find the username in the account
                String query = "SELECT * FROM Taccount WHERE username = '" + tfusername.getText() + "'";
                Conn c = new Conn();
                ResultSet rs = c.s.executeQuery(query);

                if (rs.next()) {
                    // Populate the name and security question fields
                    tfname.setText(rs.getString("name"));
                    tfquestion.setText(rs.getString("question"));
                } else {
                    JOptionPane.showMessageDialog(null, "Username not found!");
                }

            } catch (Exception e) {
                e.printStackTrace();
            }
        } else if (ae.getSource() == retrieve) {
            try {
                // Check if the security answer is correct and retrieve the password
                String query = "SELECT * FROM Taccount WHERE username = '" + tfusername.getText() + "' AND answer = '" + tfanswer.getText() + "'";
                Conn c = new Conn();
                ResultSet rs = c.s.executeQuery(query);

                if (rs.next()) {
                    // Display the password in the password text field
                    tfpassword.setText(rs.getString("password"));
                } else {
                    JOptionPane.showMessageDialog(null, "Incorrect answer!");
                }

            } catch (Exception e) {
                e.printStackTrace();
            }
        } else if (ae.getSource() == back) {
            // Close current window and open the login screen
            setVisible(false);
            new Login();
        }
    }

    public static void main(String[] args) {
        new ForgetPassword();
    }
}
