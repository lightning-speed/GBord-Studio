package com.gbord.ui;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;

public class Window extends JFrame {
    public Window(){
        this.setIconImage(new ImageIcon("icons\\icon.png").getImage());
        this.setSize(800,500);
        this.setDefaultCloseOperation(this.EXIT_ON_CLOSE);
        this.setContentPane(new AppActivity());
        this.setLocationRelativeTo(null);
    }
}
