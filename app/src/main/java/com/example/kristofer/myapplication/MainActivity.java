package com.example.kristofer.myapplication;

import android.database.DataSetObserver;
import android.graphics.PorterDuff;
import android.graphics.drawable.AnimatedStateListDrawable;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.GridLayout;


import com.example.kristofer.myapplication.core.Board;
import com.example.kristofer.myapplication.core.BoardState;
import com.example.kristofer.myapplication.core.OthelloActionListener;
import com.example.kristofer.myapplication.core.OthelloColor;
import com.example.kristofer.myapplication.core.StateObserver;

public class MainActivity extends AppCompatActivity implements StateObserver {


    Button[][] buttons = new Button[Board.BOARD_SIZE][Board.BOARD_SIZE];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.gridlayout);

        GridLayout grid = (GridLayout) findViewById(R.id.boardLayout);

        Board board = new Board();
        board.initialize();

        for(int i = 0; i < Board.BOARD_SIZE; ++i) {
            for (int j = 0; j < Board.BOARD_SIZE; ++j) {
                buttons[i][j] = new Button(this);
                buttons[i][j].setOnClickListener(new OthelloActionListener(board, i, j));
                grid.addView(buttons[i][j]);
                buttons[i][j].setPadding(0,0,0,0);
            }
        }

        board.registerStateObserver(this);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void updateState(BoardState s) {
        for(int i = 0; i < Board.BOARD_SIZE; i++) {
			for(int j = 0; j < Board.BOARD_SIZE; j++) {
				if(s.disks[i][j] == OthelloColor.WHITE) {
					buttons[i][j].getBackground().setColorFilter(0xFFFFFFFF, PorterDuff.Mode.MULTIPLY);

				}
				else if(s.disks[i][j] == OthelloColor.BLACK) {
                    buttons[i][j].getBackground().setColorFilter(0xFF000000, PorterDuff.Mode.MULTIPLY);
				}
			}
	    }

	    String player;
	    if(s.currentPlayer == OthelloColor.WHITE)
	    	player = "White's turn";
	    else
	    	player = "Black's turn";
    }
}
