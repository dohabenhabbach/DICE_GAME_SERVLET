package com.example.solution.bo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;



public class GameState {

	private User user;
    private int total;




    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    private boolean gameOver = false;



	private List<Message> messages = new ArrayList<Message>();

	private ArrayList<Integer> dices = new ArrayList<Integer>();;

	Map<Integer,Integer> diceResults = new HashMap< Integer,Integer>();


	public Map<Integer, Integer> getDiceResults() {
		return diceResults;
	}

	public void setDiceResults(Map<Integer, Integer> diceResults) {
		this.diceResults = diceResults;
	}

	public ArrayList<Integer> getDices() {
		return dices;
	}

	public void setDices(ArrayList<Integer> dices) {
		this.dices = dices;
	}

	public void reinit() {
		gameOver = false;
		messages = new ArrayList<Message>();
		this.user.setScore(0);
		user.setCompteurLancer(0);

	}

	public String toString() {
		return "GameState [Score=" + user.getScore() + ", nombre lancers=" + user.getCompteurLancer() + ", messages="
				+ messages + "]";
	}

	public void addMessage(Message ms) {
		messages.add(ms);
	}

	public GameState(User user) {
		this.user = user;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public boolean isGameOver() {
		return gameOver;
	}

	public void setGameOver(boolean gameOver) {
		this.gameOver = gameOver;
	}

	public List<Message> getMessages() {
		return messages;
	}

	public void setMessages(List<Message> messages) {
		this.messages = messages;
	}



}
