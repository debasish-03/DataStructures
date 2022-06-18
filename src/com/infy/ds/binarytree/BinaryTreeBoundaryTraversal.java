package com.infy.ds.binarytree;

import java.util.Scanner;

public class BinaryTreeBoundaryTraversal {

	public static void main(String[] args) {
		Node root = createBinaryTree();
		printBinaryTree(root);
		
		System.out.print("\nBoundary Traversal of Binary Tree:\n");
		traverseBoundaryOfBinaryTree(root);
	}
	private static void traverseBoundaryOfBinaryTree(Node root) {
		if(root == null) return;
		System.out.print(root.data+ " ");
		traverseLeftBoundary(root.left);
		traverseLeaveNode(root.left);
		traverseLeaveNode(root.right);
		traverseRightBoundary(root.right);
	}
	private static void traverseRightBoundary(Node root) {
		if(root == null) return;
		if(root.right != null) {
			traverseRightBoundary(root.right);
			System.out.print(root.data + " ");
		} else if(root.left != null) {
			traverseRightBoundary(root.left);
			System.out.print(root.data + " ");
		}
		
	}
	private static void traverseLeaveNode(Node root) {
		if(root == null) return;
		traverseLeaveNode(root.left);
		if(root.left == null && root.right == null) {
			System.out.print(root.data+ " ");
		}
		traverseLeaveNode(root.right);
	}
	private static void traverseLeftBoundary(Node root) {
		if(root == null) return;
		if(root.left != null) {
			System.out.print(root.data + " ");
			traverseLeftBoundary(root.left);
		} else if(root.right != null) {
			System.out.print(root.data + " ");
			traverseLeftBoundary(root.right);
		}
	}
	private static void printBinaryTree(Node root) {
		inOrder(root);
	}
	private static void inOrder(Node root) {
		if(root == null) return;
		inOrder(root.left);
		System.out.print(root.data+ " ");
		inOrder(root.right);
	}
	static Scanner sc = null;
	private static Node createBinaryTree() {
		Node root  = null;
		
		sc = new Scanner(System.in);
		System.out.println("Enter data: ");
		int data = sc.nextInt();
		
		if(data == -1) return null;
		root = new Node(data);
		
		System.out.println("Enter data for left node: " +data);
		root.left = createBinaryTree();
		
		System.out.println("Enter data for right node: " +data);
		root.right = createBinaryTree();
		
		return root;
	}
	static class Node {
		int data;
		Node left;
		Node right;
		Node(int data) {
			this.data = data;
			left = null;
			right = null;
		}
	}

}
