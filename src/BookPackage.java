import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class BookPackage extends JFrame implements ActionListener {
    Choice cpackage;
    JTextField tfphone, tfprice, tfperson, labelid,labelnumber;
    JLabel labelusername;
    JButton checkprice, bookpackage, back;

    BookPackage(String username){
        setBounds(300,100,800,500);
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);

        JLabel text = new JLabel("BOOK PACKAGE");
        text.setBounds(100,10,200,30);
        text.setFont(new Font("Tahoma", Font.BOLD,20));
        add(text);

        JLabel lblusername = new JLabel("Username");
        lblusername.setBounds(40,70,100,20);
        lblusername.setFont(new Font("Tahoma", Font.PLAIN,16));
        add(lblusername);

        labelusername = new JLabel();
        labelusername.setBounds(200,70,100,16);
        labelusername.setFont(new Font("Tahoma", Font.PLAIN,16));
        add(labelusername);

        JLabel lblpackage = new JLabel("Select Package");
        lblpackage.setBounds(40,110,120,20);
        lblpackage.setFont(new Font("Tahoma", Font.PLAIN,16));
        add(lblpackage);

        cpackage = new Choice();
        cpackage.add("Gold Package");
        cpackage.add("Silver Package");
        cpackage.add("Bronze Package");
        cpackage.setBounds(200,110,100,20);
        add(cpackage);

        JLabel lblperson = new JLabel("Total Person");
        lblperson.setBounds(40,150,120,20);
        lblperson.setFont(new Font("Tahoma", Font.PLAIN,16));
        add(lblperson);

        tfperson = new JTextField("1");
        tfperson.setBounds(200,150,120,22);
        tfperson.setFont(new Font("Tahoma", Font.PLAIN,14));
        add(tfperson);

        JLabel lblid = new JLabel("Id");
        lblid.setBounds(40,190,100,20);
        lblid.setFont(new Font("Tahoma", Font.PLAIN,16));
        add(lblid);

        labelid = new JTextField();
        labelid.setBounds(200,190,120,25);
        labelid.setFont(new Font("Tahoma", Font.PLAIN,14));
        add(labelid);

        JLabel lblnumber = new JLabel("Number");
        lblnumber.setBounds(40,230,100,20);
        lblnumber.setFont(new Font("Tahoma", Font.PLAIN,16));
        add(lblnumber);

        labelnumber = new JTextField();
        labelnumber.setBounds(200,230,120,25);
        labelnumber.setFont(new Font("Tahoma", Font.PLAIN,14));
        add(labelnumber);

        JLabel lblphone = new JLabel("Phone");
        lblphone.setBounds(40,270,100,20);
        lblphone.setFont(new Font("Tahoma", Font.PLAIN,16));
        add(lblphone);

        tfphone = new JTextField();
        tfphone.setBounds(200,270,120,20);
        tfphone.setFont(new Font("Tahoma", Font.PLAIN,14));
        add(tfphone);

        JLabel lblprice = new JLabel("Total Price");
        lblprice.setBounds(40,310,100,20);
        lblprice.setFont(new Font("Tahoma", Font.PLAIN,16));
        add(lblprice);

        tfprice = new JTextField();
        tfprice.setBounds(200,310,120,20);
        tfprice.setFont(new Font("Tahoma", Font.PLAIN,14));
        add(tfprice);

        try{
            Conn c = new Conn();
            String query = "select * from customer where username = '"+username+"'";
            ResultSet rs = c.s.executeQuery(query);
            while(rs.next()) {
                labelusername.setText(rs.getString("username"));
                labelid.setText(rs.getString("id"));
                labelnumber.setText(rs.getString("number"));
                tfphone.setText(rs.getString("phone"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        checkprice = new JButton("Check Price");
        checkprice.setBounds(40,380,120,23);
        checkprice.setBackground(Color.BLACK);
        checkprice.setForeground(Color.WHITE);
        checkprice.addActionListener(this);
        add(checkprice);

        bookpackage = new JButton("Book Package");
        bookpackage.setBounds(180,380,120,23);
        bookpackage.setBackground(Color.BLACK);
        bookpackage.setForeground(Color.WHITE);
        bookpackage.addActionListener(this);
        add(bookpackage);

        back = new JButton("Back");
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
        back.setBounds(320,380,100,23);
        back.addActionListener(this);
        add(back);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/bookpackage.jpg"));
        Image i2 = i1.getImage().getScaledInstance(450,300,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(380,50,450,300);
        add(image);

        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae) {
        if(ae.getSource() == checkprice) {
            String pack = cpackage.getSelectedItem();
            int cost = 0;
            if (pack.equals("Gold Package")) {
                cost += 15000;
            } else if (pack.equals("Silver Package")) {
                cost += 12000;
            } else if(pack.equals("Bronze Package")){
                cost += 10000;
            }

            int person = Integer.parseInt(tfperson.getText());
            cost *= person;
            tfprice.setText("Rs " + cost);

        } else if (ae.getSource() == bookpackage) {
            try {
                Conn c = new Conn();
                c.s.executeUpdate("insert into bookpackage values('"+labelusername.getText()+"', '"+cpackage.getSelectedItem()+"','"+tfperson.getText()+"','"+labelid.getText()+"','"+labelnumber.getText()+"','"+tfphone.getText()+"','"+tfprice.getText()+"')");

                JOptionPane.showMessageDialog(null, "Package Booked Successfully");
                setVisible(false);
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            setVisible(false);
        }
    }
    public static void main(String args[]) {
        new BookPackage("Anjali123");
    }
}
