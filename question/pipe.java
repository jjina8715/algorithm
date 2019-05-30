package practice;

import java.util.Stack;

public class pipe {
	public static void main(String[] args) {
		String arrangement = "()(((()())(())()))(())";
		int cnt = solution(arrangement);
		System.out.println(cnt);
	}
	 public static int solution(String arrangement) {
	        int answer = 0;
	        char brk, pre = ' ';
	        Stack<Character> stack = new Stack<Character>();
	        for(int i = 0; i<arrangement.length();i++) {
	        	brk = arrangement.charAt(i);
	        	if(brk == '(') 
	        		stack.push(brk);
	        	else {
	        		stack.pop();
	        		if(pre=='(')//arrangement.charAt(i-1)=='('
	        			answer += stack.size();
	        		else
	        			answer++;
	        	}
	        	pre = brk;
	        }
	        return answer;
	    }
}
