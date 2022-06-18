package com.infy.ds.linkedlist;

import java.util.HashSet;

public class LList {

	public static void main(String[] args) {
		LList ll = new LList();
		ll.push(10);
		ll.push(5);
		ll.push(11);
		ll.push(4);
		//ll.push(30);
		ll.push(30);
		ll.push(1);
		ll.push(20);
		ll.push(11);
		ll.print();
//		ll.append(1);
//		ll.print();
//		ll.insertAfter(1, 100);
//		ll.print();
//		ll.insertBefore(11,200);
//		ll.push(5);
//		ll.print();
//		ll.deleteNode(5);
//		ll.print();
//		ll.reverse();
//		ll.print();
//		ll.sort();
//		ll.print();
//		ll.removeduplicate();
//		ll.print();
//		System.out.println("\n===========================");
//		Node node = ll.reverseKGroup(ll.head, 3);
//		System.out.println();
//		while(node != null) {
//			System.out.print(node.data+" => ");
//			node = node.next;
//		}
		
		Node lastNode = ll.lastNode();
		Node middleNode = ll.findNode(30);
		if(lastNode != null && middleNode != null) {
			lastNode.next = middleNode;
		} else {
			System.out.println("There is no such node in List.");
		}
		Node nodeInLoop = ll.detectLoop();
		if(nodeInLoop != null) {
			int length = ll.findLengthOfLoop(nodeInLoop);
			System.out.println("Length of Loop: "+ length);
		}
		ll.removeLoopInList1();
		ll.detectLoop();
		
		ll.print();
		
		// this method will print the reverse of linked list but without reversing the actual LList
		Node headRef = ll.head;
		System.out.println();
		ll.printReverse(headRef);
		

	}
	 private void printReverse(Node node) {
		 if(node == null) {
			 return;
		 }
		 printReverse(node.next);
		 System.out.print(node.data+" ");
	}
	private void removeLoopInList1() {
		 if(head == null) {
			 System.out.println("List is empty");
			 return;
		 }
		 HashSet<Node> hs = new HashSet<>();
		 Node curr = head;
		 Node prev = null;
		 while(curr != null) {
			 if(hs.contains(curr)) {
				 prev.next = null;
				 System.out.println("Loop removed");
				 return;
			 }
			 prev = curr;
			 hs.add(curr);
			 curr = curr.next;
		 }
		 if(curr == null) {
			 System.out.println("Loop not detected");
		 }
	}
	 private void removeLoopInList() {
		 if(head == null) {
			 System.out.println("List is empty");
			 return;
		 }
		 Node node = detectLoop();
		 if(node == null) {
			 System.out.println("No loop detected");
			 return;
		 }
		 int length = findLengthOfLoop(node);
		 Node curr = head;
		 Node distance = head;
		 for(int i=0; i<length; i++) {
			 distance = distance.next;
		 }
		 while(distance != curr) {
			 curr = curr.next;
			 distance = distance.next;
		 }
		 while(distance.next != curr) {
			 distance = distance.next;
		 }
		 distance.next = null;
		 System.out.println("Loop removed");
	}
	private int findLengthOfLoop(Node nodeInLoop) {
		 int count = 1;
		 Node temp = nodeInLoop;
		 while(temp.next != nodeInLoop) {
			 count++;
			 temp = temp.next;
		 }
		return count;
	}
	private Node detectLoop() {
		 if(head == null) {
			 System.out.println("List is empty");
			 return head;
		 }
		 Node slow = head;
		 Node fast = head;
		 while(slow != null && fast != null && fast.next != null) { 
			 slow = slow.next;
			 fast = fast.next.next;
			 if(slow == fast) {
				 System.out.println("\nLoop detected in list");
				 return slow;
			 }
			 
		 }
		 if(fast == null) {
			 System.out.println("\nNo loop detected in list");
		 }
		 return null;
	}
	private  Node findNode(int dataToBeSearched) {
		 if(head == null) {
			 System.out.println("List is empty");
			 return head;
		 }
		 Node curr = head;
		 while(curr != null && curr.data != dataToBeSearched) {
			 curr = curr.next;
		 }
		 if(curr != null) {
			 return curr;
		 } else {
			 System.out.println("\nNode is not present in List");
			 return null;
		 }
	}
	private  Node lastNode() {
		Node curr = head;
		if(curr == null) {
			System.out.println("List is empty");
			return head;
		}
		while(curr.next != null) {
			curr = curr.next;
		}
		return curr;
	}
	public Node reverseKGroup(Node head, int k) {
	        Node curr=head,prev=null,next=null;
	        int count=0;
	        while(curr!=null && count<k){
	            next=curr.next;
	            curr.next=prev;
	            prev=curr;
	            curr=next;
	            count++;
	        }
	        if(next!=null){
	            Node rest_head=reverseKGroup(next,k);
	            head.next=rest_head;
	        }else if(count!=k){
	            curr = prev; prev = null; next = null;
	            System.out.println("\ncurr => "+curr.data); //10
	            while(curr!=null){
	                next = curr.next; 
	                if(next != null) {
	                	System.out.println("\nnext => "+next.data);
	                }
	                curr.next = prev;
	                prev = curr;
	                System.out.println("prev => "+prev.data);// == null
	                curr = next;
	                count++;
	                System.out.println("count = "+count);
	            }
	        }
	        return prev;
	    }
	

	private void removeduplicate() {
		if(head == null) {
			System.out.println("List is empty removeduplicate operation can't be performed.");
			return;
		}
		Node curr = head, prev = head;
		while(curr != null) {
			if(prev.data != curr.data) {
				prev.next = curr;
				prev = curr;
			}
			curr = curr.next;
		}
		if(prev != curr) {
			prev.next = null;
		}
	}

	private void sort() {
		if(head == null) {
			System.out.println("List is empty can't perform sorting operation.");
			return;
		}
	
		Node curr = head;
		Node sorted = null;
		while(curr != null) {
			Node next = curr.next;
			sorted = insertionSort(sorted, curr);
			curr = next;
		}
		head = sorted;
	}
	
	private Node insertionSort(Node sorted, Node node) {
		if(sorted == null || sorted.data > node.data) {
			node.next = sorted;
			sorted = node;
		} else {
			Node curr = sorted;
			while(curr.next != null && curr.next.data < node.data) {
				curr = curr.next;
			}
			node.next = curr.next;
			curr.next = node;
		}
		return sorted;
	}

	private void reverse() {
		if(head == null) {
			System.out.println("List is empty can't perform sort operation.");
			return;
		}
		Node curr = head;
		Node prev = null;
		Node next = null;
		while(curr != null) {
			next = curr.next;
			curr.next = prev;
			prev = curr;
			curr = next;
		}
		head = prev;
	}

	private void deleteNode(int dataToBeDeleted) {
		if(head == null) {
			System.out.println("List is empty can't perform delete operation.");
			return;
		}
		if(head.data == dataToBeDeleted) {
			head = head.next;
			return;
		}
		Node curr = head;
		Node prev = null;
		while(curr != null && curr.data != dataToBeDeleted) {
			prev = curr;
			curr = curr.next;
		}
		if(prev == null) {
			System.out.println("No such node is present");
			return;
		}
		prev.next = curr.next;
		
	}

	private void insertBefore(int node, int dataToBeInserted) {
		if(head == null) {
			System.out.println("List is emplty");
			return;
		}
		Node newNode = new Node(dataToBeInserted);
		if(head.data == node) {
			newNode.next = head;
			head = newNode;
			return;
		}
		Node prev = null;
		Node curr = head;
		while(curr != null && curr.data != node) {
			prev = curr;
			curr = curr.next;
		}
		if(prev == null) {
			System.out.println("\nNo such node present in list");
			return;
		}
		newNode.next = curr;
		prev.next = newNode;
	}

	private void insertAfter(int node, int dataToBeInserted) {
		if(head == null) {
			System.out.println("List is Emplty can't insert");
			return;
		}
		Node newNode = new Node(dataToBeInserted);
		Node curr = head;
		while(curr != null && curr.data != node) {
			curr = curr.next;
		}
		if(curr == null) {
			System.out.println("\nNo such node present in List");
			return;
		}
		newNode.next = curr.next;
		curr.next = newNode;
	}

	private void append(int dataToBeAppend) {
		Node newNode = new Node(dataToBeAppend);
		if(head == null) {
			head = newNode;
			return;
		}
		Node curr = head;
		while(curr.next != null) {
			curr = curr.next;
		}
		curr.next = newNode;
	}

	private void print() {
		if(head == null) {
			System.out.println("List is Empty");
			return;
		}
		Node curr = head;
		System.out.println("\nElements in List are:");
		while(curr != null) {
			System.out.print(curr.data+" ");
			curr = curr.next;
		}
	}

	private void push(int dataToBePush) {
		Node newNode = new Node(dataToBePush);
		if(head == null) {
			head = newNode;
			return;
		}
		newNode.next = head;
		head = newNode;
	}
	Node head;
	class Node{
		int data;
		Node next;
		public Node(int data) {
			this.data = data;
			next = null;
		}
	}
}
