package com.example.solution.bo;


public class Message {

	public static final int INFO = 0;
	public static final int WARN = 1;
	public static final int ERROR = 2;

	public static final int SUCCESS = 3;

	private String text;
	private int type;

	public Message(String text, int type) {
		this.text = text;
		this.type = type;
	}

	@Override
	public String toString() {
		return text;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}

}
