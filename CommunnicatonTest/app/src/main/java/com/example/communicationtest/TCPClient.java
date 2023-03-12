package com.example.communicationtest;

import android.util.Log;
import android.widget.TextView;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

public class TCPClient implements Runnable {
    String ip = "https://se2-isys.aau.at:53212/";
    String messages;
    int port = 53212;
    Socket clientSocket;
    DataOutputStream outToServer;
    BufferedReader inFromServer;
    private TextView outputText;

    public void connect(TextView output){

        try {
            outputText = output;
            clientSocket = new Socket(ip,port);
            outToServer = new DataOutputStream(clientSocket.getOutputStream());
            inFromServer = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
            Log.d("serverC", "-------------connected----------------");
            //message = inFromUser.readLine();
        } catch (IOException e) {
            Log.d("serverC", "-------------connection failed----------------");
            e.printStackTrace();
        }
    }

    public void send(String message) throws IOException {
        outToServer.writeBytes(message+'\n');
    }

    public void close(String output) throws IOException {
        outputText.setText(output);
        clientSocket.close();
    }

    @Override
    public void run() {
        try {
            messages = inFromServer.readLine();
            Log.d("serverO", messages);
            close(messages);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
