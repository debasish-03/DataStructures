package com.infy.ds.linkedlist;

public class MergeSortOnDoublyLL {
	static Node head;
	public static void main(String[] args) {
		MergeSortOnDoublyLL list = new MergeSortOnDoublyLL();
        list.head = new Node(10);
        list.head.next = new Node(30);
        list.head.next.next = new Node(3);
        list.head.next.next.next = new Node(4);
        list.head.next.next.next.next = new Node(20);
        list.head.next.next.next.next.next = new Node(5);
         
         
        Node node = null;
        node = list.mergeSort(head);
        System.out.println("Linked list after sorting :");
        list.printList(node);

	}
	static class Node{
		int data;
		Node prev, next;
		Node(int data) {
			this.data = data;
			next = prev = null;
		}
	}
	private static Node mergeSort(Node head) {
		if(head == null || head.next == null) return head;
		
		Node head2 = splitNode(head); // same as finding middle
		Node left = mergeSort(head);
		Node right = mergeSort(head2);
		Node res = mergeNode(left, right);
		return res;
	}
	private static Node splitNode(Node node) {
		Node slow = node;
		Node fast = node;
		while(fast.next != null && fast.next.next != null) {
			slow = slow.next;
			fast = fast.next.next;
		}
		Node secNode = slow.next;
		slow.next = null;
		return secNode;
	}
	private static Node mergeNode(Node head1, Node head2) {
		if(head1 == null || head2 == null) return head1 == null ? head2 : head1;
		if(head1.data < head2.data) {
			head1.next = mergeNode(head1.next, head2);
			head1.next.prev = head1;
			head1.prev = null;
			return head1;
		} else {
			head2.next = mergeNode(head1, head2.next);
			head2.next.prev = head2;
			head2.prev = null;
			return head2;
		}
	}
	private static void printList(Node node) {
		Node temp = node;
		System.out.println("Print left to right");
		while(node != null) {
			System.out.print(node.data +" ");
			temp = node;
			node = node.next;
		}
		System.out.println();
		System.out.println("Print right to left");
		while(temp != null) {
			System.out.print(temp.data +" ");
			temp = temp.prev;
		}
	}

}
