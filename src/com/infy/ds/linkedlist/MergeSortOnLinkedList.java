package com.infy.ds.linkedlist;

public class MergeSortOnLinkedList {

	public static void main(String[] args) {
		Node head = new Node(7);
        Node temp = head;
        temp.next = new Node(10);
        temp = temp.next;
        temp.next = new Node(5);
        temp = temp.next;
        temp.next = new Node(20);
        temp = temp.next;
        temp.next = new Node(3);
        temp = temp.next;
        temp.next = new Node(2);
        temp = temp.next;
 
        // Apply merge Sort
        head = mergeSort(head);
        System.out.print("\nSorted Linked List is: \n");
        printList(head);

	}
	static class Node {
		int data;
		Node next;
		Node(int data) {
			this.data = data;
			next = null;
		}
	}
	private static Node mergeSort(Node head) {
		if(head == null || head.next == null) return head;
		
		//find middle node
	
		Node midNode = findMid(head);
		Node head2 = midNode.next; // get the head of 2nd list
		midNode.next = null;
		Node left = mergeSort(head);
		Node right = mergeSort(head2);
		Node result = mergeNode(left, right);
		return result;
	}
	private static Node findMid(Node node) {
		Node slow = node;
		Node fast = node;
		while(fast.next != null && fast.next.next != null) {
			slow = slow.next;
			fast = fast.next.next;
		}
		return slow;
	}
	private static Node mergeNode(Node head, Node head2) {
		
		Node merged = new Node(-1);
        Node temp = merged;
		while(head != null && head2 != null) {
			if(head.data <= head2.data) {
				temp.next = head;
				head = head.next;
				temp = temp.next;
			} else {
				temp.next = head2;
				head2 = head2.next;
				temp = temp.next;
			}
		}
		while(head != null) {
			temp.next = head;
			head = head.next;
			temp = temp.next;
		}
		while(head2 != null) {
			temp.next = head2;
			head2 = head2.next;
			temp = temp.next;
		}
		return merged.next;
	}
	private static void printList(Node node) {
		while(node != null) {
			System.out.print(node.data+" ");
			node = node.next;
		}
	}

}
