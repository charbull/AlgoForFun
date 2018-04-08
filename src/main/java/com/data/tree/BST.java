package com.data.tree;

import java.util.LinkedList;

public class BST {

	public static class Node{
		int data;
		public Node left;
		public Node right;

		public Node(int data) {
			this.data = data;
		}

	}

	public static void main(String[] args) {

		Node n3 = new Node(4);
		Node n2 = new Node(2);
		Node n1 = new Node(1);
		Node n4 = new Node(5);
		Node n5 = new Node(3);

		n2.left = n1;
		n2.right = n5;

		n3.right = n4;
		n3.left = n2;

		System.out.println(valideBST_recursive(n3)==true);
		System.out.println(valideBST_iterative(n3)==true);
		
		n3 = new Node(3);
		n2 = new Node(2);
		n1 = new Node(1);
		n4 = new Node(4);
		n5 = new Node(5);

		n2.left = n1;
		n2.right = n5;

		n3.right = n4;
		n3.left = n2;

		System.out.println(valideBST_recursive(n3)==false);
		System.out.println(valideBST_iterative(n3)==false);
		
	}

	public static boolean valideBST_recursive(Node root)
	{
		return valideBST_recursive(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
	}
	
	public static boolean valideBST_recursive(Node root, int min, int max)
	{
		if(root == null ) return true;
		
		if(root.data <= min || root.data > max) return false;
		
		return valideBST_recursive(root.left, min, root.data) && valideBST_recursive(root.right, root.data, max);
	}
	
	public static boolean valideBST_iterative(Node root)
	{
		if(root == null) return false;

		LinkedList<Node> stack = new LinkedList<Node>();
		stack.push(root);
		while(!stack.isEmpty())
		{
			Node current = stack.pop();
			int parentPivot = current.data;
			Node left = current.left;
			while(left != null && left.data <= parentPivot) {
				if(left.right != null) stack.push(left.right);
				left = left.left;
			}
			if(left != null && left.data > parentPivot) return false;
			
			Node right = current.right;
			while(right != null && right.data > parentPivot) {
				if(right.left != null) stack.push(right.left);
				right = right.right;
			}
			if(right != null && right.data <= parentPivot) return false;
		}
		return true;		
	}
}
