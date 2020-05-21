package com.leetcode.BinaryTree;

import java.util.ArrayList;
import java.util.List;

import com.leetcode.BinaryTree.BTInorderTraversal.TreeNode;

public class BTInorderMorrisTraversal {
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
	
	public static List<Integer> BTInorderMorris(TreeNode root){
		if( root == null) return result;
		TreeNode head = root;
		while(head != null) {
			if(head.left == null) {
				result.add(head.val);
				head = head.right;
			}
			else {
				TreeNode pred = head.left;
				while(pred.right != null && pred.right != head) {
					pred = pred.right;
				}
				
				if(pred.right == null) {
					pred.right = head;
					head = head.left;
				}else {
					pred.right = null;
					result.add(head.val);
					head = head.right;
				}
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
		
		List<Integer> fin = BTInorderMorris(root);
		for( int x: fin) {
			System.out.println(x);
		}

	}

}
