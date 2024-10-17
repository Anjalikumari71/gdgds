import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class DeleteDetails extends JFrame implements ActionListener {
    JButton delete;
    String username;

    DeleteDetails(String username) {
        this.username = username;
        setBounds(250,100,850,550);
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);

        JLabel lblusername = new JLabel("Username");
        lblusername.setBounds(50,50,100,25);
        add(lblusername);

        JLabel labelusername = new JLabel();
        labelusername.setBounds(200,50,100,25);
        add(labelusername);

        JLabel lblid = new JLabel("Id");
        lblid.setBounds(50,90,100,25);
        add(lblid);

        JLabel labelid = new JLabel();
        labelid.setBounds(200,90,150,25);
        add(labelid);

        JLabel lblnumber = new JLabel("Number");
        lblnumber.setBounds(50,130,100,25);
        add(lblnumber);

        JLabel labelnumber = new JLabel();
        labelnumber.setBounds(200,130,100,25);
        add(labelnumber);

        JLabel lblname = new JLabel("Name");
        lblname.setBounds(50,170,100,25);
        add(lblname);

        JLabel labelname = new JLabel();
        labelname.setBounds(200,170,100,25);
        add(labelname);

        JLabel lblgender = new JLabel("Gender");
        lblgender.setBounds(50,210,100,25);
        add(lblgender);

        JLabel labelgender = new JLabel();
        labelgender.setBounds(200,210,100,25);
        add(labelgender);

        JLabel lblcountry = new JLabel("Country");
        lblcountry.setBounds(450,50,100,25);
        add(lblcountry);

        JLabel labelcountry = new JLabel();
        labelcountry.setBounds(600,50,100,25);
        add(labelcountry);

        JLabel lbladdress = new JLabel("Address");
        lbladdress.setBounds(450,90,100,25);
        add(lbladdress);

        JLabel labeladdress = new JLabel();
        labeladdress.setBounds(600,90,100,25);
        add(labeladdress);

        JLabel lblphone = new JLabel("Phone");
        lblphone.setBounds(450,130,100,25);
        add(lblphone);

        JLabel labelphone = new JLabel();
        labelphone.setBounds(600,130,100,25);
        add(labelphone);

        JLabel lblemail = new JLabel("Email");
        lblemail.setBounds(450,170,200,25);
        add(lblemail);

        JLabel labelemail = new JLabel();
        labelemail.setBounds(600,170,200,25);
        add(labelemail);

        delete = new JButton("Delete");
        delete.setBounds(350, 260,100,30);
        delete.setBackground(Color.DARK_GRAY);
        delete.setForeground(Color.WHITE);
        delete.addActionListener(this);
        add(delete);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/delete.png"));
        Image i2 = i1.getImage().getScaledInstance(600,200,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(100,320,600,200);
        add(image);

        try{
            Conn c = new Conn();
            String query = "select * from customer where username = '"+username+"'";
            ResultSet rs = c.s.executeQuery(query);
            while(rs.next()) {
                labelusername.setText(rs.getString("username"));
                labelid.setText(rs.getString("id"));
                labelnumber.setText(rs.getString("number"));
                labelname.setText(rs.getString("name"));
                labelgender.setText(rs.getString("gender"));
                labelcountry.setText(rs.getString("country"));
                labeladdress.setText(rs.getString("address"));
                labelphone.setText(rs.getString("phone"));
                labelemail.setText(rs.getString("email"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        setVisible(true);
    }
    public void actionPerformed(ActionEvent ae) {
       try{
           Conn c = new Conn();
           c.s.executeUpdate("delete from information where username = '"+username+"'");
           c.s.executeUpdate("delete from customer where username = '"+username+"'");
           c.s.executeUpdate("delete from bookpackage where username = '"+username+"'");
           c.s.executeUpdate("delete from bookhotel where username = '"+username+"'");

           JOptionPane.showMessageDialog(null, "Data Deleted Successfully");

           setVisible(false);
       } catch(Exception e) {
           e.printStackTrace();
       }
    }
    public static void main(String args[]) {
        new DeleteDetails("");
    }
}
