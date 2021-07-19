package com.gbord.ui;



import javafx.scene.control.ToggleButton;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;
import java.awt.event.*;

import static java.lang.Math.abs;

public class AppActivity extends JTextArea {
    boolean can = true;
    JColorChooser J = new JColorChooser();
    int index = 0;
    int x1 = 0;
    int x2 = 0;
    int x = 0,y = 0;
    int w = 5,h = 5;
    String a = "";
    JPanel [] pa = new JPanel[999999];
    JButton jc = new JButton();
    JPanel t= new JPanel();
    JButton clear = new JButton("");
    JButton undo = new JButton("");
    JToggleButton pen = new JToggleButton();
    Color DF = Color.BLACK;
    int er = 0;
   

    public  AppActivity() {
        pen.setSelected(false);
       setEditable(false);
        draw();


        this.setText(SplashScreen.a);


        this.addMouseMotionListener(new MouseMotionListener() {
            @Override
            public void mouseDragged(MouseEvent e) {

                if(can) {
                    x = e.getX();
                    y = e.getY();
                    h = 4;
                    w = 4;
                    setSelectionStart(0);
                    setSelectionEnd(0);
                    pa[index] = new JPanel();
                    pa[index].setBounds((x + x1) / 2, (y + x2) / 2, w, h);
                    pa[index].setVisible(true);
                    pa[index].setBackground(DF);
                    add(pa[index]);
                    repaint();
                    x1 = x;
                    x2 = y;
                    index++;
                }
            }

            @Override
            public void mouseMoved(MouseEvent e) {

              x1=e.getX();
              x2=e.getY();

            }

        });
    }
    public void clear(){
        removeAll();
        setText(a);
        add(t);
        add(J);
        repaint();
        setText(SplashScreen.a);
    }
    public void undo(){
        if(index<=50)for(int i = index;index>0;i++){
            index--;
            pa[index].setVisible(false);
        }
        else
            for(int i = 0;i<50&&index>50;i++){
                index--;
                pa[index].setVisible(false);
            }

    }
    public void draw(){

        add(J);
        J.setVisible(false);
        J.setBounds(30,95,300,300);
        J.getSelectionModel().addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                DF = J.getColor();
                jc.setBorder(BorderFactory.createLineBorder(J.getColor(),3));
                J.setVisible(false);

            }
        });
        t.add(jc);
        this.setFont(new FontStyle().getFont("",17));
        clear.addActionListener(new ActionListener() {
            @Override public void actionPerformed(ActionEvent e) { clear();}});
        undo.addActionListener(new ActionListener() {
            @Override public void actionPerformed(ActionEvent e) { undo();}});
        this.setLayout(null);
        t.add(clear);
        t.add(undo);
        t.add(pen);
        this.setBackground(Color.WHITE);
        this.setRows(1000);
        this.setColumns(1000);
        this.add(t);
        t.setBounds(0,0,40,5000);
        t.setLayout(null);
        clear.setBounds(3,3,30,30);
        clear.setIcon(new ImageIcon("icons\\delete_icon.png"));
        clear.setIconTextGap(-5);
        undo.setBounds(3,34,30,30);
        undo.setIcon(new ImageIcon("icons\\undo_icon.png"));
        undo.setIconTextGap(-5);
        pen.setBounds(3,68,30,30);
        pen.setIcon(new ImageIcon("icons\\pen_icon.png"));
        pen.setIconTextGap(-5);
        clear.setToolTipText("Clear");
        undo.setToolTipText("Undo");
        pen.setToolTipText("Text");
        jc.setToolTipText("Color");
        jc.setBounds(3,101,30,30);
        jc.setIcon(new ImageIcon("icons\\color_icon.png"));
        jc.setIconTextGap(-5);
        jc.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                J.setVisible(true);
            }
        });
        this.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                J.setVisible(false);
            }

            @Override
            public void mousePressed(MouseEvent e) {

            }

            @Override
            public void mouseReleased(MouseEvent e) {

            }

            @Override
            public void mouseEntered(MouseEvent e) {

            }

            @Override
            public void mouseExited(MouseEvent e) {

            }
        });
        setCursor(new Cursor(Cursor.CROSSHAIR_CURSOR));

        pen.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(pen.isSelected()){can = false;
                setEditable(true);
                    setCursor(new Cursor(Cursor.DEFAULT_CURSOR));}
                else{ can = true;pen.setBackground(Color.WHITE);setEditable(false);setForeground(Color.BLACK);
                    setCursor(new Cursor(Cursor.CROSSHAIR_CURSOR));
                 }
            }});
    }

}

