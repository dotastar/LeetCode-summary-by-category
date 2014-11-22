package Climbing_Stairs;

public class Question {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(climbStairs(33));

	}
	
	//naive recursive way
	//will NOT pass leetcodde because of "Time Limit Exceeded"
	/*
	 * for last climb you have and only have 2 way: 1 step or 2 step to finish;
	 * so to finish n stairs, we can group all methods into two groups
	 * group1 is to finish last climb by 1 step
	 * group2 is to finish last climb by 2 steps
	 * add them up we will get all methods;
	 * then we split the big problem into two small problems.
	 * i.e. 1. how we can leave 1 step before finish all n stairs
	 * 		2. how we can leave 2 step before finish all n stairs
	 * there comes the recursion
	 */
	public static int climbStairs(int n) {
		if (n<=0){
			return 0;
		}
		if(n==1){
			return 1;
		}
		
		if(n==2){
			return 2;
		}
		return climbStairs(n-1)+climbStairs(n-2);         
    }

	
	//DP 1D
	//http://blog.csdn.net/linhuanmars/article/details/23976963
	//等同于Fibonacci
	public static int climbStairsDP(int n){
		if (n <= 1) {
			return 1;
		}
		if (n == 2) {
			return 2;
		}
		int pre = 1; //上一个值
		int cur = 2; //当前值
		int next; //下一个值
		for (int i = 3; i <= n; i++) {
			next = cur + pre; //更新next；
			pre = cur; //要先更新pre
			cur = next;//然后更新 cur，因为上一步要用到cur的值来更新pre，如果先更新cur，则给pre的值就是错的。
		}
		return cur;
	}

}
