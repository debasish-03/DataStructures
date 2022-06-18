package com.infy.ds.stackandqueue;

// Stack implementation using Array
public class Stack {
	static final int max = 1000;
	int[] arr = new int[max];
	int top;
	Stack() {
		top = -1;
	}
	
	public boolean isEmpty() {
		if(top < 0) {
			return true;
		}
		return false;
	}
	
	public boolean push(int val) {
		if(top >= max-1) {
			System.out.println("Stack overflow");
			return false;
		}
		arr[++top] = val;
		System.out.println("Pushed into Stack "+val);
		return true;
	}
	public int pop() {
		if(top < 0) {
			System.out.println("Stack underflow");
			return 0;
		}
		int x = arr[top--];
		return x;
	}
	public int peek() {
		if(top < 0) {
			System.out.println("Stack Underflow");
			return 0;
		}
		return arr[top];
	}
	public void print() {
		for(int i=top; i>=0; i--) {
			System.out.print(arr[i]+" -> ");
		}
	}
	public static void main(String[] args) {
		Stack st = new Stack();
		//st.pop();
		System.out.println(st.isEmpty());
		st.push(10);
		st.push(20);
		st.push(30);
		
		
		st.print();
		System.out.println();
		System.out.println("peek "+st.peek());
		System.out.println(st.isEmpty());
	}

}
