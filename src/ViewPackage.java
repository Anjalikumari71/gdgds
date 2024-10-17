import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class ViewPackage extends JFrame implements ActionListener{
        JButton back;

        ViewPackage(String username) {
            setBounds(250,100,850,550);
            getContentPane().setBackground(Color.WHITE);
            setLayout(null);

            JLabel text = new JLabel("View Package Details");
            text.setBounds(250,30,320,30);
            text.setFont(new Font("Tahoma", Font.BOLD,25));
            add(text);

            JLabel lblusername = new JLabel("Username");
            lblusername.setBounds(50,100,100,25);
            add(lblusername);

            JLabel labelusername = new JLabel();
            labelusername.setBounds(200,100,100,25);
            add(labelusername);

            JLabel lblpackage = new JLabel("Package");
            lblpackage.setBounds(50,140,100,25);
            add(lblpackage);

            JLabel labelpackage = new JLabel();
            labelpackage.setBounds(200,140,150,25);
            add(labelpackage);

            JLabel lblperson = new JLabel("Total Person");
            lblperson.setBounds(50,180,100,25);
            add(lblperson);

            JLabel labelperson = new JLabel();
            labelperson.setBounds(200,180,100,25);
            add(labelperson);

            JLabel lblid = new JLabel("Id");
            lblid.setBounds(50,220,100,25);
            add(lblid);

            JLabel labelid = new JLabel();
            labelid.setBounds(200,220,100,25);
            add(labelid);

            JLabel lblnumber = new JLabel("Number");
            lblnumber.setBounds(50,260,100,25);
            add(lblnumber);

            JLabel labelnumber = new JLabel();
            labelnumber.setBounds(200,260,100,25);
            add(labelnumber);

            JLabel lblphone = new JLabel("Phone");
            lblphone.setBounds(50,300,100,25);
            add(lblphone);

            JLabel labelphone = new JLabel();
            labelphone.setBounds(200,300,100,25);
            add(labelphone);

            JLabel lblprice = new JLabel("Price");
            lblprice.setBounds(50,340,100,25);
            add(lblprice);

            JLabel labelprice = new JLabel();
            labelprice.setBounds(200,340,100,25);
            add(labelprice);

            back = new JButton("Back");
            back.setBounds(120, 390,80,30);
            back.setBackground(Color.BLACK);
            back.setForeground(Color.WHITE);
            back.addActionListener(this);
            add(back);

            ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/bookedDetails.jpg"));
            Image i2 = i1.getImage().getScaledInstance(400,300,Image.SCALE_DEFAULT);
            ImageIcon i3 = new ImageIcon(i2);
            JLabel image = new JLabel(i3);
            image.setBounds(400,100,400,300);
            add(image);

            try{
                Conn c = new Conn();
                String query = "select * from bookpackage where username = '"+username+"'";
                ResultSet rs = c.s.executeQuery(query);
                while(rs.next()) {
                    labelusername.setText(rs.getString("username"));
                    labelid.setText(rs.getString("id"));
                    labelnumber.setText(rs.getString("number"));
                    labelperson.setText(rs.getString("person"));
                    labelpackage.setText(rs.getString("package"));
                    labelphone.setText(rs.getString("phone"));
                    labelprice.setText(rs.getString("price"));
                }
            } catch (Exception e) {
                e.printStackTrace();
            }

            setVisible(true);
        }
        public void actionPerformed(ActionEvent ae) {
            setVisible(false);
        }
        public static void main(String args[]) {
            new ViewPackage("Anjali123");
        }

}
