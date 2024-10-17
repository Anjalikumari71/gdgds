import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class Signup extends JFrame implements ActionListener {

    JTextField usernametext,nametext,passwordtext,answertext;
    JButton create,back;
    Choice security;

    Signup() {
        setSize(800,450);
        setLocation(250,130);
        setLayout(null);

        getContentPane().setBackground(Color.WHITE);

        JPanel p1 = new JPanel();
        p1.setBounds(20,0,450,450);
        p1.setLayout(null);
        p1.setBackground(new Color(131,193,233));
        add(p1);

        JLabel username = new JLabel("Username");
        username.setBounds(30,50,100,25);
        username.setFont(new Font("ARIAL",Font.PLAIN,15));
        p1.add(username);

        usernametext = new JTextField();
        usernametext.setBounds(160,50,200,25);
        p1.add(usernametext);

        JLabel name = new JLabel("Name");
        name.setBounds(30,90,100,25);
        name.setFont(new Font("ARIAL",Font.PLAIN,15));
        p1.add(name);

        nametext = new JTextField();
        nametext.setBounds(160,90,200,25);
        p1.add(nametext);

        JLabel lpassword = new JLabel("Password");
        lpassword.setBounds(30,130,100,25);
        lpassword.setFont(new Font("ARIAL",Font.PLAIN,15));
        p1.add(lpassword);

        passwordtext = new JTextField();
        passwordtext.setBounds(160,130,200,25);
        p1.add(passwordtext);

        JLabel securityques = new JLabel("Security Question");
        securityques.setBounds(30,170,100,25);
        securityques.setFont(new Font("ARIAL",Font.PLAIN,15));
        p1.add(securityques);

        security = new Choice();
        security.add("Your Birth Place");
        security.add("Your School");
        security.add("Your hobby");
        security.setBounds(160,170,200,25);
        p1.add(security);

        JLabel lanswer = new JLabel("Answer");
        lanswer.setBounds(30,210,100,25);
        lanswer.setFont(new Font("ARIAL",Font.PLAIN,15));
        p1.add(lanswer);

        answertext = new JTextField();
        answertext.setBounds(160,210,200,25);
        p1.add(answertext);

        create= new JButton("Create");
        create.setBounds(60,270,100,30);
        create.addActionListener(this);
        p1.add(create);

        back = new JButton("Back");
        back.setBounds(200,270,100,30);
        back.addActionListener(this);
        p1.add(back);

        JPanel p2 = new JPanel();
        p2.setBounds(450,0,800,450);
        p2.setLayout(null);
        p2.setBackground(Color.white);
        add(p2);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/signup.png"));
        Image i2 = i1.getImage().getScaledInstance(200,200,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(80,100,200,200);
        p2.add(image);

        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae) {
        if(ae.getSource() == create) {
            String username = usernametext.getText();
            String name = nametext.getText();
            String password = passwordtext.getText();
            String question = security.getSelectedItem();
            String answer = answertext.getText();

            String query = "insert into information values('"+username+"','"+name+"','"+password+"','"+question+"','"+answer+"')";
            try {
                Conn c = new Conn();
                c.s.executeUpdate(query);

                JOptionPane.showMessageDialog(null,"Account Created Successfully");
                setVisible(false);
                new Login();
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else if (ae.getSource() == back) {
            setVisible(false);
            new Login();
        }
    }
    public static void main(String[] args) {
        new Signup();
    }
}
