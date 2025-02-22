package travel_management_system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.border.LineBorder;
import java.sql.*;

public class Login extends JFrame implements ActionListener {
    JButton login, signup, password;
    JTextField tfusername;
    JPasswordField tfpassword;  // Use JPasswordField for passwords

    // Constructor to set up the UI
    Login() {
        setSize(900, 400);
        setLocation(350, 200);
        setLayout(null);
        getContentPane().setBackground(Color.WHITE);

        // Panel for the left side
        JPanel p1 = new JPanel();
        p1.setBackground(new Color(131, 193, 233));
        p1.setBounds(0, 0, 400, 400);
        p1.setLayout(null);
        add(p1);

        // Add an image to the left panel
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/login.png"));
        Image i2 = i1.getImage().getScaledInstance(200, 200, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(100, 120, 200, 200);
        p1.add(image);

        // Panel for the right side (Login form)
        JPanel p2 = new JPanel();
        p2.setLayout(null);
        p2.setBounds(400, 30, 450, 300);
        add(p2);

        // Username label and text field
        JLabel lblusername = new JLabel("Username");
        lblusername.setBounds(60, 20, 100, 25);
        lblusername.setFont(new Font("SAN SERIF", Font.PLAIN, 20));
        p2.add(lblusername);

        tfusername = new JTextField();
        tfusername.setBounds(60, 60, 300, 30);
        tfusername.setBorder(BorderFactory.createEmptyBorder());
        p2.add(tfusername);

        // Password label and text field
        JLabel lblpassword = new JLabel("Password");
        lblpassword.setBounds(60, 110, 100, 25);
        lblpassword.setFont(new Font("SAN SERIF", Font.PLAIN, 20));
        p2.add(lblpassword);

        tfpassword = new JPasswordField();  // Using JPasswordField
        tfpassword.setBounds(60, 150, 300, 30);
        tfpassword.setBorder(BorderFactory.createEmptyBorder());
        p2.add(tfpassword);

        // Login button
        login = new JButton("Login");
        login.setBounds(60, 200, 130, 30);
        login.setBackground(new Color(133, 193, 233));
        login.setForeground(Color.WHITE);
        login.setBorder(new LineBorder(new Color(133, 193, 233)));
        login.addActionListener(this);
        p2.add(login);

        // Signup button
        signup = new JButton("Signup");
        signup.setBounds(230, 200, 130, 30);
        signup.setBackground(new Color(133, 193, 233));
        signup.setForeground(Color.WHITE);
        signup.setBorder(new LineBorder(new Color(133, 193, 233)));
        signup.addActionListener(this);
        p2.add(signup);

        // Forget password button
        password = new JButton("Forget Password");
        password.setBounds(130, 250, 130, 30);
        password.setBackground(new Color(133, 193, 233));
        password.setForeground(Color.WHITE);
        password.setBorder(new LineBorder(new Color(133, 193, 233)));
        password.addActionListener(this);
        p2.add(password);

        // Trouble text
        JLabel text = new JLabel("Trouble in login?");
        text.setBounds(300, 250, 150, 20);
        p2.add(text);

        // Make the frame visible
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        // Handle login button click
        if (ae.getSource() == login) {
            try {
                String username = tfusername.getText();
                String pass = new String(tfpassword.getPassword());  // Get password securely

                // Use PreparedStatement to avoid SQL injection
                String query = "SELECT * FROM Taccount WHERE username  AND password ";
                Conn c = new Conn();  // Assuming Conn is your database connection class

                // Prepare the statement
                /*PreparedStatement pstmt = c.c.prepareStatement(query);
                pstmt.setString(1, username);
                pstmt.setString(2, pass);*/

                ResultSet rs = c.s.executeQuery(query);

                if (rs.next()) {
                    setVisible(false);
                    new Loading(username);  // Proceed to the next window with username
                } else {
                    JOptionPane.showMessageDialog(null, "Incorrect username or password");
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        // Handle signup button click
        else if (ae.getSource() == signup) {
            setVisible(false);
            new signup();  // Assuming Signup is another window
        }
        // Handle forget password button click
        else if (ae.getSource() == password) {
            setVisible(false);
            new ForgetPassword();  // Assuming ForgetPassword is another window
        }
    }

    public static void main(String[] args) {
        new Login();
    }
}
