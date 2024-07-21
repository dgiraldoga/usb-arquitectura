package main.java.com.example.server;

import main.java.com.example.Connect;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Server {
    private ServerSocket serverSocket;

    {
        try {
            serverSocket = new ServerSocket(Connect.CONNECTION.getPort());
        } catch (IOException e) {
            e.printStackTrace();
        }

    }


    public void start() throws IOException {

        while (true) {
            new ClientHandler(serverSocket.accept()).start();
        }
    }

    public void stop() throws IOException {
        serverSocket.close();
    }

    private static class ClientHandler extends Thread {
        private Socket clientSocket;
        private PrintWriter out;
        private BufferedReader in;

        public ClientHandler(Socket socket) {
            this.clientSocket = socket;
        }

        public void run() {
            try {
                this.out = new PrintWriter(clientSocket.getOutputStream(), true);
                this.in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));

                Pattern pattern = Pattern.compile("^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[!@#$%&*])[A-Za-z\\d!@#$%&*]{8,}$");
                InetAddress inetAddress = InetAddress.getLocalHost();
                String inputLine;


                while ((inputLine = in.readLine()) != null) {
                    Matcher matcher = pattern.matcher(inputLine);
                    if (matcher.find()) {
                        out.println("Welcome " + inetAddress.getHostName());
                        break;
                    } else {
                        out.println("unrecognized message");
                    }
                }

                in.close();
                out.close();
                clientSocket.close();

            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }


}
