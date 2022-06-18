package com.infy.ds.stackandqueue;

public class StackImplLinkedList {
	StackNode root;
	
	static class StackNode {
		int data;
		StackNode next;
		StackNode(int data) {
			this.data = data;
		}
	}
	public void push(int data) {
		StackNode newNode = new StackNode(data);
		if(root == null) {
			root = newNode;
			System.out.println("Pushed into Stack "+data);
			return;
		}
		StackNode temp = root;
		root = newNode;
		newNode.next = temp;
		System.out.println("Pushed into Stack "+data);
		return;
	}
	public boolean isEmpty() {
		if(root == null) return true;
		return false;
	}
	public int peek() {
		if(root == null) {
			System.out.println("Stack is empty");
			return Integer.MIN_VALUE;
		}
		
		return root.data;
	}
	public int pop() {
		if(root == null) {
			System.out.println("Stack is empty");
			return Integer.MIN_VALUE;
		}
		int popped = root.data;
		root = root.next;
		return popped;
	}
	public void print() {
		StackNode curr = root;
		if(root == null) {
			return;
		}
		while(curr != null) {
			System.out.print(curr.data+" ");
			curr = curr.next;
		}
	}
	public static void main(String[] args) {
		StackImplLinkedList sll = new StackImplLinkedList();
		 
	        sll.push(10);
	        sll.push(20);
	        sll.push(30);
	 
	        System.out.println(sll.pop()
	                           + " popped from stack");
	 
	        System.out.println("Top element is " + sll.peek());
	        
	        sll.print();

	}

}
