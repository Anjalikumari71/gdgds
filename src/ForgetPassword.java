import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class ForgetPassword extends JFrame implements ActionListener{
    JTextField usernametext, nametext, answertext, passwordtext, security;
    JButton search,retrieve,back;

    ForgetPassword(){
        setSize(800,450);
        setLocation(250,130);
        setLayout(null);

        getContentPane().setBackground(Color.WHITE);

        JPanel p1 = new JPanel();
        p1.setLayout(null);
        p1.setBounds(20,0,450,450);
        add(p1);

        JLabel username = new JLabel("Username");
        username.setBounds(30,50,100,25);
        username.setFont(new Font("TAHOMA",Font.PLAIN,15));
        p1.add(username);

        usernametext = new JTextField();
        usernametext.setBounds(160,50,180,25);
        usernametext.setBorder(BorderFactory.createEmptyBorder());
        p1.add(usernametext);

        search= new JButton("Search");
        search.setBounds(350,50,90,25);
        search.addActionListener(this);
        p1.add(search);

        JLabel name = new JLabel("Name");
        name.setBounds(30,90,100,25);
        name.setFont(new Font("TAHOMA",Font.PLAIN,15));
        p1.add(name);

        nametext = new JTextField();
        nametext.setBounds(160,90,180,25);
        nametext.setBorder(BorderFactory.createEmptyBorder());
        p1.add(nametext);

        JLabel securityques = new JLabel("Security Question");
        securityques.setBounds(30,130,100,25);
        securityques.setFont(new Font("TAHOMA",Font.PLAIN,15));
        p1.add(securityques);

        security = new JTextField();
        security.setBounds(160,130,180,25);
        security.setBackground(Color.gray);
        p1.add(security);

        JLabel lanswer = new JLabel("Answer");
        lanswer.setBounds(30,170,100,25);
        lanswer.setFont(new Font("TAHOMA",Font.PLAIN,15));
        p1.add(lanswer);

        answertext = new JTextField();
        answertext.setBounds(160,170,180,25);
        answertext.setBorder(BorderFactory.createEmptyBorder());
        p1.add(answertext);

        retrieve= new JButton("Retrieve");
        retrieve.setBounds(350,170,90,25);
        retrieve.addActionListener(this);
        p1.add(retrieve);

        JLabel password = new JLabel("Password");
        password.setBounds(30,210,100,25);
        password.setFont(new Font("TAHOMA",Font.PLAIN,15));
        p1.add(password);

        passwordtext = new JTextField();
        passwordtext.setBounds(160,210,180,25);
        passwordtext.setBorder(BorderFactory.createEmptyBorder());
        p1.add(passwordtext);

        back= new JButton("Back");
        back.setBounds(120,260,90,25);
        back.setBackground(new Color(135,200,255));
        back.addActionListener(this);
        p1.add(back);


        JPanel p2 = new JPanel();
        p2.setBounds(450,0,800,450);
        p2.setLayout(null);
        p2.setBackground(Color.white);
        add(p2);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/forgotpassword.jpg"));
        Image i2 = i1.getImage().getScaledInstance(200,200,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(80,100,200,200);
        p2.add(image);

        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae) {
        if(ae.getSource() == search) {
            try{
                String query = "select * from information where username = '"+usernametext.getText()+"' ";
                Conn c = new Conn();

                ResultSet rs = c.s.executeQuery(query);
                while (rs.next()) {
                    nametext.setText(rs.getString("name"));
                    security.setText(rs.getString("security"));
                }
            } catch(Exception e){
                e.printStackTrace();
            }
        } else if(ae.getSource() == retrieve) {
            try{
                String query = "select * from information where answer = '"+answertext.getText()+"' AND username = '"+usernametext.getText()+"' ";
                Conn c = new Conn();

                ResultSet rs = c.s.executeQuery(query);
                while(rs.next()) {
                    passwordtext.setText(rs.getString("password"));
                }
            } catch(Exception e){
                e.printStackTrace();
            }

        } else {
            setVisible(false);
            new Login();
        }
    }
    public static void main(String args[]) {
        new ForgetPassword();
    }
}
