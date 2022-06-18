package com.infy.ds.searchingandsorting;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CompareSort {

	public static void main(String[] args) {
		List<Student> studentList = new ArrayList<>();
		
		Student s1 = new Student("Amit", 1, 89);
		Student s2 = new Student("Deb", 2, 74);
		Student s3 = new Student("Anuj", 3, 55);
		Student s4 = new Student("Kalia", 4, 61);
		Student s5 = new Student("Anu", 3, 55);
		
		studentList.add(s1);
		studentList.add(s2);
		studentList.add(s3);
		studentList.add(s4);
		studentList.add(s5);
		
		System.out.println("Before soring student list: ");
		System.out.println(studentList.toString());
		
		System.out.println("After soring student list by marks student list: ");
		Collections.sort(studentList, (student1, student2) -> student1.avgMark - student2.avgMark);
		System.out.println(studentList.toString());
		
		System.out.println("After soring student list by marks and name student list: ");
		Collections.sort(studentList, (student1, student2) -> student1.avgMark != student2.avgMark ? student1.avgMark - student2.avgMark : student1.name.compareTo(student2.name));
		System.out.println(studentList.toString());
	}

}

class Student {
	public String name;
	public int rollNo;
	public int avgMark;
	public Student() {
		
	}
	public Student(String name, int rollNo, int avgMark) {
		super();
		this.name = name;
		this.rollNo = rollNo;
		this.avgMark = avgMark;
	}
	@Override
	public String toString() {
		return "Student [name=" + name + ", rollNo=" + rollNo + ", avgMark=" + avgMark + "]";
	}
	
}