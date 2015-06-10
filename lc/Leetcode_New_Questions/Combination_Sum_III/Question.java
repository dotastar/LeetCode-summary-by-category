package Combination_Sum_III;

import java.util.ArrayList;
import java.util.List;


public class Question {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Question q = new Question();
		int k = 3;
		int n = 9;
		List<List<Integer>> result = q.combinationSum3(k, n);
		//System.out.print("size: " + result.size());
		for (int i = 0; i < result.size(); i++) {
			ArrayList<Integer> item = (ArrayList<Integer>) result.get(i);
			for (int j = 0; j < item.size(); j++) {
				System.out.print(item.get(j)+ ",");
			}
			System.out.println("");
		}
	}
	
	/**
	 * https://leetcode.com/problems/combination-sum-iii/
	 * Find all possible combinations of k numbers that add up to a number n, 
	 * given that only numbers from 1 to 9 can be used and each combination should be a unique set of numbers.
	 * Ensure that numbers within the set are sorted in ascending order.
	 * 
	 * Example 1:
	 * Input: k = 3, n = 7
	 * Output:
	 * [[1,2,4]]
	 * 
	 * Example 2:
	 * Input: k = 3, n = 9
	 * Output:
	 * [[1,2,6], [1,3,5], [2,3,4]]
	 */
	
    public List<List<Integer>> combinationSum3(int k, int n) {
    	List<List<Integer>> res = new ArrayList<List<Integer>>();
    	List<Integer> item = new ArrayList<Integer>();
    	int cur = 1;
    	int size = k;
    	helper(res, item, size, k, n, cur);
    	return res;
    }
    
    private void helper(List<List<Integer>> res, List<Integer> item, int size, int k, int n, int cur) {
    	if (n < 0 || item.size() > size) {
    		return;
    	}
    	if (n == 0 && item.size() == size) {
    		res.add(new ArrayList<Integer>(item));
    		return;
    	}
    	for (int i = cur; i <= 9; i++) {
    		item.add(i);
    		helper(res, item, size, k - 1, n - i, i + 1); //【注】不是n - cur 不是cur + 1
    		item.remove(item.size() - 1);
    	}
    }


}
