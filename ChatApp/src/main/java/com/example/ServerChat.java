package com.example;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

public class ServerChat {
    private static final int PORT = 8888;
    private static List<ClientHandler> clients = new ArrayList<>();
    private static List<Message> messages = new ArrayList<>();
    private static ServerSocket serverSocket;
    private static boolean running = false;
    private static Thread serverThread;
    
    public static boolean start() {
        if (running) {
            return true;
        }
        
        try {
            serverSocket = new ServerSocket(PORT);
            running = true;
            
            serverThread = new Thread(new Runnable() {
                @Override
                public void run() {
                    try {
                        while (running) {
                            Socket clientSocket = serverSocket.accept();
                            ClientHandler client = new ClientHandler(clientSocket);
                            clients.add(client);
                            new Thread(client).start();
                        }
                    } catch (IOException e) {
                        if (running) {
                        }
                    }
                }
            });
            serverThread.setDaemon(true);
            serverThread.start();
            return true;
        } catch (IOException e) {
            return false;
        }
    }
    
    public static boolean isServerRunning() {
        try {
            Socket testSocket = new Socket("localhost", PORT);
            testSocket.close();
            return true;
        } catch (IOException e) {
            return false;
        }
    }
    
    public static synchronized void broadcastMessage(Message message) {
        messages.add(message);
        String messageStr = message.getSender() + "|" + message.getContent() + "|" + message.getTimestamp().getTime() + "\n";
        
        List<ClientHandler> clientsToRemove = new ArrayList<>();
        for (ClientHandler client : clients) {
            try {
                client.sendMessage(messageStr);
            } catch (IOException e) {
                clientsToRemove.add(client);
            }
        }
        
        clients.removeAll(clientsToRemove);
    }
    
    public static synchronized List<Message> getMessages() {
        return new ArrayList<>(messages);
    }
    
    private static class ClientHandler implements Runnable {
        private Socket socket;
        private PrintWriter out;
        private BufferedReader in;
        
        public ClientHandler(Socket socket) {
            this.socket = socket;
        }
        
        @Override
        public void run() {
            try {
                in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                out = new PrintWriter(socket.getOutputStream(), true);
                
                for (Message msg : messages) {
                    String messageStr = msg.getSender() + "|" + msg.getContent() + "|" + msg.getTimestamp().getTime() + "\n";
                    out.println(messageStr);
                }
                
                String inputLine;
                while ((inputLine = in.readLine()) != null) {
                    if (inputLine.startsWith("SEND:")) {
                        String[] parts = inputLine.substring(5).split("\\|", 2);
                        if (parts.length == 2) {
                            Message msg = new Message(parts[0], parts[1]);
                            broadcastMessage(msg);
                        }
                    }
                }
            } catch (IOException e) {
            } finally {
                try {
                    socket.close();
                } catch (IOException e) {
                }
                clients.remove(this);
            }
        }
        
        public void sendMessage(String message) throws IOException {
            if (out != null) {
                out.println(message);
            }
        }
    }
}

