package Valid_Parentheses;

import java.util.Stack;

public class Question {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(isValid("([)]"));
	}
	
	/**
	 * https://oj.leetcode.com/problems/valid-parentheses/
	 * Given a string containing just the characters '(', ')', '{', '}', 
	 * '[' and']', determine if the input string is valid.
	 * 
	 * The brackets must close in the correct order, "()" and "()[]{}" are all
	 * valid but "(]" and "([)]" are not.
	 */
	//http://blog.csdn.net/linhuanmars/article/details/19800789
    public static boolean isValid(String s) {
    	if (s == null || s.length() == 0 || s.length() %2 ==1){
    		return false;
    	}
    	
    	String left  = "([{";
    	String right = ")]}";
    	Stack<Character> stack = new Stack<Character>();
    	for(int i=0;i<s.length();i++){
    		char curChar = s.charAt(i);
    		if(left.indexOf(curChar) > -1){//如果是左括号就入栈
    			stack.push(curChar);
    		}else if(right.indexOf(curChar) > -1){//如果是右括号，就来试着匹配栈顶的左括号
    			if (stack.isEmpty()){//如果栈已经为空，则异常
    				return false;
    			}else{
    				char preChar = stack.pop();
    				if(left.indexOf(preChar) != right.indexOf(curChar)){//不匹配， 则false
    					return false;
    				}
    			}
    		}else{//当前char既不是左括号， 也不是右括号， 则false
    			return false;
    		}
    	}
    	//如果栈内什么都没剩下, 则true
    	return stack.isEmpty();
    }

}
