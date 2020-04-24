package com.leetcode.BinaryTree;

import java.util.ArrayList;
import java.util.List;

import com.leetcode.BinaryTree.BTPreorderTraversal.TreeNode;

public class BinaryTreePreorderTraveralMorris {
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
	
	public static  List<Integer> preorderMorris(TreeNode root){
		List<Integer> res = new ArrayList<>();
		TreeNode head = root;
		while( head != null) {
			
			if(head.left == null) {
				res.add(head.data);
				head = head.right;
			}else {
				TreeNode pred = head.left;
				while(pred.right != null && pred.right!= head) {
					pred = pred.right;
				}
				
				if(pred.right == null) {
					res.add(head.data);
					pred.right = head;
					head = head.left;
				}else {
					 pred.right = null;
					 head = head.right;
				}
			}
		}
		return res;
		
		
		
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
		
		for( int x:preorderMorris(root) ) {
			System.out.println(x);
		}
	}

}
