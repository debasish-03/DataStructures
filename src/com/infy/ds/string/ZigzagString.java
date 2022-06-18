package com.infy.ds.string;

public class ZigzagString {

	public static void main(String[] args) {
		String s = "PAYPALISHIRING"; 
		int numRows = 3;
		String res = "";
		for(int r=0; r<numRows; r++) { // we will iterate every row
			int step = (numRows-1)*2; // this step we can find the res of 1st and last row
			for(int i=r; i<s.length();i+=step) {
				res += s.charAt(i);
				if(r>0 && r<numRows-1 && i+step-2*r<s.length()) {
					res+=s.charAt(i+step-2*r);
				}
			}
		}
		System.out.println(res);
	}

}
