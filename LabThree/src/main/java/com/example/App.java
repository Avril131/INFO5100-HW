package com.example;

import javax.swing.SwingUtilities;

public class App {
    public static void main(String[] args) {
        // create and show GUI
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                ColorCircleFrame frame = new ColorCircleFrame();
                frame.setVisible(true);
            }
        });
    }
}

