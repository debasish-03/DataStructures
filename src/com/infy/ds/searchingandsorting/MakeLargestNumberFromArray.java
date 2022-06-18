package com.infy.ds.searchingandsorting;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MakeLargestNumberFromArray {

	public static void main(String[] args) {
		List<String> numberList = new ArrayList<>();
		numberList.add("050");
		numberList.add("10");
		numberList.add("1");
		System.out.println("Largest number from List: ");
		Collections.sort(numberList, (num1, num2) -> (num2+num1).compareTo((num1+num2)));
		for(String str: numberList) {
			System.out.print(str);
		}
	}

}
