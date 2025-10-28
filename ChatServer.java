package santhosh;
import java.io.*;
import java.net.*;
import java.util.*;
public class ChatServer {
    private static final int PORT = 12346;
    private static final List<PrintWriter> clients = new ArrayList<>();
    public static void main(String[] args) {
        try (ServerSocket server = new ServerSocket(PORT)) {
            System.out.println("Chat Server started...");
            while (true) {
                Socket socket = server.accept();
                System.out.println("New client connected: " + socket);
                new ClientHandler(socket).start();
            }
        } catch (Exception e) {
            System.out.println("Error: " + e);
        }
    }
    static class ClientHandler extends Thread {
        Socket socket;
        BufferedReader in;
        PrintWriter out;
        ClientHandler(Socket s) { this.socket = s; }
        public void run() {
            try {
                in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                out = new PrintWriter(socket.getOutputStream(), true);
                synchronized (clients) { clients.add(out); }

                out.println("Welcome to the chat! Type 'bye' to exit.");
                String msg;
                while ((msg = in.readLine()) != null && !msg.equalsIgnoreCase("bye")) {
                    System.out.println("Client: " + msg);
                    broadcast(msg);
                }

                synchronized (clients) { clients.remove(out); }
                socket.close();
                System.out.println("Client disconnected.");

            } catch (Exception e) {
                System.out.println("Error in thread: " + e);
            }
        }

        void broadcast(String msg) {
            synchronized (clients) {
                for (PrintWriter client : clients) {
                    client.println("Message: " + msg);
                }
            }
        }
    }
}