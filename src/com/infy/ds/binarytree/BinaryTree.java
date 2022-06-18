package com.infy.ds.binarytree;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

public class BinaryTree {

	public static void main(String[] args) {
		Node root = createBinaryTree();
		printBinarayTree(root);
//		System.out.print("\nDiameter: " +diameterOfTree(root));
//		addNodeAfter(root, 3, 5);
//		System.out.println("\nAfter adding node: ");
//		printBinarayTree(root);
//		deleteNode(root, 3);
//		System.out.println("\nAfter deleting node: ");
//		printBinarayTree(root);
//		levelOrderTraversal(root);
//		int k = 2;
//		List<Integer> res = allNodesFromDistanceK(root, k);
//		System.out.println("Nodes at distance "+ k + " : ");
//		for(Integer i: res) System.out.print(i+ " ");
		int low = 4; 
		int high = 10;
		int ans = countNodeInRange(root, low, high);
		System.out.println("\n "+ ans);
	}
	private static int countNodeInRange(Node root, int low, int high) {
		if(root == null) return 0;
		int val = 0;
		if(root.data >= low && root.data <= high) {
			val += 1;
		} else {
			val += 0;
		}
		return val + countNodeInRange(root.left, low, high) + countNodeInRange(root.right, low, high);
	}
	private static List<Integer> allNodesFromDistanceK(Node root, int distance) {
		List<Integer> res = new ArrayList<>();
		HashMap<Node, Node> parent = new HashMap<>();
		HashSet<Node> visited = new HashSet<>();
		fillParentMap(parent, root);
		
		//applying bfs
		Queue<Node> q = new LinkedList<Node>();
		q.add(root);
		while(!q.isEmpty()) {
			int size = q.size();
			for(int i=0; i<size; i++) {
				Node temp = q.remove();
				visited.add(temp);
				if(distance == 0) {
					res.add(temp.data);
				}
				if(parent.get(temp) != null && !visited.contains(parent.get(temp))) {
					q.add(parent.get(temp));
				}
				if(temp.left != null && !visited.contains(temp.left)) {
					q.add(temp.left);
				}
				if(temp.right != null && !visited.contains(temp.right)) {
					q.add(temp.right);
				}	
			}
			distance--;
			if(distance < 0) break;
		}
		return res;
	}
	private static void fillParentMap(HashMap<Node, Node> parent, Node root) {
		if(root == null) return;
		if(root.left != null) {
			parent.put(root.left, root);
		}
		if(root.right != null) {
			parent.put(root.right, root);
		}
		fillParentMap(parent, root.left);
		fillParentMap(parent, root.right);
		return;
	}
	
	
	
	private static void levelOrderTraversal(Node root) {
		if(root == null) {
			System.out.println("Binaray Tree is empty can't perform level order traversal");
			return;
		}
		System.out.println("\nBinaray Tree level order traversal:");
		Queue<Node> q = new LinkedList<>();
		q.add(root);
		while(!q.isEmpty()) {
			int size = q.size();
			for(int i=0; i<size; i++) {
				Node temp = q.remove();
				System.out.print(temp.data+ " ");
				if(temp.left != null) {
					q.add(temp.left);
				}
				if(temp.right != null) {
					q.add(temp.right);
				}
			}
		}
	}
	private static void deleteNode(Node root, int data) {
		if(root == null) return;
		if(root.left == null && root.right == null) {
			if(root.data == data) {
				root = null;
				return;
			}
		}
		Node nodeToBeDeleted = null;
		Queue<Node> q = new LinkedList<Node>();
		q.add(root);
		Node temp = null;
		while(!q.isEmpty()) {
			temp = q.remove();
			if(temp.data == data) {
				nodeToBeDeleted = temp;
			}
			if(temp.left != null) {
				q.add(temp.left);
			}
			if(temp.right != null) {
				q.add(temp.right);
			}
		}
		if(nodeToBeDeleted != null) {
			int x = temp.data;
			deleteDeepNode(root, temp);
			nodeToBeDeleted.data = x;
			
		}
	}
	private static void deleteDeepNode(Node root, Node node) {
		Queue<Node> q = new LinkedList<Node>();
		q.add(root);
		Node temp = null;
		while(!q.isEmpty()) {
			temp = q.remove();
			if(temp.data == node.data) {
				temp = null;
				return;
			}
			if(temp.right != null) {
				if(temp.right.data == node.data) {
					temp.right = null;
					return;
				}
				q.add(temp.right);
			}
			if(temp.left != null) {
				if(temp.left.data == node.data) {
					temp.left = null;
					return;
				}
				q.add(temp.left);
			}
		}
	}
	private static void addNodeAfter(Node root, int data, int dataToBeAdd) {
		if(root == null) return;
		if(root.data == data) {
			Node next = root.left;
			Node newNode = new Node(dataToBeAdd);
			root.left = newNode;
			newNode.left = next;
			return;
		}
		addNodeAfter(root.left, data, dataToBeAdd);
		addNodeAfter(root.right, data, dataToBeAdd);
		return;
	}
	private static int diameterOfTree(Node root) {
		if(root == null) return 0;
		int left = diameterOfTree(root.left);
		int right = diameterOfTree(root.right);
		int height = 1 + height(root.left) + height(root.right);
		return Math.max(height, Math.max(left, right));
	}
	private static int height(Node root) {
		if(root == null) return 0;
		return 1 + Math.max(height(root.left), height(root.right));
	}
	private static void printBinarayTree(Node root) {
		inOrderTraversal(root);
	}
	
	private static void inOrderTraversal(Node root) {
		if(root == null) return;
		inOrderTraversal(root.left);
		System.out.print(root.data+ " ");
		inOrderTraversal(root.right);
	}

	static Scanner sc = null;
	private static Node createBinaryTree() {
		Node root = null;
		
		System.out.println("Enter Node Data: ");
		sc = new Scanner(System.in);
		int data = sc.nextInt();
		if(data == -1) return null;
		
		root = new Node(data);
		
		System.out.println("Enter left data for: " +data);
		root.left = createBinaryTree();
		
		System.out.println("Enter right data for: " +data);
		root.right = createBinaryTree();
		
		return root;
	}

}

class Node{
	int data;
	Node left, right;
	Node(int data) {
		this.data = data;
		left = right = null;
	}
	
}
