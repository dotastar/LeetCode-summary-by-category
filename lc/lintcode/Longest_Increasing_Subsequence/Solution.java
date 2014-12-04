package Longest_Increasing_Subsequence;

public class Solution {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = {1,1,1,1,1,1};
		System.out.println(longestIncreasingSubsequence(nums));
	}

	/**
	 * http://lintcode.com/en/problem/longest-increasing-subsequence/
	 * Given a sequence of integers, find the longest increasing subsequence
	 * (LIS).
	 * You code should return the length of the LIS.
	 * 
	 * Example 
	 * For [5, 4, 1, 2, 3], the LIS is [1, 2, 3], return 3
	 * For [4, 2, 4, 5, 3, 7], the LIS is [4, 4, 5, 7], return 4
	 * 
	 * Challenge Expand Time complexity O(n^2) or O(nlogn)
	 */
	//http://www.ninechapter.com/solutions/longest-increasing-subsequence/
	//1.state: result[i]代表直到前i个字符，以i结尾的LIS的长度
	//2.function: 则result[i] = max(result[j]+1; 前提是j<i && a[j] <= a[i])
	//3.initialize: result[0] = 0; 当i>0, result[i] = 1（最差情况都是倒序的，则当前i的LIS为1）
	//4.answer: max(result[0], result[1]...result[nums.length];
	//O(n^2)时间复杂度
	//【注】nums[]和res[]有一个位差 
	public static int longestIncreasingSubsequence(int[] nums) {
		if (nums == null || nums.length == 0) {
			return 0;
		}
		int max = 0;
		int[] result = new int[nums.length + 1];
		result[0] = 0;
		for (int i = 1; i <= nums.length; i++) {
			result[i] = 1;
			for (int j = 1; j < i; j++) {
				// 找到一个比i数值小的位置
				if (nums[j - 1] <= nums[i - 1]) { // nums[]和res[]有一个位差
					result[i] = Math.max(result[i], result[j] + 1);
				}
			}
			max = Math.max(max, result[i]);
		}
		return max;
	}
}