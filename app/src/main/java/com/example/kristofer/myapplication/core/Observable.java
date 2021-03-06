package com.example.kristofer.myapplication.core;
public interface Observable {
	public void registerScoreObserver(ScoreObserver o);
	public void removeScoreObserver(ScoreObserver o);
	public void notifyScoreObservers();
	
	public void registerStateObserver(StateObserver o);
	public void removeStateObserver(StateObserver o);
	public void notifyStateObservers();

	public void registerPlayerMoveObserver(PlayerMoveObserver o);
	public void removePlayerMoveObserver(PlayerMoveObserver o);
	public void notifyPlayerMoveObservers(OthelloColor c, int i, int j);
}
