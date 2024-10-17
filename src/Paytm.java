import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Paytm extends JFrame implements ActionListener {
    JButton back;

    Paytm() {
        setBounds(250,100,800,550);

        JEditorPane pane = new JEditorPane();
        pane.setEditable(false);

        try{
            pane.setPage("https://paytm.com/rent-payment");
        } catch(Exception e) {
            pane.setContentType("text/html");
            pane.setText("<html>Could not load, Error 404</html>");
        }
        JScrollPane sp = new JScrollPane(pane);
        getContentPane().add(sp);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/pay.jpg"));
        Image i2 = i1.getImage().getScaledInstance(250,400, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(30,20,250,400);
        add(image);

        back = new JButton("Back");
        back.setBounds(600,20,80,40);
        back.addActionListener(this);
        pane.add(back);

        setVisible(true);
    }
    public void actionPerformed(ActionEvent ae) {
        if(ae.getSource() == back) {
            setVisible(false);
            new Payment();
        }
    }
    public static void main(String args[]) {
        new Paytm();
    }
}
