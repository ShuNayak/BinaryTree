package com.leetcode.BinaryTree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import com.leetcode.BinaryTree.BTInorderTraversal.TreeNode;

public class BTPostOrderTraversal {
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
	 public static List<Integer> postorderTraversalIterative(TreeNode root) {
	        List<Integer> result = new ArrayList<>();
	        Stack<TreeNode> stk = new Stack<>();
	        if( root == null) return result;
	        TreeNode current = root;
	        while(true){
	            while(current != null ){
	                stk.push(current);
	                stk.push(current);
	                current = current.left;
	            }
	            
	            if(stk.isEmpty()) break;
	            current = stk.pop();
	            
	            if(!stk.isEmpty() && stk.peek()==current)current = current.right;
	            else{
	                result.add(current.val);
	                current = null;
	            }
	        }
	        return result;
	    }
	static List<Integer> resulty = new ArrayList<>();
	 public static List<Integer> postorderTraversalRecursion(TreeNode root){
		
		 if ( root == null) return resulty;
		 postorderTraversalRecursion(root.left);
		 postorderTraversalRecursion(root.right);
		 resulty.add(root.val);
		 return resulty;
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
		
		List<Integer> fin = postorderTraversalRecursion(root);
		List<Integer> bin = postorderTraversalIterative(root);
		
		for( int x: fin) {
			System.out.println(x);
		}
System.out.println("Iteration below: ");
		for(int y: bin) {
			System.out.println(y);
		}
	}

}
