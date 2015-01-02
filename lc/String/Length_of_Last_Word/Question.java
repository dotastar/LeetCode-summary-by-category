package Length_of_Last_Word;

public class Question {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Question q = new Question();
		String s = "    hel      ";
		System.out.println(q.lengthOfLastWord(s));

	}
	
	/**
	 * https://oj.leetcode.com/problems/length-of-last-word/
	 * Given a string s consists of upper/lower-case alphabets and empty space
	 * characters ' ', return the length of last word in the string.
	 * If the last word does not exist, return 0.
	 * Note: A word is defined as a character sequence consists of non-space
	 * characters only.
	 * 
	 * For example, 
	 * Given s = "Hello World", 
	 * return 5.
	 */
	
	//http://blog.csdn.net/linhuanmars/article/details/21858067
    public int lengthOfLastWord(String s) {
		if (s == null || s.length() == 0) {
			return 0;
		}
		int end = s.length() - 1; // 标记last word的最末位（最右边一个非空格的index）
		while (end >= 0 && s.charAt(end) == ' ') { // 排除掉末尾的空格
			end--;
		}
		int start = end;
		while (start >= 0 && s.charAt(start) != ' ') { // 标记last word的最初位左边的1位（略过所有非空格，知道找到一个空格）
			start--;
		}
		return end - start; // 【注】防止出错的最好办法就是画图举例  
    }

}