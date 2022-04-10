package com.gmail.yurykiryla.explore;

import java.util.ArrayDeque;
import java.util.HashSet;
import java.util.Queue;
import java.util.Random;
import java.util.Set;

public class SubarrayProblems {

	private final static int MOD = (int) (1e9 + 7);
	private final static Random RANDOM = new Random();

	public static void main(String[] args) {
		int[] arr = new int[5000];
		for (int i = 0; i < arr.length; i++) {
			arr[i] = RANDOM.nextInt(1, (int) (1e5 + 1));
		}

		System.out.println("Array prepared");

		SubarrayProblems subarrayProblems = new SubarrayProblems();

		// sum of mins
		long start = System.currentTimeMillis();
		int result = subarrayProblems.sumOfMins(arr);
		long time = System.currentTimeMillis() - start;
		System.out.println("Sum of Mins: " + result + ", time: " + time);

		start = System.currentTimeMillis();
		result = subarrayProblems.sumOfMins_dp(arr);
		time = System.currentTimeMillis() - start;
		System.out.println("Sum of Mins DP: " + result + ", time: " + time);

		start = System.currentTimeMillis();
		result = subarrayProblems.sumOfMins_dp_state(arr);
		time = System.currentTimeMillis() - start;
		System.out.println("Sum of Mins DP State Machine: " + result + ", time: " + time);
	}

	public int sumOfMins(int[] arr) {
		long result = 0;
		for (int i = 0; i < arr.length; i++) {
			for (int j = i; j < arr.length; j++) {
				int min = Integer.MAX_VALUE;
				for (int k = i; k <= j; k++) {
					min = Math.min(min, arr[k]);
				}
				result += min;
				result %= MOD;
			}
		}
		return (int) result;
	}

	public int sumOfMins_dp(int[] arr) {
		long result = 0;
		int[] dp = new int[arr.length];
		for (int i = 0; i < arr.length; i++) {
			for (int j = i; j < arr.length; j++) {
				if (i == j) {
					dp[i] = arr[i];
				} else {
					dp[j] = Math.min(dp[j - 1], arr[j]);
				}
				result += dp[j];
				result %= MOD;
			}
		}
		return (int) result;
	}

	public int sumOfMins_dp_state(int[] arr) {
		long result = 0;
		int min;
		for (int i = 0; i < arr.length; i++) {
			min = arr[i];
			result += min;
			result %= MOD;
			for (int j = i + 1; j < arr.length; j++) {
				min = Math.min(min, arr[j]);
				result += min;
				result %= MOD;
			}
		}
		return (int) result;
	}
	
	public int sumOfMins_divide(int[] arr) {
		long result = 0;
		
		Queue<int[]> queue = new ArrayDeque<>();
		queue.add(new int[] {0, arr.length - 1});
		while (!queue.isEmpty()) {
			int[] current = queue.poll();
			int start = current[0];
			int end = current[1];
			if (start == end) {
				result += arr[start];
				result %= MOD;
			} else if (start < end) {
				int min = arr[start];
				int index = start;
				for (int i = start + 1; i <= end; i++) {
					if (arr[i] < min) {
						
					}
				}
			}
		}
		
		
		
		int min;
		for (int i = 0; i < arr.length; i++) {
			min = arr[i];
			result += min;
			result %= MOD;
			for (int j = i + 1; j < arr.length; j++) {
				min = Math.min(min, arr[j]);
				result += min;
				result %= MOD;
			}
		}
		return (int) result;
	}

	public int sumOfMax(int[] arr) {
		return 0;
	}

	public int sumOfDiff(int arr[]) {
		return 0;
	}

	public int sumOfSum(int[] arr) {
		return 0;
	}

	public int sumOfMinTimesSum(int[] arr) {
		return 0;
	}
}
