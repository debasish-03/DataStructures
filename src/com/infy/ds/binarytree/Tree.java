package com.infy.ds.binarytree;

import java.util.Scanner;

public class Tree {

	public static void main(String[] args) {
		sc = new Scanner(System.in);
		Node root = createTree();
		inOrder(root);

	}
	private static void inOrder(Node root) {
		if(root == null) return;
		
		inOrder(root.left);
		System.out.print(root.data+ " ");
		inOrder(root.right);
	}
	static Scanner sc= null;
	static Node createTree() {
		Node root = null;
		System.out.println("Enter data:");
		int data = sc.nextInt();
		
		if(data == -1) return null;
		root = new Tree().new Node(data);
		
		System.out.println("Enter left data for: "+data);
		root.left = createTree();
		
		System.out.println("Enter right data for: "+data);
		root.right = createTree();
		return root;
	}
	class Node{
		int data;
		Node left, right;
		Node(int data) {
			this.data = data;
		}
	}

}

