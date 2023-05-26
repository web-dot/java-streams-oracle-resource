package com.example.functional;

import java.util.Comparator;

public class LengthComparator implements Comparator<String> {
	
	@Override
	public int compare(String a, String b) {
		return Integer.compare(a.length(), b.length());
	}
}
