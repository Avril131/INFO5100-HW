package com.example;

import javax.swing.*;
import java.awt.*;

public class CirclePanel extends JPanel {
    
    private Color circleColor;
    
    public CirclePanel() {
        // initially no color (null)
        this.circleColor = null;
        setBackground(Color.WHITE);
    }
    
    // set circle color
    public void setCircleColor(Color color) {
        this.circleColor = color;
        repaint();
    }
    
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        
        // draw circle
        int diameter = Math.min(getWidth(), getHeight()) - 50;
        int x = (getWidth() - diameter) / 2;
        int y = (getHeight() - diameter) / 2;
        
        // draw circle outline
        g.setColor(Color.BLACK);
        g.drawOval(x, y, diameter, diameter);
        
        // fill circle if color is selected
        if (circleColor != null) {
            g.setColor(circleColor);
            g.fillOval(x, y, diameter, diameter);
        }
    }
}

