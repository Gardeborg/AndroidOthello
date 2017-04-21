package com.example.kristofer.myapplication.core;

import java.io.Serializable;

/**
 * Created by kristofer on 2017-04-19.
 */

public class PlayerMove implements Serializable {
    public OthelloColor color;
    public int i;
    public int j;

    public PlayerMove(OthelloColor color, int i, int j) {
        this.color = color;
        this.i = i;
        this.j = j;
    }
}
