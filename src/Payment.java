import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Payment extends JFrame implements ActionListener {
    JButton pay, back;

    Payment() {
        setBounds(250,100,800,500);
        setLayout(null);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/paytm.jpeg"));
        Image i2 = i1.getImage().getScaledInstance(800,500, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0,0,800,500);
        add(image);

        pay = new JButton("Pay");
        pay.setBackground(new Color(0,100,200));
        pay.setForeground(Color.WHITE);
        pay.setBounds(650,30,80,30);
        pay.addActionListener(this);
        add(pay);

        back = new JButton("Back");
        back.setBackground(new Color(0,100,200));
        back.setForeground(Color.WHITE);
        back.setBounds(650,75,80,30);
        back.addActionListener(this);
        add(back);

        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == pay) {
            setVisible(false);
            new Paytm();
        }
        else if (ae.getSource() == back) {
            setVisible(false);
        }
    }

    public static void main(String args[]) {
        new Payment();
    }
}
