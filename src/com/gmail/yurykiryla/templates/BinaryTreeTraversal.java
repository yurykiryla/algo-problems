package com.gmail.yurykiryla.templates;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

public class BinaryTreeTraversal {
	public List<Integer> preorderTraversal(TreeNode root) {
		List<Integer> answer = new ArrayList<>();
		preorderTraversal(root, answer);
		return answer;
	}

	private void preorderTraversal(TreeNode root, List<Integer> answer) {
		if (root == null) {
			return;
		}
		answer.add(root.val); // visit the root
		preorderTraversal(root.left, answer); // traverse left subtree
		preorderTraversal(root.right, answer); // traverse right subtree
	}

	public List<Integer> inorderTraversal(TreeNode root) {
		List<Integer> answer = new ArrayList<>();
		inorderTraversal(root, answer);
		return answer;
	}

	private void inorderTraversal(TreeNode root, List<Integer> answer) {
		if (root == null) {
			return;
		}
		inorderTraversal(root.left, answer); // traverse left subtree
		answer.add(root.val); // visit the root
		inorderTraversal(root.right, answer); // traverse right subtree
	}

	public List<Integer> postorderTraversal(TreeNode root) {
		List<Integer> answer = new ArrayList<>();
		postorderTraversal(root, answer);
		return answer;
	}

	private void postorderTraversal(TreeNode root, List<Integer> answer) {
		if (root == null) {
			return;
		}
		postorderTraversal(root.left, answer); // traverse left subtree
		postorderTraversal(root.right, answer); // traverse right subtree
		answer.add(root.val); // visit the root
	}

	public List<Integer> preorderTraversalIterative(TreeNode root) {
		List<Integer> answer = new ArrayList<>();
		Stack<TreeNode> s = new Stack<TreeNode>();
		if (root != null) {
			s.push(root);
		}
		TreeNode cur;
		while (!s.empty()) {
			cur = s.pop();
			answer.add(cur.val); // visit the root
			if (cur.right != null) {
				s.push(cur.right); // push right child to stack if it is not null
			}
			if (cur.left != null) {
				s.push(cur.left); // push left child to stack if it is not null
			}
		}
		return answer;
	}

	public List<List<Integer>> levelOrder(TreeNode root) {
		List<List<Integer>> ans = new ArrayList<>();
		Queue<TreeNode> q = new LinkedList<>();
		if (root != null) {
			q.offer(root);
		}
		TreeNode cur;
		while (!q.isEmpty()) {
			int size = q.size();
			List<Integer> subAns = new LinkedList<Integer>();
			for (int i = 0; i < size; ++i) { // traverse nodes in the same level
				cur = q.poll();
				subAns.add(cur.val); // visit the root
				if (cur.left != null) {
					q.offer(cur.left); // push left child to queue if it is not null
				}
				if (cur.right != null) {
					q.offer(cur.right); // push right child to queue if it is not null
				}
			}
			ans.add(subAns);
		}
		return ans;
	}

	private static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode() {
		}

		TreeNode(int val) {
			this.val = val;
		}

		TreeNode(int val, TreeNode left, TreeNode right) {
			this.val = val;
			this.left = left;
			this.right = right;
		}
	}
}
