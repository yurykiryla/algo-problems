package com.gmail.yurykiryla.templates;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.Stack;

public class DFS {

	/*
	 * Return true if there is a path from cur to target.
	 */
	public boolean dfsRecursive(Node cur, Node target, Set<Node> visited) {
		if (cur == target) {
			return true;
		}
		for (Node next : cur.next) {
			if (!visited.contains(next)) {
				visited.add(next);
				if (dfsRecursive(next, target, visited)) {
					return true;
				}
			}
		}
		return false;
	}
	
	/*
	 * Return true if there is a path from cur to target.
	 */
	public boolean dfsIterative(Node root, Node target) {
	    Set<Node> visited = new HashSet<>();
	    Stack<Node> stack = new Stack<>();
	    stack.add(root);
	    visited.add(root);
	    while (!stack.isEmpty()) {
	        Node cur = stack.pop();
	        if (cur == target) {
	        	return true;
	        }
	        for (Node next : cur.next) {
	            if (!visited.contains(next)) {
	                visited.add(next);
	                stack.add(next);
	            }
	        }
	    }
	    return false;
	}

	private static class Node {
		List<Node> next;
	}
}
