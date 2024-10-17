import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class BookHotel extends JFrame implements ActionListener {
    Choice chotel, cac, cfood;
    JTextField tfperson, labeldays;
    JLabel labelusername ,labelid, labelnumber, labelphone, lprice;
    JButton checkprice, bookpackage, back;

    BookHotel(String username){
        setBounds(250,100,850,550);
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);

        JLabel text = new JLabel("BOOK HOTEL");
        text.setBounds(100,10,200,30);
        text.setFont(new Font("Tahoma", Font.BOLD,20));
        add(text);

        JLabel lblusername = new JLabel("Username");
        lblusername.setBounds(40,70,100,20);
        lblusername.setFont(new Font("Tahoma", Font.PLAIN,14));
        add(lblusername);

        labelusername = new JLabel();
        labelusername.setBounds(200,70,100,20);
        labelusername.setFont(new Font("Tahoma", Font.PLAIN,14));
        add(labelusername);

        JLabel lblpackage = new JLabel("Select Hotel");
        lblpackage.setBounds(40,105,120,20);
        lblpackage.setFont(new Font("Tahoma", Font.PLAIN,14));
        add(lblpackage);

        chotel = new Choice();
        chotel.setBounds(200,105,150,20);
        add(chotel);

        try {
            Conn c = new Conn();
            ResultSet rs = c.s.executeQuery("select * from hotel");
            while(rs.next()) {
                chotel.add(rs.getString("name"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        JLabel lblperson = new JLabel("Total Person");
        lblperson.setBounds(40,140,120,20);
        lblperson.setFont(new Font("Tahoma", Font.PLAIN,14));
        add(lblperson);

        tfperson = new JTextField("1");
        tfperson.setBounds(200,140,120,20);
        tfperson.setFont(new Font("Tahoma", Font.PLAIN,13));
        add(tfperson);

        JLabel lbldays = new JLabel("No. of Days");
        lbldays.setBounds(40,175,100,20);
        lbldays.setFont(new Font("Tahoma", Font.PLAIN,14));
        add(lbldays);

        labeldays = new JTextField();
        labeldays.setBounds(200,175,120,20);
        labeldays.setFont(new Font("Tahoma", Font.PLAIN,13));
        add(labeldays);

        JLabel lblac = new JLabel("AC/Non-AC");
        lblac.setBounds(40,210,100,20);
        lblac.setFont(new Font("Tahoma", Font.PLAIN,14));
        add(lblac);

        cac = new Choice();
        cac.add("AC");
        cac.add("Non-AC");
        cac.setBounds(200,210,120,25);
        cac.setFont(new Font("Tahoma", Font.PLAIN,13));
        add(cac);

        JLabel lblfood = new JLabel("Food Included");
        lblfood.setBounds(40,245,100,20);
        lblfood.setFont(new Font("Tahoma", Font.PLAIN,14));
        add(lblfood);

        cfood = new Choice();
        cfood.add("Yes");
        cfood.add("No");
        cfood.setBounds(200,245,120,20);
        cfood.setFont(new Font("Tahoma", Font.PLAIN,13));
        add(cfood);

        JLabel lblid = new JLabel("ID");
        lblid.setBounds(40,280,100,20);
        lblid.setFont(new Font("Tahoma", Font.PLAIN,14));
        add(lblid);

        labelid = new JLabel();
        labelid.setBounds(200,280,120,20);
        labelid.setFont(new Font("Tahoma", Font.PLAIN,13));
        add(labelid);

        JLabel lblnumber = new JLabel("Number");
        lblnumber.setBounds(40,315,100,20);
        lblnumber.setFont(new Font("Tahoma", Font.PLAIN,14));
        add(lblnumber);

        labelnumber = new JLabel();
        labelnumber.setBounds(200,315,120,25);
        labelnumber.setFont(new Font("Tahoma", Font.PLAIN,13));
        add(labelnumber);

        JLabel lblphone = new JLabel("Phone");
        lblphone.setBounds(40,355,100,20);
        lblphone.setFont(new Font("Tahoma", Font.PLAIN,14));
        add(lblphone);

        labelphone = new JLabel();
        labelphone.setBounds(200,355,120,20);
        labelphone.setFont(new Font("Tahoma", Font.PLAIN,13));
        add(labelphone);

        JLabel lblprice = new JLabel("Total Price");
        lblprice.setBounds(40,390,100,20);
        lblprice.setFont(new Font("Tahoma", Font.PLAIN,14));
        add(lblprice);

        lprice = new JLabel();
        lprice.setBounds(200,390,120,20);
        lprice.setFont(new Font("Tahoma", Font.PLAIN,13));
        add(lprice);

        try{
            Conn c = new Conn();
            String query = "select * from customer where username = '"+username+"'";
            ResultSet rs = c.s.executeQuery(query);
            while(rs.next()) {
                labelusername.setText(rs.getString("username"));
                labelid.setText(rs.getString("id"));
                labelnumber.setText(rs.getString("number"));
                labelphone.setText(rs.getString("phone"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        checkprice = new JButton("Check Price");
        checkprice.setBounds(30,440,110,23);
        checkprice.setBackground(Color.BLACK);
        checkprice.setForeground(Color.WHITE);
        checkprice.addActionListener(this);
        add(checkprice);

        bookpackage = new JButton("Book");
        bookpackage.setBounds(170,440,100,23);
        bookpackage.setBackground(Color.BLACK);
        bookpackage.setForeground(Color.WHITE);
        bookpackage.addActionListener(this);
        add(bookpackage);

        back = new JButton("Back");
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
        back.setBounds(300,440,100,23);
        back.addActionListener(this);
        add(back);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/book.jpg"));
        Image i2 = i1.getImage().getScaledInstance(450,300,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(380,50,450,300);
        add(image);

        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae) {
        if(ae.getSource() == checkprice) {
            try {
                Conn c = new Conn();
                ResultSet rs = c.s.executeQuery("select * from hotel where name = '" +chotel.getSelectedItem()+"'");
                while (rs.next()) {
                    int cost = Integer.parseInt(rs.getString("costperperson"));
                    int food = Integer.parseInt(rs.getString("foodincluded"));
                    int ac = Integer.parseInt(rs.getString("acroom"));

                    int persons = Integer.parseInt(tfperson.getText());
                    int days = Integer.parseInt(labeldays.getText());

                    String acselected = cac.getSelectedItem();
                    String foodselected = cfood.getSelectedItem();

                    if (persons * days > 0) {
                        int total = 0;
                        total += acselected.equals("AC") ? ac : 0;
                        total += foodselected.equals("Yes") ? food : 0;
                        total += cost;
                        total = total * persons * days;
                        lprice.setText("Rs " + total);
                    } else {
                        JOptionPane.showMessageDialog(null, "Please enter a valid number");
                    }
                }
            }catch (Exception e){
            e.printStackTrace();
        }

        } else if (ae.getSource() == bookpackage) {
            try {
                Conn c = new Conn();
                c.s.executeUpdate("insert into bookhotel values('"+labelusername.getText()+"','"+chotel.getSelectedItem()+"','"+tfperson.getText()+"','"+labeldays.getText()+"', '"+cac.getSelectedItem()+"','"+cfood.getSelectedItem()+"', '"+labelid.getText()+"','"+labelnumber.getText()+"','"+labelphone.getText()+"','"+lprice.getText()+"')");

                JOptionPane.showMessageDialog(null, "Hotel Booked Successfully");
                setVisible(false);
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            setVisible(false);
        }
    }
    public static void main(String args[]) {
        new BookHotel("Anjali123");
    }
}
