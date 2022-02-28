package com.gmail.yurykiryla.templates;

import java.util.PriorityQueue;

public class MinCostToConnectAllPointsKruskalsAlgorithm {
	// Kruskal's Algorithm
	public int minCostConnectPoints(int[][] points) {
		if (points == null || points.length == 0) {
			return 0;
		}
		int size = points.length;
		PriorityQueue<Edge> pq = new PriorityQueue<>((x, y) -> x.cost - y.cost);
		UnionFind uf = new UnionFind(size);

		for (int i = 0; i < size; i++) {
			int[] coordinate1 = points[i];
			for (int j = i + 1; j < size; j++) {
				int[] coordinate2 = points[j];
				// Calculate the distance between two coordinates.
				int cost = Math.abs(coordinate1[0] - coordinate2[0]) + Math.abs(coordinate1[1] - coordinate2[1]);
				Edge edge = new Edge(i, j, cost);
				pq.add(edge);
			}
		}

		int result = 0;
		int count = size - 1;
		while (!pq.isEmpty() && count > 0) {
			Edge edge = pq.poll();
			if (!uf.connected(edge.point1, edge.point2)) {
				uf.union(edge.point1, edge.point2);
				result += edge.cost;
				count--;
			}
		}
		return result;
	}

	private static class Edge {
		int point1;
		int point2;
		int cost;

		Edge(int point1, int point2, int cost) {
			this.point1 = point1;
			this.point2 = point2;
			this.cost = cost;
		}
	}
}
