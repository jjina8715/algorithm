package programmers;

import java.util.Arrays;
import java.util.LinkedList;

public class Scale {

	public static void main(String[] args) {
		System.out.println(solution(new int[] {3,1,6,2,7,30,1}));
	}
	public static int solution(int[] weight) {
        int answer = 0;
        Arrays.sort(weight);
        LinkedList<Integer> list = new LinkedList<>();
        
        for(int w : weight)
        	list.add(w);
        
        return answer;
    }
}
