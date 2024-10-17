import javax.swing.*;
import java.awt.*;


public class CheckPackages extends JFrame  {
    CheckPackages() {
        setBounds(250,100,850,550);
        getContentPane().setBackground(Color.WHITE);

        String[] package1 = {"GOLD PACKAGE","7 Days and 6 Nights", "Airport Assistance", "Full Day City Tour","Daily Buffet", "Full Day 3 Island Cruise","English Speaking Guide","Summer Special", "Only Rs 12000","icons/package1.jpg"};
        String[] package2 = {"SILVER PACKAGE", "6 Days and 5 Nights","Toll Free and Entrance Free Tickets","Free Clubbing","Meet and Greet at Airport","Daily Buffet", "Full Day 2 Island Cruise", "Winter Special", "Only Rs 15000","icons/package2.jpg"};
        String[] package3 = {"BRONZE PACKAGE","5 Days and 4 Nights","Return Airfare","Free Clubbing","Horse Riding", "Full day 1 Island Cruise","Greetings", "Winter Special", "Only Rs 10000","icons/package3.jpg"  };

        JTabbedPane tab = new JTabbedPane();
        JPanel p1 = createPackage(package1);
        tab.addTab("Package 1",null,p1);

        JPanel p2 = createPackage(package2);
        tab.addTab("Package 2",null,p2);

        JPanel p3 = createPackage(package3);
        tab.addTab("Package 3",null,p3);


        add(tab);


        setVisible(true);
    }

    public JPanel createPackage(String[] pack) {

        JPanel p1 = new JPanel();
        p1.setLayout(null);
        p1.setBackground(Color.WHITE);



        JLabel l1 = new JLabel(pack[0]);
        l1.setBounds(300,10,300,30);
        l1.setForeground(Color.YELLOW);
        l1.setFont(new Font("Tahoma", Font.BOLD,30));
        p1.add(l1);

        JLabel l2 = new JLabel(pack[1]);
        l2.setBounds(30,60,300,25);
        l2.setForeground(Color.BLUE);
        l2.setFont(new Font("Tahoma", Font.BOLD,20));
        p1.add(l2);

        JLabel l3 = new JLabel(pack[2]);
        l3.setBounds(30,105,300,25);
        l3.setForeground(Color.RED);
        l3.setFont(new Font("Tahoma", Font.BOLD,20));
        p1.add(l3);

        JLabel l4 = new JLabel(pack[3]);
        l4.setBounds(30,150,300,25);
        l4.setForeground(Color.BLUE);
        l4.setFont(new Font("Tahoma", Font.BOLD,20));
        p1.add(l4);

        JLabel l5 = new JLabel(pack[4]);
        l5.setBounds(30,195,300,25);
        l5.setForeground(Color.RED);
        l5.setFont(new Font("Tahoma", Font.BOLD,20));
        p1.add(l5);

        JLabel l6 = new JLabel(pack[5]);
        l6.setBounds(30,240,300,25);
        l6.setForeground(Color.BLUE);
        l6.setFont(new Font("Tahoma", Font.BOLD,20));
        p1.add(l6);

        JLabel l7 = new JLabel(pack[6]);
        l7.setBounds(30,285,300,25);
        l7.setForeground(Color.RED);
        l7.setFont(new Font("Tahoma", Font.BOLD,20));
        p1.add(l7);

        JLabel l8 = new JLabel(pack[7]);
        l8.setBounds(30,330,300,25);
        l8.setForeground(Color.BLUE);
        l8.setFont(new Font("Tahoma", Font.BOLD,20));
        p1.add(l8);

        JLabel l9 = new JLabel("BOOK NOW");
        l9.setBounds(60,400,200,30);
        l9.setForeground(Color.BLACK);
        l9.setFont(new Font("Tahoma", Font.BOLD,25));
        p1.add(l9);

        JLabel l10 = new JLabel(pack[8]);
        l10.setBounds(470,400,250,30);
        l10.setForeground(Color.DARK_GRAY);
        l10.setFont(new Font("Tahoma", Font.BOLD,25));
        p1.add(l10);


        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource(pack[9]));
        Image i2 = i1.getImage().getScaledInstance(450,300,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(350,70,450,300);
        p1.add(image);
         return p1;
    }

    public static void main(String args[]) {
        new CheckPackages();
    }
}
