package com.infy.ds.binarytree;

public class DiameterOfBinaryTree {

	public static void main(String[] args) {
		BinaryTree tree = new BinaryTree();
		tree.root = new Node(1);
		tree.root.left = new Node(2);
        tree.root.right = new Node(3);
        tree.root.left.left = new Node(4);
        tree.root.left.right = new Node(5);
 
        // Function Call
        System.out.println(
            "The diameter of given binary tree is : "
            + tree.diameter());

	}
	
	static class Node{
		int data;
		Node left, right;
		Node(int data) {
			this.data = data;
			left = right = null;
		}
	}
	static class BinaryTree {
		Node root;
		public BinaryTree(int data) {
			this.root.data = data;
		}
		public BinaryTree() {
			this.root = null;
		}
		public int diameter() {
			return diameter(root);
		}
		private int diameter(Node node) {
			if(node == null) return 0;
			
			int dl = diameter(node.left);
			int dr = diameter(node.right);
			int height = 1 + height(node.left) + height(node.right);
			
			return Math.max(height, Math.max(dl, dr));
			
		}
		private int height(Node node) {
			if(node == null) return 0;
			return 1 + Math.max(height(node.left), height(node.right));
		}
		
		
	}
	
	

}

