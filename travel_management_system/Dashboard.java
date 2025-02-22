package travel_management_system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Dashboard extends JFrame implements ActionListener {
    String username;
    JButton addPersonalDetails, viewPersonalDetails, updatePersonalDetails, checkPackages, viewPackage, bookPackage, viewHotels, destination, bookHotel, viewBookedHotel, payment, calculators, notepad, about;

    Dashboard(String username) {
        this.username = username;
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setLayout(null);

        // Top panel
        JPanel p1 = new JPanel();
        p1.setLayout(null);
        p1.setBackground(new Color(0, 0, 102));
        p1.setBounds(0, 0, 1600, 65);
        add(p1);

        // Dashboard icon
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/dashboard.png"));
        Image i2 = i1.getImage().getScaledInstance(70, 70, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel icon = new JLabel(i3);
        icon.setBounds(5, 0, 70, 70);
        p1.add(icon);

        // Dashboard label
        JLabel heading = new JLabel("Dashboard");
        heading.setBounds(80, 10, 300, 40);
        heading.setForeground(Color.WHITE);
        heading.setFont(new Font("Tahoma", Font.BOLD, 30));
        p1.add(heading);

        // Left panel for navigation buttons
        JPanel p2 = new JPanel();
        p2.setLayout(null);
        p2.setBackground(new Color(0, 0, 102));
        p2.setBounds(0, 65, 300, 900);
        add(p2);

        // Buttons for different sections
        addPersonalDetails = createButton("Add Personal Details", 0);
        updatePersonalDetails = createButton("Update Personal Details", 50);
        viewPersonalDetails = createButton("Personal Details", 100);
        JButton deletePersonalDetails = createButton("Delete Personal Details", 150);
        checkPackages = createButton("Check Packages", 200);
        bookPackage = createButton("Book Package", 250);
        viewPackage = createButton("View Package", 300);
        viewHotels = createButton("View Hotels", 350);
        bookHotel = createButton("Book Hotel", 400);
        viewBookedHotel = createButton("View Booked Hotel", 450);
        destination = createButton("Destination", 500);
        payment = createButton("Payment", 550);
        calculators = createButton("Calculator", 600);
        notepad = createButton("Notepad", 650);
        about = createButton("About", 700);

        p2.add(addPersonalDetails);
        p2.add(updatePersonalDetails);
        p2.add(viewPersonalDetails);
        p2.add(deletePersonalDetails);
        p2.add(checkPackages);
        p2.add(bookPackage);
        p2.add(viewPackage);
        p2.add(viewHotels);
        p2.add(bookHotel);
        p2.add(viewBookedHotel);
        p2.add(destination);
        p2.add(payment);
        p2.add(calculators);
        p2.add(notepad);
        p2.add(about);

        // Background image
        ImageIcon i4 = new ImageIcon(ClassLoader.getSystemResource("icons/home.jpg"));
        Image i5 = i4.getImage().getScaledInstance(1650, 1000, Image.SCALE_DEFAULT);
        ImageIcon i6 = new ImageIcon(i5);
        JLabel image = new JLabel(i6);
        image.setBounds(0, 0, 1650, 1000);
        add(image);

        // Text on the background image
        JLabel text = new JLabel("Travel and Tourism Management System");
        text.setBounds(400, 70, 1200, 70);
        text.setForeground(Color.WHITE);
        text.setFont(new Font("Raleway", Font.PLAIN, 55));
        image.add(text);

        setVisible(true);
    }

    // Helper method to create buttons
    private JButton createButton(String text, int yPosition) {
        JButton button = new JButton(text);
        button.setBounds(0, yPosition, 300, 50);
        button.setBackground(new Color(0, 0, 102));
        button.setForeground(Color.WHITE);
        button.setFont(new Font("Tahoma", Font.BOLD, 20));
        button.setMargin(new Insets(0, 0, 0, 130));
        button.addActionListener(this);
        return button;
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == addPersonalDetails) {
            new addcustumer(username); // Ensure that the AddCustomer class exists
        } else if (ae.getSource() == viewPersonalDetails) {
            new ViewCustomer(username);
        } else if (ae.getSource() == updatePersonalDetails) {
            new UpdateCustomer(username);
        } else if (ae.getSource() == checkPackages) {
            new CheckPackage();
        } else if (ae.getSource() == bookPackage) {
            new BookPackage(username);
        } else if (ae.getSource() == viewPackage) {
            new ViewPackage(username);
        } else if (ae.getSource() == viewHotels) {
            new CheckHotels();
        } else if (ae.getSource() == destination) {
            new Destination();
        } else if (ae.getSource() == bookHotel) {
            new BookHotel(username);
        } else if (ae.getSource() == viewBookedHotel) {
            new ViewBookedHotel(username);
        } else if (ae.getSource() == payment) {
            new Payment();
        } else if (ae.getSource() == calculators) {
            try {
                Runtime.getRuntime().exec("calc.exe");
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else if (ae.getSource() == notepad) {
            try {
                Runtime.getRuntime().exec("notepad.exe");
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else if (ae.getSource() == about) {
            new About();
        }
    }

    public static void main(String[] args) {
        new Dashboard("riya25");
    }
}
