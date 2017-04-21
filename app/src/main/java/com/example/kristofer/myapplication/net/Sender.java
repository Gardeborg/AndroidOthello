package com.example.kristofer.myapplication.net;

import com.example.kristofer.myapplication.core.PlayerMove;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.net.UnknownHostException;

/**
 * Created by kristofer on 2017-04-21.
 */

public class Sender implements Runnable {

    PlayerMove move;
    boolean newData = false;
    private final Object lock = new Object();

    public void sendData(PlayerMove move) {
        synchronized (lock) {
            this.move = move;
            newData = true;
        }
    }

    @Override
    public void run() {
        try {
            Socket s = new Socket("10.0.2.2", 9876);
            ObjectOutputStream outputObject = new ObjectOutputStream(s.getOutputStream());
            while (true) {
                synchronized (lock) {
                    if (newData) {
                        outputObject.writeObject(move);
                        outputObject.flush();
                        newData = false;
                    }
                }
            }
        } catch (UnknownHostException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
