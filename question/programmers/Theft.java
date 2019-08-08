package programmers;

import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class Theft {
	public static void main(String[] args) {
		System.out.println("ans: " + solution(new int[] { 
				1,2,3,1 }));
	}
	public static int solution(int[] money) {
        int answer = 0;
        
        answer = money[0];
        for(int i = 0; i<money.length-2;) {
        	if(money[i+2]>money[i+3])
        }
        
        return answer;
    }
	public static int solution2(int[] money) {
        int answer = 0;
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        for(int i = 0; i<money.length;i++)
        	map.put(i, money[i]);
        
        List<Map.Entry<Integer, Integer>> list = new LinkedList<>(map.entrySet());
		Collections.sort(list, (o1, o2)->{return o2.getValue().compareTo(o1.getValue());});
		
        return answer;
    }
}
