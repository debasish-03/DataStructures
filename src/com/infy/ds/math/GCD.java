package com.infy.ds.math;

public class GCD {

	public static void main(String[] args) {
		int a = 0, b = 56;
		System.out.println("GCD of "+ a +" and "+ b +" = "+ gcd(a, b));
	}
	private static int gcd(int num1, int num2) {
		if(num1 == 0 || num2 == 0) return num1 == 0? num2 : num1; 
		if(num2 == num1) return num1;
		if(num1 > num2) return gcd(num1-num2, num2);
		return gcd(num1, num2-num1);
	}

}
