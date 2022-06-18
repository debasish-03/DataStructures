package com.infy.ds.linkedlist;



public class LinkedList {
	
	Node head; //head of the list
	static class Node{
		int data;
		Node next;
		Node(int data) {
			this.data = data;
			next = null;
		}
	}
	public void add(int data) {
		if(head == null) {
			head = new Node(data);
			return;
		}
		
		Node prev = head;
		Node newNode = new Node(data);
		newNode.next = null;
		while(prev.next != null) {
			prev = prev.next;
		}
		prev.next= newNode;
	}
	public void print() {
		Node n = head;
		while(n != null) {
			System.out.print(n.data+ "-> ");
			n = n.next;
		}
	}
	public void insert(int pos, int data) {
		Node toAdd = new Node(data); // creating a node of the data
		//cornor case
		if(pos == 0) {
			toAdd.next = head;
			head = toAdd;
			return;
		}
		
		Node pre = head;
		for(int i=0; i<pos-1; i++) {
			pre = pre.next;
		}
		
		toAdd.next = pre.next;
		pre.next = toAdd;
		
	}
	public void delete(int pos) {
		if(head == null) {
			return;
		}
		Node pre = head;
		if(pos == 0) {
			head = pre.next;
			return;
		}
		for(int i=0; i<pos-1 && pre != null; i++) {
			pre = pre.next;
		}
		if(pre == null || pre.next == null) {
			return;
		}
		pre.next = pre.next.next;
	}
	public void deleteNode(int key) {
		
		Node temp = head;
		Node pre = null;
		if(temp != null && key == head.data) {
			head = temp.next;
			return;
		}
		while(temp != null && key != temp.data) {
			pre = temp;
			temp = temp.next;
		}
		if(temp == null) {
			return;
		}
		pre.next = temp.next;
	}
	public static void main(String[] args) {
		LinkedList ll = new LinkedList();
		
		ll.head = new Node(1);
		Node second = new Node(2);
		Node third = new Node(3);
		Node fourth = new Node(4);
		
		ll.head.next = second;
		second.next = third;
		third.next = fourth;
		
//		while(ll.head != null) {
//			System.out.print(ll.head.data+" -> ");
//			ll.head = ll.head.next;
//		}
		//ll.insert(3, 10);
		//ll.delete(0);
		ll.print();
		
		ll.add(200);
		ll.add(300);
		System.out.println();
		ll.print();
		System.out.println();
		LinkedList ll2 = new LinkedList();
		ll2.add(1000);
		ll2.add(2000);
		ll2.add(3000);
		ll2.delete(2);
		//ll2.deleteNode(3000);
		ll2.print();
		
		//System.out.println(ll);
	}

}
