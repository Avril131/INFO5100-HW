package com.example;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ColorCircleFrame extends JFrame {
    
    private CirclePanel circlePanel;
    private JComboBox<String> colorDropdown;
    private JTextField outputField;
    
    public ColorCircleFrame() {
        // set frame properties
        setTitle("Color Circle");
        setSize(400, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout(10, 10));
        
        // create circle panel
        circlePanel = new CirclePanel();
        circlePanel.setPreferredSize(new Dimension(400, 300));
        add(circlePanel, BorderLayout.CENTER);
        
        // create control panel
        JPanel controlPanel = new JPanel();
        controlPanel.setLayout(new FlowLayout());
        
        // create dropdown with colors
        JLabel label = new JLabel("Select Color:");
        String[] colors = {"Red", "Blue", "Green", "Yellow", "Orange", "Pink"};
        colorDropdown = new JComboBox<>(colors);
        
        // add action listener to dropdown
        colorDropdown.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String selectedColor = (String) colorDropdown.getSelectedItem();
                updateCircleColor(selectedColor);
            }
        });
        
        controlPanel.add(label);
        controlPanel.add(colorDropdown);
        add(controlPanel, BorderLayout.NORTH);
        
        // create output text field
        outputField = new JTextField(20);
        outputField.setEditable(false);
        outputField.setHorizontalAlignment(JTextField.CENTER);
        JPanel outputPanel = new JPanel();
        outputPanel.add(new JLabel("Selected Color:"));
        outputPanel.add(outputField);
        add(outputPanel, BorderLayout.SOUTH);
    }
    
    // update circle color based on selection
    private void updateCircleColor(String colorName) {
        Color color = getColorByName(colorName);
        circlePanel.setCircleColor(color);
        outputField.setText(colorName);
    }
    
    // convert color name to Color object
    private Color getColorByName(String colorName) {
        switch (colorName) {
            case "Red":
                return Color.RED;
            case "Blue":
                return Color.BLUE;
            case "Green":
                return Color.GREEN;
            case "Yellow":
                return Color.YELLOW;
            case "Orange":
                return Color.ORANGE;
            case "Pink":
                return Color.PINK;
            default:
                return null;
        }
    }
}

