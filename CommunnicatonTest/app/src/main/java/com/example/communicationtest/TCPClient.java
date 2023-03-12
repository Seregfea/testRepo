package com.example.communicationtest;

import android.util.Log;
import android.widget.TextView;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

public class TCPClient implements Runnable {
    String ip = "143.205.174.165";
    String messages;
    int port = 53212;
    Socket clientSocket;
    DataOutputStream outToServer;
    BufferedReader inFromServer;
    private final TextView outputText;

    public TCPClient(TextView outputText, String message){
        this.outputText = outputText;
        this.messages = message;
    }

    private void connect(){

        try {
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

    private void send() throws IOException {
        outToServer.writeBytes(this.messages+'\n');
    }

    private void close(String output) throws IOException {
        this.outputText.setText(output);
        clientSocket.close();
    }

    @Override
    public void run() {
        connect();
        try {
            send();
            Log.d("serverFi", "-------------connected----------------"+this.messages);

            this.messages = inFromServer.readLine();
            Log.d("serverO","-------------------connected------------------" +this.messages);
            close(messages);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
