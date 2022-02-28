package com.gmail.yurykiryla.templates;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;
import java.util.List;

public class FindIfPathExistsInGraphDFS {
	public boolean validPath(int n, int[][] edges, int start, int end) {
		List<List<Integer>> adjacency_list = new ArrayList<>();
		for (int i = 0; i < n; i++) {
			adjacency_list.add(new ArrayList<>());
		}

		for (int[] edge : edges) {
			adjacency_list.get(edge[0]).add(edge[1]);
			adjacency_list.get(edge[1]).add(edge[0]);
		}

		Deque<Integer> stack = new ArrayDeque<>();
		stack.push(start);
		boolean seen[] = new boolean[n];
		Arrays.fill(seen, false);

		while (!stack.isEmpty()) {
			// Get the current node.
			int node = stack.pop();

			// Check if we have reached the target node.
			if (node == end) {
				return true;
			}

			// Check if we've already visited this node.
			if (seen[node]) {
				continue;
			}
			seen[node] = true;

			// Add all neighbors to the stack.
			for (int neighbor : adjacency_list.get(node)) {
				stack.push(neighbor);
			}
		}

		return false;
	}
}
