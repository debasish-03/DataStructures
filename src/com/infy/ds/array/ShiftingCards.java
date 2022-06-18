package com.infy.ds.array;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ShiftingCards {

	public static void main(String[] args) {
		List<String> cardList = new ArrayList<>();
		String[] list = {"black", "blue", "green", "yellow", "pink"};
		Collections.addAll(cardList, list);
		String card = "black";
		int startIndex = 3;
		System.out.println(solveCard(cardList, startIndex, card));
	}
	private static int solveCard(List<String> cardList, int startIndex, String card) {
		int res = 0;
		int forward=0, backward=0;
		int endIndex = cardList.indexOf(card);
		if(startIndex == endIndex) {
			return 0;
		}
		if(Math.abs(startIndex-endIndex) == 1) {
			return 1;
		}
		if(startIndex < endIndex) {
			forward = endIndex- startIndex;
			backward = startIndex+1+cardList.size()-1-endIndex;
			res =  Math.min(forward, backward);
		}
		if(startIndex > endIndex) {
			forward = cardList.size()-1 - startIndex+1+endIndex;
			backward = startIndex-endIndex;
			res = Math.min(forward, backward);
		}
		return res;
	}

}
