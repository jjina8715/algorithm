package practice;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;

public class Qtruck {
	public static void main(String[] args) {
		System.out.println(solution(2,10, new int[] {7,4,5,6}));
	}
    public static int solution(int bridge_length, int weight, int[] truck_weights) {
        int answer = 0, total = 0, idx = 0, cur;
        Queue<Integer> inBridge = new LinkedList<>();
        
        while(idx != truck_weights.length) {
        	answer++;
        	
        	cur = truck_weights[idx];
        	if(total+cur<=weight) {
        		idx++;
        		inBridge.add(0);
        		total+=cur;
        	}
        	
        	increase(inBridge);
        	
        	if(inBridge.peek()==bridge_length) {
        		total -= truck_weights[idx-inBridge.size()];
        		inBridge.remove();
        	}
        }
        answer+=bridge_length;
        return answer;
    }
    public static void increase(Queue<Integer> inBridge) {
    	int len = inBridge.size();
    	
    	for(int i =0; i<len;i++){
    		inBridge.add(inBridge.remove()+1);
    	}
    }
}