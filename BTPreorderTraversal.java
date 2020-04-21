package com.leetcode.BinaryTree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class BTPreorderTraversal {
	public static class TreeNode{
		int data;
		TreeNode left;
		TreeNode right;
		public TreeNode(int x) {
			this.data = x;
			this.left = null;
			this.right=null;
		}
	}
	
	public static List<Integer> preOrderTraversalRecursive(TreeNode root){
		List<Integer> res = new ArrayList<>();
		if(root == null) return res;
		
		res.add(root.data);
		res.addAll(preOrderTraversalRecursive(root.left));
		res.addAll(preOrderTraversalRecursive(root.right));
		return res;
		
	}
	
	public static List<Integer> preOrderTraversalIterative(TreeNode root){
		List<Integer> result = new ArrayList<>();
		Stack<TreeNode> s = new Stack<>();
		if(root == null) return result;
		s.push(root);
		
		while(!s.isEmpty()) {
			TreeNode x = s.pop();
			result.add(x.data);
			if(x.right != null) {
				s.push(x.right);
			}
			
			if(x.left != null) {
				s.push(x.left);
			}
			
			
		}
		
		return result;
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		TreeNode root = new TreeNode(1);
		TreeNode two = new TreeNode(2);
		TreeNode three = new TreeNode(3);
		TreeNode four = new TreeNode(4);
		TreeNode five = new TreeNode(5);
		TreeNode six = new TreeNode(6);
		TreeNode seven = new TreeNode(7);
		TreeNode eight = new TreeNode(8);
		TreeNode nine = new TreeNode(9);
		
		
		root.left = two;
		two.right = three;
		three.left = eight;
		three.right= four;
		four.left = five;
		four.right= nine;
		five.left = seven;
		five.right = six;
		
		List<Integer> arr=  preOrderTraversalRecursive(root);
		System.out.println("Recursive");
		for(int x: arr) {
			System.out.print(x);
		}
		System.out.println();
		List<Integer> brr=  preOrderTraversalIterative(root);
		System.out.println("Iterative");
		for(int x: brr) {
			System.out.print(x);
		}

	}

}
