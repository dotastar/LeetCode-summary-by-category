package Unique_Paths_II;


public class Question {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] obstacleGrid = {
				/*{0,1,0,0},
				{0,0,0,0},
				{0,1,0,0},
				{0,0,0,0},*/
				{1},
				{0}
		};
		//System.out.println(uniquePathsWithObstacles(obstacleGrid));

	}
	
	/**
	 * https://oj.leetcode.com/problems/unique-paths-ii/
	 * Follow up for "Unique Paths": Now consider if some obstacles are added to
	 * the grids. How many unique paths would there be? An obstacle and empty
	 * space is marked as 1 and 0 respectively in the grid. 
	 * For example, 
	 * There is one obstacle in the middle of a 3x3 grid as illustrated below.
	 * 
	 * [ 
	 *  [0,0,0], 
	 *  [0,1,0], 
	 *  [0,0,0] 
	 * ] 
	 * 
	 * The total number of unique paths is 2.
	 * Note: m and n will be at most 100.
	 */
	//http://answer.ninechapter.com/solutions/unique-paths-ii/
	//看【注】
	//1.state: result[i][j]表示从[0][0]到[i][j],一共有多少种不同path
	//2.function:      if obstacleGrid[i][j]!=1，则result[i][j] = result[i - 1][j] + result[i][j - 1];
	//			  else if obstacleGrid[i][j]==1，则result[i][j] = 0;(因为没有一种办法可以走到[i][j])
	//3.initialize: result[0][j] = 1 (until obstacleGrid[0][j] == 1)
	//				result[i][0] = 1 (until obstacleGrid[i][0] == 1)
	//4.answer: result[m-1][n-1]
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
    	if (obstacleGrid == null || obstacleGrid.length == 0 || obstacleGrid[0].length == 0) {
            return 0;
        }
        int m = obstacleGrid.length; // row
        int n = obstacleGrid[0].length;
        int[][] result = new int[m][n];
        
        //处理第一行。如果遇到1，则其右面的位置都无法到达，跳出循环，让它们的值保持为0；
		for (int j = 0; j < n; j++) {
			if (obstacleGrid[0][j] != 1) {
				result[0][j] = 1;
			} else {
				break;
			}
        }
        //同理处理第一列
		//【注】i必须从0开始，不能从1开始；反例 
		//Input:	[[1],[0]]（两行一列）
		//Output:	1
		//Expected:	0
        for (int i = 0; i < m; i++) { 
            if (obstacleGrid[i][0] != 1) {
                result[i][0] = 1;
            } else {
                break;
            }
        }
        
		for (int i = 1; i < m; i++) {
			for (int j = 1; j < n; j++) {
				result[i][j] = obstacleGrid[i][j] != 1 ? result[i - 1][j] + result[i][j - 1] : 0;
			}
		}
        return result[m - 1][n - 1];    
    }
    
	//DP, matrix, O(n) space
	//http://blog.csdn.net/linhuanmars/article/details/22135231
    public int uniquePathsWithObstaclesBigO_n_Space(int[][] obstacleGrid) {
    	if (obstacleGrid == null || obstacleGrid.length == 0 || obstacleGrid[0].length == 0) {
    		return 0;
    	}
        int m = obstacleGrid.length; // row
        int n = obstacleGrid[0].length;
		int[] result = new int[n]; // result[j]表示从[0][0]位置，到当前第i行，第j列有多少种走法
		result[0] = 1;
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) { // 【注】此处j不能从1开始，因为如果某obstacleGrid[i][0]为1，则result[0]要变为0，所以j=0的情况必须考虑
				if (obstacleGrid[i][j] == 1) {
					result[j] = 0;
				} else {
					if (j > 0) { // 【注】因为j == 0时， j - 1数组会index越界
						result[j] += result[j - 1];
					}
				}
			}
		}
		return result[n - 1];
	}
	
}
