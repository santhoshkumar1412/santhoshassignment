package santhosh;
import java.io.*;
import java.net.*;
public class ChatClient {
    public static void main(String[] args) {
        try {
            Socket socket = new Socket("localhost", 12356);
            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
            BufferedReader user = new BufferedReader(new InputStreamReader(System.in));
            System.out.println(in.readLine()); 
            new Thread(() -> {
                try {
                    String serverMsg;
                    while ((serverMsg = in.readLine()) != null)
                        System.out.println(serverMsg);
                } catch (IOException e) { }
            }).start();
            String msg;
            while (true) {
                msg = user.readLine();
                out.println(msg);
                if (msg.equalsIgnoreCase("bye")) break;
            }
            socket.close();
        } catch (Exception e) {
            System.out.println("Error: " + e);
        }
    }
}