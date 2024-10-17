import javax.print.attribute.standard.Destination;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Dashboard extends JFrame implements ActionListener {
    String username;
    JButton viewpersonalDetails, addpersonaldetails, updatepersonalDetails, deletepersonalDetails,checkpackages, bookpackages;
    JButton viewpackages, viewhotels, viewbookedhotels, bookhotels,calculator, notepad, destinations, payment, about;
    Dashboard(String username) {
        this.username = username;
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setLayout(null);

        JPanel p1 = new JPanel();
        p1.setLayout(null);
        p1.setBackground(new Color(0,0,102));
        p1.setBounds(0,0,1500,65);
        add(p1);

         ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/dashboard.png"));
         Image i2 = i1.getImage().getScaledInstance(70,70,Image.SCALE_DEFAULT);
         ImageIcon i3 = new ImageIcon(i2);
         JLabel icon = new JLabel(i3);
         icon.setBounds(5,0,70,70);
         p1.add(icon);

         JLabel heading = new JLabel("Dashboard");
         heading.setBounds(80,10,300,40);
         heading.setForeground(Color.WHITE);
         heading.setFont(new Font("Tahoma",Font.BOLD,30));
         p1.add(heading);

        JPanel p2 = new JPanel();
        p2.setLayout(null);
        p2.setBackground(new Color(0,0,102));
        p2.setBounds(0,65,250,800);
        add(p2);

        addpersonaldetails = new JButton("Add Personal Details");
        addpersonaldetails.setBounds(0,0,250,40);
        addpersonaldetails.setBackground(new Color(0,0,102));
        addpersonaldetails.setForeground(Color.WHITE);
        addpersonaldetails.setFont(new Font("Tahoma",Font.PLAIN,18));
        addpersonaldetails.addActionListener(this);
        p2.add(addpersonaldetails);

        updatepersonalDetails = new JButton("Update Personal Details");
        updatepersonalDetails.setBounds(0,40,250,40);
        updatepersonalDetails.setBackground(new Color(0,0,102));
        updatepersonalDetails.setForeground(Color.WHITE);
        updatepersonalDetails.setFont(new Font("Tahoma",Font.PLAIN,18));
        updatepersonalDetails.addActionListener(this);
        p2.add(updatepersonalDetails);

        viewpersonalDetails = new JButton("View Details");
        viewpersonalDetails.setBounds(0,80,250,40);
        viewpersonalDetails.setBackground(new Color(0,0,102));
        viewpersonalDetails.setForeground(Color.WHITE);
        viewpersonalDetails.setFont(new Font("Tahoma",Font.PLAIN,18));
        viewpersonalDetails.addActionListener(this);
        p2.add(viewpersonalDetails);

        deletepersonalDetails = new JButton("Delete Personal Details");
        deletepersonalDetails.setBounds(0,120,250,40);
        deletepersonalDetails.setBackground(new Color(0,0,102));
        deletepersonalDetails.setForeground(Color.WHITE);
        deletepersonalDetails.setFont(new Font("Tahoma",Font.PLAIN,18));
        deletepersonalDetails.addActionListener(this);
        p2.add(deletepersonalDetails);

        checkpackages = new JButton("Check Packages");
        checkpackages.setBounds(0,160,250,40);
        checkpackages.setBackground(new Color(0,0,102));
        checkpackages.setForeground(Color.WHITE);
        checkpackages.setFont(new Font("Tahoma",Font.PLAIN,18));
        checkpackages.addActionListener(this);
        p2.add(checkpackages);

        bookpackages = new JButton("Book Packages");
        bookpackages.setBounds(0,200,250,40);
        bookpackages.setBackground(new Color(0,0,102));
        bookpackages.setForeground(Color.WHITE);
        bookpackages.setFont(new Font("Tahoma",Font.PLAIN,18));
        bookpackages.addActionListener(this);
        p2.add(bookpackages);

        viewpackages = new JButton("View Packages");
        viewpackages.setBounds(0,240,250,40);
        viewpackages.setBackground(new Color(0,0,102));
        viewpackages.setForeground(Color.WHITE);
        viewpackages.setFont(new Font("Tahoma",Font.PLAIN,18));
        viewpackages.addActionListener(this);
        p2.add(viewpackages);

        viewhotels = new JButton("View Hotels");
        viewhotels.setBounds(0,280,250,40);
        viewhotels.setBackground(new Color(0,0,102));
        viewhotels.setForeground(Color.WHITE);
        viewhotels.setFont(new Font("Tahoma",Font.PLAIN,18));
        viewhotels.addActionListener(this);
        p2.add(viewhotels);

        bookhotels = new JButton("Book Hotels");
        bookhotels.setBounds(0,320,250,40);
        bookhotels.setBackground(new Color(0,0,102));
        bookhotels.setForeground(Color.WHITE);
        bookhotels.setFont(new Font("Tahoma",Font.PLAIN,18));
        bookhotels.addActionListener(this);
        p2.add(bookhotels);

        viewbookedhotels = new JButton("View Booked Hotels");
        viewbookedhotels.setBounds(0,360,250,40);
        viewbookedhotels.setBackground(new Color(0,0,102));
        viewbookedhotels.setForeground(Color.WHITE);
        viewbookedhotels.setFont(new Font("Tahoma",Font.PLAIN,18));
        viewbookedhotels.addActionListener(this);
        p2.add(viewbookedhotels);

        destinations = new JButton("Destinations");
        destinations.setBounds(0,400,250,40);
        destinations.setBackground(new Color(0,0,102));
        destinations.setForeground(Color.WHITE);
        destinations.setFont(new Font("Tahoma",Font.PLAIN,18));
        destinations.addActionListener(this);
        p2.add(destinations);

        payment = new JButton("Payments");
        payment.setBounds(0,440,250,40);
        payment.setBackground(new Color(0,0,102));
        payment.setForeground(Color.WHITE);
        payment.setFont(new Font("Tahoma",Font.PLAIN,18));
        payment.addActionListener(this);
        p2.add(payment);

        calculator = new JButton("Calculator");
        calculator.setBounds(0,480,250,40);
        calculator.setBackground(new Color(0,0,102));
        calculator.setForeground(Color.WHITE);
        calculator.setFont(new Font("Tahoma",Font.PLAIN,18));
        calculator.addActionListener(this);
        p2.add(calculator);

        notepad = new JButton("Notepad");
        notepad.setBounds(0,520,250,40);
        notepad.setBackground(new Color(0,0,102));
        notepad.setForeground(Color.WHITE);
        notepad.setFont(new Font("Tahoma",Font.PLAIN,18));
        notepad.addActionListener(this);
        p2.add(notepad);

        about = new JButton("About");
        about.setBounds(0,560,250,40);
        about.setBackground(new Color(0,0,102));
        about.setForeground(Color.WHITE);
        about.setFont(new Font("Tahoma",Font.PLAIN,18));
        about.addActionListener(this);
        p2.add(about);

        ImageIcon i4 = new ImageIcon(ClassLoader.getSystemResource("icons/home.jpg"));
        Image i5 = i4.getImage().getScaledInstance(1500,900,Image.SCALE_DEFAULT);
        ImageIcon i6 = new ImageIcon(i5);
        JLabel image = new JLabel(i6);
        image.setBounds(0,0,1500,900);
        add(image);

        JLabel text = new JLabel("Travel and Tourism Management System");
        text.setBounds(300,70,1000,70);
        text.setForeground(Color.WHITE);
        text.setFont(new Font("Raleway",Font.PLAIN,50));
        image.add(text);

        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae) {
        if(ae.getSource() == addpersonaldetails) {
            new AddCustomer(username);
        }
        else if(ae.getSource() == deletepersonalDetails) {
            new DeleteDetails(username);
        }
        else if (ae.getSource()== updatepersonalDetails) {
            new UpdateCustomer(username);
        }
        else if(ae.getSource() == viewpersonalDetails) {
            new ViewCustomer(username);
        }
        else if (ae.getSource() == checkpackages) {
            new CheckPackages();
        }
        else if (ae.getSource() == bookpackages) {
            new BookPackage(username);
        }
        else if (ae.getSource() == viewpackages) {
            new ViewPackage(username);
        }
        else if(ae.getSource() == viewhotels) {
            new ViewHotels();
        }
        else if(ae.getSource() == bookhotels) {
            new BookHotel(username);
        }
        else if(ae.getSource() == viewbookedhotels) {
            new ViewBookedHotel(username);
        }

        else if (ae.getSource() == destinations) {
            new Destinations();
        }
        else if (ae.getSource() == calculator) {
            try{
                Runtime.getRuntime().exec("calc.exe");
            } catch (Exception e){
                e.printStackTrace();
            }
        }
        else if(ae.getSource() == notepad) {
            try{
                Runtime.getRuntime().exec("notepad.exe");
            } catch (Exception e){
                e.printStackTrace();
            }
        }
        else if(ae.getSource() == payment) {
            new Payment();
        }
        else if(ae.getSource() == about) {
            new About();
        }
    }
    public static void main(String args[]){

        new Dashboard(" ");
    }
}
