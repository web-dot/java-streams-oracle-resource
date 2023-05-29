package com.example.streams;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;


class Person {
    private String name;
    private int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}

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
		
		//Listing2
//		List<Integer> transactionsIds = 
//			    transactions.stream()
//			                .filter(t -> t.getType() == Transaction.GROCERY)
//			                .sorted(comparing(Transaction::getValue).reversed())
//			                .map(Transaction::getId)
//			                .collect(toList());
		
		
		// stream non-terminal operations
		
		List<Integer> numbers = Arrays.asList(5, 3, 7, 8, 2, 9, 10, 7, 1, 6, 4, 9);
		
		// filter
		List<Integer> evenNumbers = numbers.stream()
		.filter(n -> n%2 == 0) // Predicate<T> , test()
		.collect(Collectors.toList());
		System.out.println(evenNumbers);
		
		// map
		List<Integer> squaredNumbers =  numbers.stream()
		.map(n -> n*n) // Function<T, T> , apply()
		.collect(Collectors.toList());
		System.out.println(squaredNumbers);
		
		// sorted
		List<Integer> sortedNumbers = numbers.stream()
		.sorted()
		.collect(Collectors.toList());
		System.out.println(sortedNumbers);
		
		// reduce
		int sum = numbers.stream()
		.reduce(0, Integer::sum); // BinaryOperator<T>
		System.out.println(sum);
		
		// distinct
		List<Integer> distinctNumbers =  numbers.stream()
		.distinct()
		.collect(Collectors.toList());
		System.out.println(distinctNumbers);
		
		// limit 
		List<Integer> limitedNumbers = numbers.stream()
		.limit(5)
		.collect(Collectors.toList());
		System.out.println(limitedNumbers);
		
		// skip
		List<Integer> skippedNumbers = numbers.stream()
		.skip(3)
		.collect(Collectors.toList());
		System.out.println(skippedNumbers);
		
		/**
		 * filter()
		 * map()
		 * reduce()
		 * distinct()
		 * 
		 * sorted()
		 * 
		 * limit()
		 * skip()
		 * 
		 * 
		 * */
		
		
		// streams terminal operations
		
		List<Person> people  = Arrays.asList(
				new Person("Alice", 25),
                new Person("Bob", 30),
                new Person("Charlie", 35),
                new Person("Dave", 40),
                new Person("Eve", 45)
				);
		
		// count
		long count = people.stream()
		.count();
		System.out.println(count);
		
		
		// anyMatch - checks if at least one element satisfies condition 
		boolean anymatch = people.stream()
		.anyMatch(person -> person.getAge() <= 25);
		System.out.println(anymatch);
		
		// allMatch - checks if all elements satisfies condition
		boolean allMatch =  people.stream()
		.allMatch(person -> person.getAge() <= 25);
		System.out.println(allMatch);
		
		
		
		
		
	}
}
