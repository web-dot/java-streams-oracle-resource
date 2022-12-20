package com.example.streams;

public class Transaction {

	public static final String GROCERY = "Grocery";

	private int id;
	private String type;
	private String value;

	public Transaction(String type, String value, int id) {
		this.type = type;
		this.value = value;
		this.id = id;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

}
