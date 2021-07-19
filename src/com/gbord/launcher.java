package com.gbord;

import com.gbord.ui.SplashScreen;
import com.gbord.ui.Window;

import javax.swing.*;

public class launcher {
    public void launch(){
        try {
            UIManager.setLookAndFeel("com.formdev.flatlaf.FlatIntelliJLaf");
        } catch (Exception e) {
            e.printStackTrace();
        }
        SplashScreen w= new SplashScreen();

    }
}
