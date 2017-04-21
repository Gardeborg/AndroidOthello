package com.example.kristofer.myapplication.net;

import com.example.kristofer.myapplication.core.PlayerMove;
import com.example.kristofer.myapplication.core.PlayerMoveObserver;

/**
 * Created by kristofer on 2017-04-19.
 */

public class Network implements PlayerMoveObserver  {

    Sender sender;

    public Network() {
        sender = new Sender();
        Thread senderThread = new Thread(sender);
        senderThread.start();
    }

    @Override
    public void updateMove(PlayerMove move) {
        sender.sendData(move);
    }
}
