package Letter_Combinations_of_a_Phone_Number;

import java.util.ArrayList;
import java.util.HashMap;

public class Question {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Question q = new Question();
		ArrayList<String> result = q.letterCombinations("23");
		for (int i = 0; i < result.size(); i++) {
			System.out.print(result.get(i) + ",");
		}
	}

	/**
	 * https://oj.leetcode.com/problems/letter-combinations-of-a-phone-number/
	 * Given a digit string, return all possible letter combinations that the
	 * number could represent.
	 * A mapping of digit to letters (just like on the telephone buttons) is
	 * given below.
	 * 
	 * http://upload.wikimedia.org/wikipedia/commons/thumb/7/73/Telephone-keypad2.svg/200px-Telephone-keypad2.svg.png
	 * 
	 * Input:Digit string "23" 
	 * Output: ["ad", "ae", "af", "bd", "be", "bf","cd", "ce", "cf"]. 
	 * 
	 * Note: Although the above answer is in lexicographical
	 * order, your answer could be in any order you want.
	 */
	//DFS
	//http://blog.csdn.net/linhuanmars/article/details/19743197
	public ArrayList<String> letterCombinations(String digits) {
		ArrayList<String> result = new ArrayList<String>();
		if (digits == null || digits.length() == 0) {
			return result;
		}
		HashMap<Character, String> map = new HashMap<Character, String>();
		map.put('0', ""); // 0和1 对应的为空字符数组
		map.put('1', "");
		map.put('2', "abc");
		map.put('3', "def");
		map.put('4', "ghi");
		map.put('5', "jkl");
		map.put('6', "mno");
		map.put('7', "pqrs");
		map.put('8', "tuv");
		map.put('9', "wxyz");
		StringBuilder item = new StringBuilder();
		helper(result, item, map, digits);
		return result;
    }
	
	private void helper(ArrayList<String> result, StringBuilder item, HashMap<Character, String> map, String digits) {
		if (item.length() == digits.length()) {
			result.add(item.toString());
			return;
		}
		int pos = item.length(); // 本轮要处理的digit中的位置
		String letters = map.get(digits.charAt(pos)); // 该位置所有可能的字符
		for (int i = 0; i < letters.length(); i++) {
			item.append(letters.charAt(i));
			helper(result, item, map, digits);
			item.deleteCharAt(item.length() - 1);
		}
	}
}
