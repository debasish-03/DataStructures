package com.infy.ds.stackandqueue;

public class QueueUsingArray {

	public static void main(String[] args) {
		Queue q = new Queue(1000);
		
		q.enqueue(10);
		q.enqueue(20);
		q.enqueue(30);
		q.enqueue(40);
		
		System.out.println("Front item of queue: "+q.front());
		
		q.print(q);
		
		System.out.println("Rear item of queue: "+q.rear());
		System.out.println("Popping item: "+q.dequeue());
		
		q.print(q);
		
		System.out.println("Front item of queue: "+q.front());
		System.out.println("Rear item of queue: "+q.rear());
		
		q.enqueue(50);
		q.print(q);

	}

}

class Queue{
	int front, rear, size;
	int[] array;
	int capacity;
	
	Queue(int capacity) {
		this.capacity = capacity;
		this.size = front = 0;
		rear = capacity-1;
		array = new int[this.capacity];
	}
	boolean isFull(Queue queue) {
		return (queue.size == queue.capacity);
	}
	boolean isEmpty(Queue queue) {
		return this.size == 0;
	}
	void enqueue(int data) {// checking if queue is full or not
		if(isFull(this)) {
			System.out.println("Queue is overflow");
			return; 
		}
		this.rear = (this.rear+1) % this.capacity;
		this.array[this.rear] = data;
		this.size = this.size+1;
		System.out.println(data+" enqueued into the Queue");
	}
	int dequeue() {
		if(isEmpty(this)) {  //checking if queue is empty or not
			System.out.println("Queue is Under flow");
			return Integer.MIN_VALUE;
		}
		int item = this.array[this.front];
		this.front = (this.front+1) % this.capacity;
		this.size = this.size-1;
		return item;
	}
	int front() {
		if(isEmpty(this)) return Integer.MIN_VALUE;
		return this.array[this.front];
	}
	int rear() {
		if(isEmpty(this)) return Integer.MIN_VALUE;
		return this.array[this.rear];
	}
	void print(Queue queue) {
		for(int i=queue.rear; i>=queue.front; i--) {
			System.out.print(queue.array[i]+" ");
		}
		System.out.println();
	}
}
