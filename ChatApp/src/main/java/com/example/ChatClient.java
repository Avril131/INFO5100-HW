package com.example;

import java.io.*;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

public class ChatClient {
    private static final String SERVER_HOST = "localhost";
    private static final int SERVER_PORT = 8888;
    private Socket socket;
    private PrintWriter out;
    private BufferedReader in;
    private List<Message> messages = new ArrayList<>();
    private ChatFrame chatFrame;
    private boolean connected = false;
    
    public ChatClient(ChatFrame chatFrame) {
        this.chatFrame = chatFrame;
    }
    
    public void connect() {
        try {
            socket = new Socket(SERVER_HOST, SERVER_PORT);
            out = new PrintWriter(socket.getOutputStream(), true);
            in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            connected = true;
            
            new Thread(new Runnable() {
                @Override
                public void run() {
                    try {
                        String inputLine;
                        while ((inputLine = in.readLine()) != null) {
                            String[] parts = inputLine.split("\\|", 3);
                            if (parts.length == 3) {
                                String sender = parts[0];
                                String content = parts[1];
                                long timestamp = Long.parseLong(parts[2]);
                                Message msg = new Message(sender, content);
                                msg.getTimestamp().setTime(timestamp);
                                addMessage(msg);
                            }
                        }
                    } catch (IOException e) {
                    } finally {
                        connected = false;
                    }
                }
            }).start();
        } catch (IOException e) {
            connected = false;
        }
    }
    
    private synchronized void addMessage(Message msg) {
        boolean exists = false;
        for (Message m : messages) {
            if (m.getSender().equals(msg.getSender()) && 
                m.getContent().equals(msg.getContent()) && 
                Math.abs(m.getTimestamp().getTime() - msg.getTimestamp().getTime()) < 1000) {
                exists = true;
                break;
            }
        }
        
        if (!exists) {
            messages.add(msg);
            if (chatFrame != null) {
                chatFrame.updateMessages();
            }
        }
    }
    
    public synchronized List<Message> getMessages() {
        return new ArrayList<>(messages);
    }
    
    public void sendMessage(String sender, String content) {
        if (connected && out != null) {
            out.println("SEND:" + sender + "|" + content);
        }
    }
    
    public void disconnect() {
        connected = false;
        try {
            if (socket != null) {
                socket.close();
            }
        } catch (IOException e) {
        }
    }
    
    public boolean isConnected() {
        return connected;
    }
}

