package com.example.functional;

import java.util.Arrays;

public class TestFunctional {

	public static void main(String[] args) {
		/**
		 * Example of functionality as argument
		 * */
		
		String[] names = {"Alice", "Bob", "Charles", "David"};
		Arrays.sort(names);
		System.out.println("sorted names(natural order) : " + Arrays.toString(names));
		
		// sorting using a custom comparator
		Arrays.sort(names, new LengthComparator());
		System.out.println("sorted names(by length) : " + Arrays.toString(names));
		
		// sorting using lambda expression
		Arrays.sort(names, (a, b) -> Integer.compare(a.length(), b.length()));
		System.out.println("sorted names(by length using lambda) : " + Arrays.toString(names));
		
		Arrays.sort(names, (a, b) -> a.length() - b.length());
		System.out.println("sorted names(by length using lambda2) : " + Arrays.toString(names));
		
		/**
		 * by passing the functionality(i.e, the comparator or lambda expression) as an
		 * argument, the `Arrays.sort` method can utilize it to achieve the desired sorting
		 * behaviour
		 * 
		 * This example demonstrates hoe functionality can be passed as an argument to
		 * another function.
		 * 
		 * */
		
	}

}
