import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class About extends JFrame implements ActionListener {
    JButton back;
    About(){
        setBounds(400,100,500,500);
        setLayout(null);
        getContentPane().setBackground(Color.white);

        JLabel l1 = new JLabel("ABOUT");
        l1.setBounds(200,30,100,40);
        l1.setForeground(Color.red);
        l1.setFont(new Font("Tahoma", Font.PLAIN,20));
        add(l1);

        String s ="About Projects            \n" +
                "\n" +
                "The objective of the Travel and Tourism Management System project is to develop a system that automates the processes and activities of a travel and the purpose is to design a system using which one can perform all operations relates to travelling.\n" +
                "\n" +
                "This application will help in accessing the information related to travel to the particular destination will great ease.The users can track the information related to their tours with great ease through this application.The travel agency information can also be obtained through this application.\n" +
                "\n" +
                "Advantages of Project: \n" +
                " ~Gives accurate information\n" +
                " ~It minimizes the documentation related work\n" +
                " ~Provides up to date information\n" +
                " ~Simplifies the manual work\n" +
                " ~Friendly environment by providing warning message\n" +
                " ~Travelers details can be provided\n";

        TextArea area = new TextArea(s,10,40,Scrollbar.VERTICAL);
        area.setEditable(false);
        area.setBounds(20,100,450,300);
        add(area);

        back = new JButton("Back");
        back.setBounds(210,420,80,35);
        back.setForeground(Color.WHITE);
        back.setBackground(Color.darkGray);
        back.addActionListener(this);
        add(back);


        setVisible(true);
    }
    public void actionPerformed(ActionEvent ae) {
        if(ae.getSource() == back) {
            setVisible(false);
        }
    }
    public static void main(String args[]) {
        new About();

    }
}
