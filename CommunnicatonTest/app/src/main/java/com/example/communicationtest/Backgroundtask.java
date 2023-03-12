package com.example.communicationtest;

import android.os.AsyncTask;
import android.util.Log;

import java.io.DataOutputStream;
import java.io.IOException;
import com.esotericsoftware.kryonet.Client;
import com.esotericsoftware.kryonet.Connection;
import com.esotericsoftware.kryonet.Listener;

import java.net.Socket;

public class Backgroundtask {

    String ip = "https://se2-isys.aau.at:53212/";
    String message;
    String port = "53212";

    Client client;


    public void start(int message) throws IOException {
        client = new Client();
        client.start();
        client.connect(0,ip,Integer.parseInt(port));
        SomeRequest request = new SomeRequest();
        request.messageNumber = message;
        client.sendTCP(request);

        client.addListener(new Listener(){
            public void received(Connection connection, Object object){
                if(object instanceof SomeRequest){
                    SomeResponse response = (SomeResponse) object;
                    Log.d("respponse",Integer.toString(response.messageNumber));
                }
            }
        });
    }


}
