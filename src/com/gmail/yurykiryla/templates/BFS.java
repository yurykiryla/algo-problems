package com.gmail.yurykiryla.templates;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

public class BFS {
	/**
	 * Return the length of the shortest path between root and target node.
	 */
	int dfsDirected(Node root, Node target) {
		Queue<Node> queue = new LinkedList<>(); // store all nodes which are waiting to be processed
		int step = 0; // number of steps neeeded from root to current node
		// initialize
		queue.offer(root);
		// BFS
		while (!queue.isEmpty()) {
			// iterate the nodes which are already in the queue
			int size = queue.size();
			for (int i = 0; i < size; ++i) {
				Node cur = queue.poll();
				if (cur == target) {
					return step;
				}
				for (Node next : cur.next) {
					queue.offer(next);
				}
			}
			step++;
		}
		return -1; // there is no path from root to target
	}

	/**
	 * Return the length of the shortest path between root and target node.
	 */
	int bfsIndirect(Node root, Node target) {
		Queue<Node> queue = new LinkedList<>(); // store all nodes which are waiting to be processed
		Set<Node> visited = new HashSet<>(); // store all the nodes that we've visited
		int step = 0; // number of steps neeeded from root to current node
		// initialize
		queue.offer(root);
		visited.add(root);
		// BFS
		while (!queue.isEmpty()) {
			// iterate the nodes which are already in the queue
			int size = queue.size();
			for (int i = 0; i < size; ++i) {
				Node cur = queue.poll();
				if (cur == target) {
					return step;
				}
				for (Node next : cur.next) {
					if (!visited.contains(next)) {
						queue.offer(next);
						visited.add(next);
					}
				}
			}
			step++;
		}
		return -1; // there is no path from root to target
	}

	private static class Node {
		List<Node> next;
	}
}
