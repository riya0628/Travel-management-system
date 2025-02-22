package travel_management_system;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class About extends JFrame implements ActionListener {
    About() {
        // Frame settings
        setBounds(600, 200, 500, 550);
        setLayout(null);
        getContentPane().setBackground(Color.WHITE);

        // Title label
        JLabel l1 = new JLabel("ABOUT");
        l1.setBounds(150, 10, 100, 40);
        l1.setForeground(Color.RED);
        l1.setFont(new Font("Tahoma", Font.PLAIN, 20));
        add(l1);

        // TextArea with travel management system details
        String aboutText = "Travel Management System Application:\n\n"
                + "This system is designed to simplify and automate the process of managing travel plans. "
                + "It allows users to book travel packages, reserve hotels, and track personal details with ease. "
                + "The goal is to provide a user-friendly platform that enhances the overall travel experience, "
                + "from viewing destinations and booking accommodations to making payments and managing itineraries. "
                + "Our system offers convenience, efficiency, and transparency in handling all travel-related needs.";
        
        TextArea area = new TextArea(aboutText, 10, 40, Scrollbar.VERTICAL);
        area.setEditable(false);
        area.setBounds(20, 100, 400, 300);
        add(area);
JButton back =new JButton("Back");
back.setBounds(200,420,80,40);
back.addActionListener(this);
add(back);
        // Frame visibility
        setVisible(true);
    }
public void actionPerformed(ActionEvent ae){
setVisible(false);

}
    public static void main(String args[]) {
        new About();
    }
}
