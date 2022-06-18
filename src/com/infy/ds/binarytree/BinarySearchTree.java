package com.infy.ds.binarytree;

import java.util.Scanner;

public class BinarySearchTree {

	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		BinarySearchTree bst = new BinarySearchTree();
		
		System.out.println("Enter a number: ");
		int num = scan.nextInt();
		System.out.println("Enter "+num+"number: ");
		int n;
		for(int i=0; i<num; i++) {
			n = scan.nextInt();
			bst.insertData(n);
			
		}
		System.out.println(" Enter the number you want to search :");
		int  numberToBeSearched = scan.nextInt();
		if(bst.searchTree(numberToBeSearched) != null) {
			System.out.println("Number found");
		} else {
			System.out.println("Number not found");
		}
		System.out.println("Data insertion completed");
		System.out.println("Inorder");
		bst.inOrderTraversal();
		System.out.println("\nPreOder\n");
		bst.preOrderTraverse();
		System.out.println("\nPostOder\n");
		bst.postOrderTraversal();
	}
	
	
	public class TreeNode{
		int data;
		TreeNode left;
		TreeNode right;
		TreeNode(int data) {
			this.data = data;
			this.left = this.right = null;
		}
	}
	
	TreeNode root;
	BinarySearchTree() {
		root = null;
	}
	
	
	public TreeNode insert(TreeNode root, int dataToBeInserted) {
		
		if(root == null) {
			root = new TreeNode(dataToBeInserted);
			return root;
		}
		
		if(root.data > dataToBeInserted) {
			root.left = insert(root.left, dataToBeInserted);
		} else if(root.data < dataToBeInserted){
			root.right = insert(root.right, dataToBeInserted);
		}
		return root;
	}
	
	public TreeNode search(TreeNode root, int dataToBeSearched) {
		
		if(root == null || root.data == dataToBeSearched)
		return root;
		
		if(root.data > dataToBeSearched)
			return search(root.left, dataToBeSearched);
		
		return search(root.right, dataToBeSearched);
	}
	
	public void inOrder(TreeNode root) {
		if(root == null)
			return;
		inOrder(root.left);
		System.out.print(root.data+" ");
		inOrder(root.right);
	}
	
	public void preOrder(TreeNode root) {
		if(root == null)
			return;
		System.out.print(root.data+" ");
		preOrder(root.left);
		preOrder(root.right);
	}
	public void postOrder(TreeNode root) {
		if(root == null)
			return;
		
		postOrder(root.left);
		postOrder(root.right);
		System.out.print(root.data+" ");
	}
	
	public void preOrderTraverse() {
		preOrder(root);
	}
	public void insertData(int data) {
		root = insert(root, data);
	}
	public void inOrderTraversal() {
		inOrder(root);
	}
	public void postOrderTraversal() {
		postOrder(root);
	}
	public TreeNode searchTree(int dataToBeSearched) {
		return search(root, dataToBeSearched);
	}
}
