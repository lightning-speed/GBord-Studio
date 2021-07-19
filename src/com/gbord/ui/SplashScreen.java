package com.gbord.ui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SplashScreen extends JFrame {
    Timer t;
    public static String a = "";
    int ae = 0;
    Window w;
    public SplashScreen(){
        this.setIconImage(new ImageIcon("icons\\icon.png").getImage());
        this.setUndecorated(true);
        this.setVisible(true);
        this.setSize(615,344);
        this.setDefaultCloseOperation(this.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        for(int i= 0;i<50;i++){
            for(int j = 0;j<20;j++){
                a+="                                                                                                                    ";

            }
            a+="\n";
        }
        JLabel p = new JLabel(new ImageIcon("icons\\test2.jpg"));
        p.setIcon(new ImageIcon("icons\\test2.jpg"));
        this.add(p);
        this.repaint();
        p.repaint();

                setSize(616,344);
                repaint();


        t = new Timer(6000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
                w = new Window();
                w.setVisible(true);
                end();


            }
        });
        t.start();
        this.setSize(616,344);


    }
    public  void end(){
        t.stop();
    }
}
