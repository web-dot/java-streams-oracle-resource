package com.example.functional;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

class Student{
	public String name;
	public int age;
	public Student(String name, int age) {
		this.name = name;
		this.age = age;
	}
	@Override
	public String toString() {
		return "name : " + this.name + " age : " + this.age;
	}
}

// defining a local class
interface IsEligible{
	public boolean test(Student s);
};

class Tester implements IsEligible{
	@Override
	public boolean test(Student s) {
		return s.age > 18;
	}
}


public class TestFunctional {

	
	// convert method to lambda
	public static boolean isEven(int x) {
		return x % 2 == 0;
	}
	

	public static List<Student> getEligibleStudents(List<Student> students, IsEligible tester){
		return students.stream().filter(s -> tester.test(s)).collect(Collectors.toList());
	}
	
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
		 * behavior
		 * 
		 * This example demonstrates how functionality can be passed as an argument to
		 * another function.
		 * 
		 * */
		
		
		// Functional interface
	
		/**
		 * The first expression utilizing a lambda expression is the preferred and more
		 * modern approach in Java. It offers `improved readability` and `conciseness`
		 * */
		// isEven method in lambda - 
		Predicate<Integer> isEven = x -> x % 2 == 0;
		Predicate<Integer> isEvenAno = new Predicate() {
			public boolean test(Object t) {
				int n = (Integer)t;
				return n % 2 == 0; 
			};
		};

		/**
		 * Using functionality(method) as behavior(desired result) for user defined
		 * interface 
		 * */
		List<Student> students = new ArrayList<>(Arrays.asList(
				new Student("Ravi", 25),
				new Student("Nitin", 18),
				new Student("Hiten", 22),
				new Student("Kalpana", 16),
				new Student("Rishabh", 23)
				));
		
		Tester tester = new Tester();
		
		
		// passing Tester object for getting the eligible students
		List<Student> getEligiblesByTesterClassObject = getEligibleStudents(students, new Tester());
		System.out.println(getEligiblesByTesterClassObject);
		
		
		// passing an object of IsEligible using Anonymous inner class
		List<Student> getEligiblesByAnonymousInnerClassExpression = getEligibleStudents(students, new IsEligible() {
			@Override
			public boolean test(Student s) {
				return s.age > 18;
			}
		});
		System.out.println(getEligiblesByAnonymousInnerClassExpression);
		
		// passing a lambda expression(functionality as argument)
		List<Student> getEligiblesUsingLamdaExpression = getEligibleStudents(students, s -> s.age > 18);
		System.out.println(getEligiblesUsingLamdaExpression);
	}
}
