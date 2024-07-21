package main.java.com.example.client;

import main.java.com.example.Connect;

import javax.swing.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.sql.Connection;

public class Client {

    private Socket clientSocket;
    private PrintWriter out;
    private BufferedReader in;

    public void startConnection() throws IOException{
        this.clientSocket = new Socket(Connect.CONNECTION.getIp(), Connect.CONNECTION.getPort());
        this.out = new PrintWriter(clientSocket.getOutputStream(), true);
        this.in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
    }


    public String sendMessage (String msg) throws IOException{
        this.out.println(msg);
        return in.readLine();
    }

    public void stopConnection() throws IOException{
        in.close();
        out.close();
        clientSocket.close();
    }

}
