package programmers;

import java.util.PriorityQueue;
import java.util.Queue;

public class MoreSpicy {

	public static void main(String[] args) {
		System.out.println(solution(new int[] {1, 2, 3, 9, 10, 12},7));
	}
	public static int solution(int[] scoville, int K) {
        int answer = 0;
        Queue<Integer> scv = new PriorityQueue<Integer>(scoville.length);
        
        for(int i = 0; i<scoville.length; i++) {
        	scv.add(scoville[i]);
        }
        
        while(scv.peek()<K&&scv.size()>=2) {
        	scv.offer(scv.poll()+scv.poll()*2);
        	answer++;
        }
        if(scv.peek()<K)
        	answer=-1;
        return answer;
    }
}
