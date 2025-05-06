package de.thi.winfo.socket;

import java.io.*;
import java.net.Socket;

public class GreetingClient {
    private static final String SERVER_NAME = "localhost";
    private static final int PORT = 3141;

    public static void main(String[] args) {
        try {
            System.out.println("Connecting to " + SERVER_NAME + " on port " + PORT);
            Socket client = new Socket(SERVER_NAME, PORT);

            System.out.println("Just connected to " + client.getRemoteSocketAddress());
            OutputStream outToServer = client.getOutputStream();
            DataOutputStream dataOutputStream = new DataOutputStream(outToServer);

            dataOutputStream.writeUTF("Hello from " + client.getLocalSocketAddress());
            InputStream inFromServer = client.getInputStream();
            DataInputStream dataInputStream = new DataInputStream(inFromServer);

            System.out.println("Server says " + dataInputStream.readUTF());
            client.close();
        } catch (IOException e) {
            System.err.println("something went wrong...");
            e.printStackTrace();
        }
    }
}
