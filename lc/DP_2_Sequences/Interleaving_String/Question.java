package Interleaving_String;

public class Question {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Question q = new Question();
/*		String s1 = "aabcc";
		String s2 = "dbbca";
		String s3 = "aadbbcbcac";*/
		String s1 = "abc";
		String s2 = "def";
		String s3 = "abcdef";
		//String s3 = "aadbbbaccc";
		System.out.println(q.isInterleave(s1, s2, s3));
	}

	/**
	 * https://oj.leetcode.com/problems/interleaving-string/
	 * Given s1, s2, s3, find whether s3 is formed by the interleaving of s1 and s2.
	 * 
	 * For example, Given: s1 = "aabcc", s2 = "dbbca",
	 * When s3 = "aadbbcbcac", return true. 
	 * When s3 = "aadbbbaccc", return false.
	 */
	
	//1.state: result[i][j]代表： 在s1的前i个字符配上s2的前j个字符，是否可以交错表达出s3的前i+j个字符。
	//2.function: result[i][j] = (s1[i] == s3[i+j] && result[i-1][j] ) OR (s2[j] == s3[i+j] && result[i][j-1]) 
	//（即此时s1和s2是等价的，以s1为例：只要s1[i]==s3[i+j]，并且s1的前i-1和s2的前j个可以表达出s3的前i+j-1个，即result[i-1][j]，result[i][j]则为真。s2类似可推）
	//3.initialize: result[0][0] = true;
	//				result[0][j] = result[i][j - 1] && s2[j]==s3[j]; 第一行（s1为空，所以只能靠s2来构造s3。）
	//				result[i][0] = result[i - 1][0] && s1[i]==s3[i]; 第一列（类似第一行）
	//4.answer: result[A.length][B.length];
	//【注】result[][]和A，B有位差
	public boolean isInterleave(String s1, String s2, String s3) {
		if (s1 == null || s1.length() == 0) {
			return s2.equals(s3);
		}
		if (s2 == null || s2.length() == 0) {
			return s1.equals(s3);
		}
		int len1 = s1.length();
		int len2 = s2.length();
		int len3 = s3.length();
		if (len1 + len2 != len3) {
			return false;
		}
		boolean[][] result = new boolean[len1 + 1][len2 + 1];
		for (int i = 0; i <= len1; i++) {
			for (int j = 0; j <= len2; j++) {
				if (i == 0 && j == 0) {
					result[i][j] = true;
				} else if (i == 0) { //初始化第一行.有位差
					result[0][j] = result[0][j - 1] && s2.charAt(j - 1) == s3.charAt(j - 1); 
				} else if (j == 0) { //初始化第一列.有位差
					result[i][0] = result[i - 1][j] && s1.charAt(i - 1) == s3.charAt(i - 1); 
				} else { // 其余位置。有位差
					result[i][j] = s1.charAt(i - 1) == s3.charAt(i + j - 1) && result[i - 1][j] || s2.charAt(j - 1) == s3.charAt(i + j - 1) && result[i][j - 1];
				}
			}
		}
		return result[len1][len2];
	}
	
	
	
	//http://blog.csdn.net/linhuanmars/article/details/24683159
	//2d dp
	//best way to deal with index, is to draw a matrix table!
    public boolean isInterleave2(String s1, String s2, String s3) {
        if(s1.length() + s2.length() != s3.length()){
        	return false;
        }
        int s1Len = s1.length();
        int s2Len = s2.length();
        boolean[][] result = new boolean[s1Len+1][s2Len+1]; 
        result[0][0] = true;
        for(int i=0; i<s2Len; i++){
        	result[0][i+1] = result[0][i] && s2.charAt(i)==s3.charAt(i);
        }
        for(int i=0; i<s1Len; i++){
        	result[i+1][0] =  result[i][0] && s1.charAt(i)==s3.charAt(i); 
        }
        for(int i=0; i<s1Len; i++){
        	for(int j=0; j<s2Len;j++){
        		//make some simple example like s1 = {a,b,c}; s2 = {d,e}, s3 = {a,b,c,d,e} 
        		//draw the matrix and e.g when i=1 j=2, to deduct below formula
        		result[i+1][j+1] = result[i+1][j]&&s2.charAt(j)==s3.charAt(i+j+1) || result[i][j+1] && s1.charAt(i)==s3.charAt(i+j+1);
        	}
        }
        return result[s1Len][s2Len];
    }

}
