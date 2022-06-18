package com.infy.ds.linkedlist;

import java.util.HashSet;

import com.infy.ds.linkedlist.DLList.Node;

public class RemoveDuplicateFromDoublyLL {

	public static void main(String[] args) {
		DLList dl = new DLList();
		dl.append(1);
		dl.append(2);
		dl.append(3);
		dl.append(2);
		dl.append(5);
		dl.append(3);
		dl.append(4);
		dl.append(1);
		dl.append(5);
		dl.print(dl.head);
		Node head = dl.mergeSort(dl.head);
		dl.removeDuplicateFromDLL(dl.head);
		dl.print(head);
		

	}

}

class DLList {
	Node head;
	class Node{
		int data;
		Node prev, next;
		Node(int data) {
			this.data = data;
		}
	}
	public void removeDuplicateFromDLL(Node head) {
		if(head == null) {
			return;
		}
		HashSet<Integer> hs = new HashSet<>();
		Node curr = head;
		while(curr != null) {
			if(hs.contains(curr.data)) {
				Node nextNode = curr.next;
				deleteNode(curr);
				curr = nextNode;
			} else {
				hs.add(curr.data);
				curr = curr.next;
			}
		}
	}
	/*
	public void removeDuplicateFromDLL(Node head) {
		if(head == null) return;
		Node node = head;
		while(node.next != null) {
			if(node.data == node.next.data) {
				deleteNode(node.next);
			} else {
				node = node.next;
			}
		}
	}
	*/
	/*
	public void removeDuplicateFromDLL(Node head) {
		if(head == null || head.next == null) {
			return;
		}
		for(Node n1 = head; n1 != null; n1 = n1.next) {
			Node n2 = n1.next;
			while(n2 != null) {
				if(n1.data == n2.data) {
					Node pnext = n2.next;
					deleteNode(n2);
					n2 = pnext;
				} else {
					n2 = n2.next;
				}
			}
		}
	}
	*/

	public void deleteNode(Node n) {
		if(head == null || n == null) {
			return;
		}
		if(head == n) {
			head = n.next;
		}
		if(n.next != null) {
			n.next.prev = n.prev;
		}
		if(n.prev != null) {
			n.prev.next = n.next;
		}
	}
	
	public void push(int dataToBePushed) {
		Node newNode = new Node(dataToBePushed);
		newNode.prev = null;
		if(head == null) {
			head = newNode;
			return;
		}
		newNode.next = head;
		head.prev = newNode;
		head = newNode;
	}
	public void append(int dataToBeAppend) {
		Node newNode = new Node(dataToBeAppend);
		newNode.next = null;
		if(head == null) {
			newNode.prev = null;
			head = newNode;
			return;
		}
		Node temp = head;
		while(temp.next != null) {
			temp = temp.next;
		}
		temp.next = newNode;
		newNode.prev = temp;
	}
	public void insertAfter(Node pnode, int dataToBeInserted) {
		Node newNode = new Node(dataToBeInserted);
		if(pnode == null) {
			System.out.println("Given Node can't be empty:");
			return;
		}
		newNode.next = pnode.next;
		pnode.next = newNode;
		newNode.prev = pnode;
		if(newNode.next != null) {
			newNode.next.prev = newNode;
		}
	}
	public void insertBefore(Node bnode, int dataToBeInserted) {
		if(bnode == null) {
			System.out.println("Given Node can't be empty:");
			return;
		}
		Node newNode = new Node(dataToBeInserted);
		newNode.prev = bnode.prev;
		bnode.prev = newNode;
		newNode.next = bnode;
		if(newNode.prev != null) {
			newNode.prev.next = newNode;
		} else {
			head = newNode;
		}
		
	}
	public void print(Node head) {
		if(head == null) {
			System.out.println("Emplty List");
			return;
		}
		Node prev = head;
		System.out.println("\nPrinting left-right:");
		while(head != null) {
			prev = head;
			System.out.print(head.data+" ");
			head = head.next;
		}
		System.out.println("\nPrinting right-left:");
		while(prev != null) {
			System.out.print(prev.data+" ");
			prev = prev.prev;
		}
	}
	public Node mergeSort(Node head) {
		if(head == null || head.next == null) {
			return head;
		}
		Node head2 = splitNode(head);
		Node leftNode = mergeSort(head);
		Node rightNode = mergeSort(head2);
		return merge(leftNode, rightNode);
	}
	//Mergeing using loops
	private Node merge(Node n1, Node n2) {
		Node head;
		if(n1.data <= n2.data) {
			head = n1;
			n1 = n1.next;
		} else {
			head = n2;
			n2 = n2.next;
		}
		Node curr = head;
		while(n1 != null && n2 != null) {
			if(n1.data <= n2.data) {
				curr.next = n1;
				n1.prev = curr;
				n1 = n1.next;
			} else {
				curr.next = n2;
				n2.prev = curr;
				n2 = n2.next;
			}
			curr = curr.next;
		}
		while(n1 != null) {
			curr.next = n1;
			n1.prev = curr;
			n1 = n1.next;
			curr = curr.next;
		}
		while(n2 != null) {
			curr.next = n2;
			n2.prev = curr;
			n2 = n2.next;
			curr = curr.next;
		}
		curr.next = null;
		return head;
	}
	/* Mergeing using recursion
	 * private Node merge(Node n1, Node n2) {
		if(n1 == null) {
			return n2;
		}
		if(n2 == null) {
			return n1;
		}
		if(n1.data < n2.data) {
			n1.next = merge(n1.next, n2);
			n1.next.prev = n1;
			n1.prev = null;
			return n1;
		} else {
			n2.next = merge(n1, n2.next);
			n2.next.prev = n2;
			n2.prev = null;
			return n2;
		}
		
	}
	*/
	private Node splitNode(Node node) {
		Node slow = node, fast = node;
		while(fast.next != null && fast.next.next != null) {
			slow = slow.next;
			fast = fast.next.next;
		}
		Node temp = slow.next;
		slow.next = null;
		return temp;
	}
}
