package com.example.streams;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class TestStreams {
	
	
	public static void main(String[] args) {
		
		Transaction t1 = new Transaction("Grocery", "7308", 1594);
		Transaction t2 = new Transaction("Grocery", "1980", 1745);
		Transaction t3 = new Transaction("Grocery", "2703", 1081);
		
		List<Transaction> transactions = new ArrayList<>(Arrays.asList(t1, t2, t3));
		
		/*Let's say we need to find all transactions of type grocery and return a list of
		 * transaction IDs sorted in decreasing order of transaction value.
		 * */ 
		
		
		/*In Java SE7, we'd do as shown in Listing1, in Java SE8, we'd do it as shown in Listing2*/
		
		//Listing1
		List<Transaction> groceryTransactions = new ArrayList<>();
		for(Transaction t : transactions) {
			if(t.getType() == Transaction.GROCERY) {
				groceryTransactions.add(t);
			}
		}
		
		Collections.sort(groceryTransactions, new Comparator<Transaction>() {
			@Override
			public int compare(Transaction t1, Transaction t2) {
				return t2.getValue().compareTo(t1.getValue());
			}
		});
		
		
		List<Integer> transactionIds = new ArrayList<>();
		for(Transaction t : groceryTransactions) {
			transactionIds.add(t.getId());
		}
		
		System.out.println(transactionIds);
		
		
	}
}
