import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.ResultSet;

public class Login extends JFrame implements ActionListener {
    JButton login,signup, forgetpassword;
    JTextField usernametext,ptext;

    Login() {
        setSize(800,450);
        setLocation(250,130);
        setLayout(null);

        getContentPane().setBackground(Color.WHITE);

        JPanel p1 = new JPanel();
        p1.setBackground(new Color(131,193,233));
        p1.setBounds(0,0,350,450);
        p1.setLayout(null);
        add(p1);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/login.png"));
        Image i2 = i1.getImage().getScaledInstance(200,200,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(80,120,180,200);
        p1.add(image);

        JPanel p2 = new JPanel();
        p2.setLayout(null);
        p2.setBounds(350,0,780,450);
        add(p2);

        JLabel lusername = new JLabel("Username");
        lusername.setBounds(60,80,100,25);
        lusername.setFont(new Font("SAN_SERIF",Font.PLAIN,20));
        p2.add(lusername);

        usernametext = new JTextField();
        usernametext.setBounds(60,120,250,25);
        p2.add(usernametext);

        JLabel lpassword = new JLabel("Password");
        lpassword.setBounds(60,165,100,25);
        lpassword.setFont(new Font("SAN_SERIF",Font.PLAIN,20));
        p2.add(lpassword);

        ptext = new JTextField();
        ptext.setBounds(60,205,250,25);
        p2.add(ptext);

        login = new JButton("Login");
        login.setBounds(70,270,100,30);
        login.setBackground(new Color(135,200,255));
        login.addActionListener(this);
        p2.add(login);

        signup = new JButton("Signup");
        signup.setBounds(200,270,100,30);
        signup.setBackground(new Color(135,200,255));
        signup.addActionListener(this);
        p2.add(signup);

        forgetpassword = new JButton("Forget Password");
        forgetpassword.setBounds(110,330,150,30);
        forgetpassword.addActionListener(this);
        p2.add(forgetpassword);

        JLabel trouble = new JLabel("Trouble Signing in...");
        trouble.setBounds(250,380,150,20);
        trouble.setForeground(new Color(255,0,0));
        p2.add(trouble);


        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae) {
        if(ae.getSource()==login){
            try {
                String username = usernametext.getText();
                String password = ptext.getText();

                String query = "select * from information where username = '"+username+"' AND password = '"+password+"'";
                Conn c = new Conn();
                ResultSet rs = c.s.executeQuery(query);
                if(rs.next()) {
                    setVisible(false);
                    new Loading(username);

                }
                else {
                    JOptionPane.showMessageDialog(null,"Incorrect username or password");
                }
            }catch (Exception e) {
                e.printStackTrace();
            }

        } else if(ae.getSource()==signup){
            setVisible(false);
            new Signup();
        } else {
            setVisible(false);
            new ForgetPassword();
        }
    }
    public static void main(String[] args) {
        new Login();
    }
}
