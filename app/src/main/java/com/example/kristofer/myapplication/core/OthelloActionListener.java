package com.example.kristofer.myapplication.core;
import android.view.View;

public class OthelloActionListener implements View.OnClickListener{
	int i; int j;
	Board board;
	
	public OthelloActionListener(Board b, int i, int j) {
		this.i = i;
		this.j = j;
		this.board = b;
	}

	public void onClick(View v) {
		board.putDisk(board.getActivePlayer(), i, j);
	}
}