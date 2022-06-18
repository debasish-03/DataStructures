package com.infy.ds.linkedlist;

public class CLLImpl {

	public static void main(String[] args) {
		// Create a queue and initialize front and rear
        Queue q = new Queue();
        q.front = q.rear = null;
  
        // Inserting elements in Circular Queue
        enqueue(q, 14);
        enqueue(q, 22);
        enqueue(q, 6);
  
        // Display elements present in Circular Queue
        print(q);
  
        // Deleting elements from Circular Queue
        System.out.printf("\nDeleted value = %d", dequeue(q));
        System.out.printf("\nDeleted value = %d", dequeue(q));
  
        // Remaining elements in Circular Queue
        print(q);
  
        enqueue(q, 9);
        enqueue(q, 20);
        print(q);

	}
	static class Node {
		int data;
		Node next;
	}
	static class Queue {
		Node front, rear;
	}
	static void enqueue(Queue q, int data) {
		Node newNode = new Node();
		newNode.data = data;
		if(q.rear == null) {
			q.front = newNode;
		} else {
			q.rear.next = newNode;
		}
		q.rear = newNode;
		q.rear.next = q.front;
	}
	static int dequeue(Queue q) {
		int data;
		if(q.front == null) {
			System.out.println("Queue is empty.");
			return Integer.MAX_VALUE;
		}
		if(q.front == q.rear) {
			data = q.front.data;
			q.front = q.rear = null;
		} else {
			Node temp = q.front;
			data = q.front.data;
			q.front = q.front.next;
			q.rear.next = q.front;
		}
		return data;
	}
	static void print(Queue q) {
		Node node = q.front;
		System.out.printf("\nElements in Circular Queue are: ");
		while(node.next != q.front) {
			System.out.print(node.data+" ");
			node = node.next;
		}
		System.out.print(node.data+" ");
	}

}
