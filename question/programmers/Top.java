package practice;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class Top {
	public static void main(String[] args) {
		int[] h = {6,9,5,7,4};
		int[] a = solution2(h);
		for(int i : a)
			System.out.println(i);
	}
	 static public int[] solution(int[] heights) {
		 	int top, idx, len = heights.length;
	        int[] answer = new int[len];
	        Queue<Integer> h = new LinkedList<Integer>();
	        Queue<Integer> loc = new LinkedList<Integer>();
	        Iterator<Integer> it, locIt;
	        for(int i = len-1; i>=0; i--) {
		    	loc.add(i+1);
		    }
	        
	        for(int i = len-1; i>=0; i--){
	        	top = h.remove();
	        	loc.remove();
	        	it = h.iterator();
	        	locIt = loc.iterator();
	        	while(it.hasNext()&&locIt.hasNext()) {
	        		idx = locIt.next();
	        		if(it.next()>top) {
	        			answer[i] = idx;
	        			break;
	        		}
	        	}
	        }
	        return answer;
	    }
	 static public int[] solution2(int[] heights) {
		 	int top, len = heights.length;
	        int[] answer = new int[len];
	        Stack<Integer> h = new Stack<Integer>();
	        Stack<Integer> loc = new Stack<Integer>();
	        
	        for(int i = 0; i<len; i++) {
		    	h.push(heights[i]);
		    	loc.push(i+1);
		    }
	        for(int i = len-1; i>=0; i--){
	        	top = h.pop();
	        	loc.pop();
	        	for(int j = h.size()-1; j>=0; j--) {
	        		if(h.get(j)>top) {
	        			answer[i] = j+1;
	        			break;
	        		}
	        	}
	        }
	        return answer;
	    }
}
