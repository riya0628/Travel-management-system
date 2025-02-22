package travel_management_system;

import javax.swing.*;
import java.awt.*;

public class Destination extends JFrame implements Runnable {
    Thread t1;
    JLabel[] label = new JLabel[10];
JLabel caption ;
    public void run() {
        String []text=new String []{"JW Marriot Hotel","Madarin Oriental Hotel" ,"Four Seasons Hotel","Raddison Blue Hotel","Classio Hotel","The Bay Club Hotel","Taj Hotel","happy Moring Hotel","River View Hotel","Snow Pint Hotel"};
        
        try {
            // Loop through each image in the label array
            for (int i = 0; i < 9; i++) {
                label[i].setVisible(true);
               
                Thread.sleep(2500);  // Delay between each image
                label[i].setVisible(false);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    Destination() {
        // Set frame properties
        setBounds(500, 200, 800, 600);
caption =new JLabel ();
caption.setBounds(50,500,1000,70);
caption.setFont(new Font("Tahoma",Font.PLAIN,40));
caption.setForeground(Color.WHITE);
add(caption);
        // Arrays to hold images and icons
        ImageIcon[] image = new ImageIcon[10];
        Image[] jimage = new Image[10];
        ImageIcon[] kimage = new ImageIcon[10];

        // Loop through to load images, scale them, and add to labels
        for (int i = 0; i < 9; i++) {
            image[i] = new ImageIcon(ClassLoader.getSystemResource("icons/dest" + (i + 1) + ".jpg"));
            jimage[i] = image[i].getImage().getScaledInstance(800, 600, Image.SCALE_DEFAULT);
            kimage[i] = new ImageIcon(jimage[i]);
            label[i] = new JLabel(kimage[i]);
            label[i].setBounds(0, 0, 800, 600);
            label[i].setVisible(false); // Initially hide the label
            add(label[i]);
        }

        // Start the thread
        t1 = new Thread(this);
        t1.start();

        // Set frame visibility and close operation
        setLayout(null);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public static void main(String[] args) {
        new Destination();
    }
}

