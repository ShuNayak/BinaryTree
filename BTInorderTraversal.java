package com.leetcode.BinaryTree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class BTInorderTraversal {
	 static List<Integer> result = new ArrayList<>();
	public static class TreeNode{
		int val;
		TreeNode left;
		TreeNode right;
		public TreeNode(int val) {
			this.val = val;
			this.left = null;
			this.right = null;
		}
	}
	
	 public static List<Integer> inorderTraversalRecursion(TreeNode root) { 
	        if( root == null) return result;
	        inorderTraversalRecursion(root.left);
	        result.add(root.val);
	        inorderTraversalRecursion(root.right);
	        return result;
	    }
	 
	 public static List<Integer> inorderTraversalIteration(TreeNode root){
		 result.clear();
		 if(root == null) return result;
		 Stack<TreeNode> stk = new Stack<>();
		 
		 while( root != null || !stk.isEmpty()) {
			 if(root != null) {
				 stk.push(root);
				 root = root.left;
			 }else {
				 TreeNode temp = stk.pop();
				 result.add(temp.val);
				 root = temp.right;
				 
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
		
		root.left = two;
		root.right = three;
		two.left = four;
		two.right = five;
		five.right = six;
		root.right = three;
		
		List<Integer> fin = inorderTraversalRecursion(root);
		List<Integer> bin = inorderTraversalIteration(root);
		for(int x:fin) {
			System.out.println(x);
		}
		System.out.println("On iteration below: ");
		for(int x:bin) {
			System.out.println(x);
		}
		 

	}

}
