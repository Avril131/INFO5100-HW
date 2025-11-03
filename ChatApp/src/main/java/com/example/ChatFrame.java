package com.example;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.List;
import javax.swing.Timer;

public class ChatFrame extends JFrame {
    private String username;
    private JTextArea messageArea;
    private JTextField inputField;
    private JButton sendButton;
    private Timer messageTimer;
    private ChatClient chatClient;
    
    public ChatFrame(String username) {
        this.username = username;
        
        setTitle("Chat - " + username);
        setSize(600, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());
        
        messageArea = new JTextArea();
        messageArea.setEditable(false);
        messageArea.setFont(new Font("Arial", Font.PLAIN, 14));
        messageArea.setBackground(Color.WHITE);
        JScrollPane scrollPane = new JScrollPane(messageArea);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        
        JPanel inputPanel = new JPanel(new BorderLayout());
        inputField = new JTextField();
        inputField.setFont(new Font("Arial", Font.PLAIN, 14));
        
        sendButton = new JButton("Send");
        sendButton.setPreferredSize(new Dimension(80, 30));
        
        sendButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                sendMessage();
            }
        });
        
        inputField.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                sendMessage();
            }
        });
        
        inputPanel.add(inputField, BorderLayout.CENTER);
        inputPanel.add(sendButton, BorderLayout.EAST);
        
        add(scrollPane, BorderLayout.CENTER);
        add(inputPanel, BorderLayout.SOUTH);
        
        chatClient = new ChatClient(this);
        chatClient.connect();
        
        updateMessages();
        
        messageTimer = new Timer(500, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                updateMessages();
            }
        });
        messageTimer.start();
        
        addWindowListener(new java.awt.event.WindowAdapter() {
            @Override
            public void windowClosing(java.awt.event.WindowEvent windowEvent) {
                chatClient.disconnect();
                messageTimer.stop();
            }
        });
    }
    
    public void updateMessages() {
        List<Message> messages = chatClient.getMessages();
        StringBuilder sb = new StringBuilder();
        SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
        
        for (Message msg : messages) {
            String timeStr = sdf.format(msg.getTimestamp());
            sb.append("[").append(timeStr).append("] ");
            sb.append(msg.getSender()).append(": ");
            sb.append(msg.getContent()).append("\n");
        }
        
        String currentText = messageArea.getText();
        String newText = sb.toString();
        
        if (!currentText.equals(newText)) {
            messageArea.setText(newText);
            messageArea.setCaretPosition(messageArea.getDocument().getLength());
        }
    }
    
    private void sendMessage() {
        String content = inputField.getText().trim();
        if (!content.isEmpty()) {
            chatClient.sendMessage(username, content);
            inputField.setText("");
        }
    }
}

