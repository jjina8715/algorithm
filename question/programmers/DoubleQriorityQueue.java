package programmers;

import java.util.PriorityQueue;

public class DoubleQriorityQueue {
	//"I 16", "D 1"
//"I 7","I 5","I -5","D -1"
	//"I -45", "I 653", "D 1", "I -642", "I 45", "I 97", "D 1", "D -1", "I 333"
	public static void main(String[] args) {
		int[] as = solution(new String[] {"I -45", "I 653", "D 1", "I -642", "I 45", "I 97", "D 1", "D -1", "I 333"});
		System.out.println(as[0]+" "+as[1]);

	}
	 public static int[] solution(String[] operations) {
	        int[] answer;
	        int num, len = operations.length;
	        PriorityQueue<Integer> sortdesc = new PriorityQueue<>((o1, o2)->{return o2.compareTo(o1);}) ;//내림차순
	        PriorityQueue<Integer> sortasc = new PriorityQueue<>();//오름차순
	        String[] opers;
	        for(int i = 0; i<len; i++) {
	        	opers = operations[i].split(" ");
	        	if(opers[0].equals("I")) {
	        		num = Integer.parseInt(opers[1]);
	        		sortdesc.offer(num);
	        		sortasc.offer(num);
	        	}else{
	        		if(sortdesc.size()>0)
	        			if(opers[1].equals("1"))
	        				sortasc.remove(sortdesc.poll());
	        			else 
	        				sortdesc.remove(sortasc.poll());
	        	}
	        }
	        if(sortdesc.size()<=0)
	        	answer = new int[] {0,0};
	        else
	        	answer = new int[] {sortdesc.peek(),sortasc.peek()};
	        return answer;
	    }
}
