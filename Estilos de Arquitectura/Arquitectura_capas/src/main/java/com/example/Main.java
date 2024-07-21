package main.java.com.example;

import main.java.com.example.client.Client;
import main.java.com.example.server.Server;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class Main {

    public static void main(String[] args) {

        MarcoCliente marcoCliente = new MarcoCliente();
        marcoCliente.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }
}

class MarcoCliente extends JFrame {

    public MarcoCliente() {

        setBounds(1000, 100, 700, 150);

        LaminaMarcoCliente milamina = new LaminaMarcoCliente();

        add(milamina);

        setVisible(true);
    }

}

class LaminaMarcoCliente extends JPanel {

    private JTextField text;
    private JButton button;

    public LaminaMarcoCliente() {
        StringBuffer sb = new StringBuffer();

        sb.append("\"The password must contain at least 8 characters, an uppercase letter, a number and a special character\"");

        JLabel txt = new JLabel(sb.toString());


        add(txt);

        text = new JTextField(20);

        add(text);

        button = new JButton("Send");

        SendText sendText = new SendText();
        button.addActionListener(sendText);

        add(button);

    }

    private class SendText implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            new Thread(() -> {
                try {
                    Server server = new Server();
                    server.start();
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
            }).start();

            try {
                Thread.sleep(1000);
            } catch (InterruptedException ex) {
                ex.printStackTrace();
            }
            Client client = new Client();

            try {
                client.startConnection();
                System.out.println(client.sendMessage(text.getText()));
            } catch (IOException ex) {
                ex.printStackTrace();
            }

        }
    }


}
