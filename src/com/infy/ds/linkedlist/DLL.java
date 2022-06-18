package com.infy.ds.linkedlist;

public class DLL {

	public static void main(String[] args) {
		/* Start with the empty list */
        DLL dll = new DLL();
 
        // Insert 6. So linked list becomes 6->NULL
        dll.append(6);
 
        // Insert 7 at the beginning. So
        // linked list becomes 7->6->NULL
        dll.push(7);
 
        // Insert 1 at the beginning. So
        // linked list becomes 1->7->6->NULL
        dll.push(1);
 
        // Insert 4 at the end. So linked
        // list becomes 1->7->6->4->NULL
        dll.append(4);
 
        // Insert 8, after 7. So linked
        // list becomes 1->7->8->6->4->NULL
        dll.InsertAfter(dll.head.next, 8);
       
        // Insert 5, before 8.So linked
        // list becomes 1->7->5->8->6->4
        dll.InsertBefore(dll.head.next.next, 5);
 
        System.out.println("Created DLL is: ");
        dll.printList(dll.head);

	}
	Node head;
	class Node{
		int data;
		Node prev;
		Node next;
		Node(int data) {
			this.data = data;
		}
	}
	public void push(int dataToBePushed) {
		// pushing data
		Node newNode = new Node(dataToBePushed);
		newNode.next = head;
		newNode.prev = null;
		if(head != null) {
			head.prev = newNode;
		}
		head = newNode;
	}
	public void append(int dataToBeAppend) {
		Node newNode = new Node(dataToBeAppend);
		newNode.next = null;
		Node last = head;
		if(head == null) {
			newNode.prev = null;
			head = newNode;
			return;
		}
		while(last.next != null) {
			last = last.next;
		}
		last.next = newNode;
		newNode.prev = last;	
	}
	public void InsertAfter(Node prev, int dataToBeInserted) {
		if(prev == null) {
			System.out.println("Given previous node can't be null");
			return;
		}
		Node newNode = new Node(dataToBeInserted);
		newNode.next = prev.next;
		prev.next = newNode;
		newNode.prev = prev;
		if(newNode.next != null) {
			newNode.next.prev = newNode;
		}
		
	}
	public void InsertBefore(Node next, int dataToBeInserted) {
		if(next == null) {
			System.out.println("Given next node can't be null");
			return;
		}
		Node newNode = new Node(dataToBeInserted);
		newNode.prev = next.prev;
		next.prev = newNode;
		newNode.next = next;
		if(newNode.prev != null) {
			newNode.prev.next = newNode;
		} else {
			head = newNode;
		}
	}
	public void printList(Node node) {
		Node prev = null;
		System.out.println("Left to right: ");
		while(node != null) {
			System.out.print(node.data +" - > ");
			prev = node;
			node = node.next;
		}
		System.out.println();
		System.out.println("Right to left:");
		while(prev != null) {
			System.out.print(prev.data +" - > ");
			prev = prev.prev;
		}
	}

}
