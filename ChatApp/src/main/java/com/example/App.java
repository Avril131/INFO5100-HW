package com.example;

import javax.swing.SwingUtilities;

public class App {
    public static void main(String[] args) {
        if (!ServerChat.isServerRunning()) {
            ServerChat.start();
        }
        
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                LoginFrame loginFrame = new LoginFrame();
                loginFrame.setVisible(true);
            }
        });
    }
}

