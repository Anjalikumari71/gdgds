import javax.swing.*;
import java.awt.*;
import java.sql.Connection;

public class Loading extends JFrame implements Runnable {
    Thread t;
    Connection conn;
    JProgressBar bar;
    String username;
    public void run() {
        try {

            for (int i = 0; i <= 100; i++) {

                int max = bar.getMaximum();
                int value = bar.getValue();
                if (value < max) {
                    bar.setValue(bar.getValue() + 1);

                } else {
                    i=101;
                    setVisible(false);
                    new Dashboard(username);
                }
                Thread.sleep(40);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    Loading(String username) {
        this.username = username;
        t = new Thread( this);



        setSize(800, 450);
        setLocation(250, 130);
        setLayout(null);
        getContentPane().setBackground(Color.WHITE);

        JLabel text = new JLabel("Travel and Tourism Application");
        text.setBounds(100, 40, 700, 40);
        text.setForeground(Color.red);
        text.setFont(new Font("Raleway", Font.BOLD, 40));
        add(text);

        bar = new JProgressBar(0,100);
        bar.setBounds(200, 120, 350, 40);
        bar.setStringPainted(true);
        add(bar);

        JLabel loading = new JLabel("Loading, please wait...");
        loading.setBounds(300, 170, 600, 20);
        loading.setFont(new Font("Raleway", Font.BOLD, 15));
        add(loading);

        JLabel name = new JLabel("Welcome " + username);
        name.setBounds(200, 300, 500, 45);
        name.setForeground(Color.MAGENTA);
        name.setFont(new Font("Raleway", Font.BOLD, 40));
        add(name);

        t.start();
        setVisible(true);
    }
//    public void startLoading() {
//        setVisible(true);
//        t.start();
//    }
        public static void main (String[] args){
        new Loading(" ");
        }
    }

