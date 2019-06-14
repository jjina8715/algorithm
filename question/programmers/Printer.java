package practice;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;

public class Printer {

	public static void main(String[] args) {
		int[] pri = {1, 1, 9, 1, 1, 1};
		System.out.println(solution(pri, 0));
	}

	public static int solution(int[] priorities, int location) {
	    int answer = 0, tmp, tmpLoc;
	    boolean flag= true;
	    Queue<Integer> q = new LinkedList<Integer>(); 
	    Queue<Integer> loc = new LinkedList<Integer>(); 
	    Iterator<Integer> it;
	    for(int i =0; i<priorities.length; i++) {
	    	q.add(priorities[i]);
	    	loc.add(i);
	    }
	    while(!q.isEmpty()) {
	    	tmp = q.peek();
	    	tmpLoc = loc.peek();
	    	it = q.iterator();
	    	while(it.hasNext()) {
	    		if(it.next()>tmp) {
	    			q.add(tmp);
	    			loc.add(tmpLoc);
	    			flag = false;
	    			break;
	    		}
	    	}
	    	q.remove();
	    	loc.remove();
	    	if(flag) {
	    		answer++;
	    		if(tmpLoc == location)
	    			break;
	    	}
	    	flag = true;
	    }
	    return answer;
	}
}
