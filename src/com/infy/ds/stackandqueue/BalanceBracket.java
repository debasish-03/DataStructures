package com.infy.ds.stackandqueue;
import java.util.Stack;

public class BalanceBracket {
		public static void main(String[] args) {
			String s = "()";
			System.out.println(isValid(s));
		}

	    private static boolean isValid(String s) {
	        Stack<Character> st = new Stack<>();
	        
	        for(int i=0; i<s.length(); i++) {
	            char ch = s.charAt(i);
	            if(st.isEmpty()) {
	                st.push(ch);
	            } else {
	            	
		                if(ch == '[' || ch == '{' || ch == '(') {
		                    st.push(ch);
		                } else {
		                    if( (ch == ']' && st.peek() == '[') || (ch == ')' && st.peek() == '(') || (ch == '}' && st.peek() == '{') ) {
		                        st.pop();
		                    } else {
		                        st.push(ch);
		                    }
		                }
		            
	            }
	            
	        }
	        if(st.isEmpty()) return true;
	        
	        return false;
	    }
	}