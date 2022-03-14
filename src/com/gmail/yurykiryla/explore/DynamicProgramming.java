package com.gmail.yurykiryla.explore;

public class DynamicProgramming {

	public static void main(String[] args) {
		DynamicProgramming dp = new DynamicProgramming();
		int[] nums = { 1, 2, 3 };
		int[] multipliers = { 3, 2, 1 };
		int maxScore = dp.maximumScore(nums, multipliers);
		System.out.println(maxScore);
	}

	public int maximumScore(int[] nums, int[] multipliers) {
		int[][] cache = new int[multipliers.length][multipliers.length];
		return maxScore(nums, multipliers, 0, multipliers.length - 1, 0, cache);
	}

	private int maxScore(int[] nums, int[] multipliers, int start, int end, int i, int[][] cache) {

		if (i == multipliers.length) {
			return 0;
		}
		int m = multipliers[i];

		if (cache[i][start] == 0) {
			int left = maxScore(nums, multipliers, start + 1, end, i + 1, cache) + m * nums[start];
			int right = maxScore(nums, multipliers, start, end - 1, i + 1, cache) + m * nums[end];
			cache[i][start] = Math.max(left, right);
		}

		return cache[i][start];
	}
}
