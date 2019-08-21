package practice;

import java.util.LinkedList;

public class MoreSpicy {

	public static void main(String[] args) {
		System.out.println(solution(new int[] {0,0,0, 3},4));
	}
	public static int solution(int[] scoville, int K) {
        int answer = 0, first, second;
        LinkedList<Integer> scv = new LinkedList<>();
        
        for(int i = 0; i<scoville.length; i++) {
        	scv.add(scoville[i]);
        }
        while(!scv.isEmpty()) {
        	first = scv.remove(0);
        	if(first<K) {
        		second = scv.remove(0);
        		scv.addFirst(first+second*2);
        		answer++;
        		for(int i = 0; i<scv.size();i++) {//정렬
        			
        		}
        	}else {
        		answer = -1;
        		break;
        	}
        }
        return answer;
    }
}
