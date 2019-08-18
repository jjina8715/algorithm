package practice;

import java.util.Arrays;

public class Scale {

	public static void main(String[] args) {
		System.out.println(solution(new int[] {3,1,6,2,7,30,1}));
	}
	public static int solution(int[] weight) {
        int answer = 1;
        Arrays.sort(weight);
        
        for(int i = 0;i<weight.length;i++) {
        	if(answer<weight[i])
        		break;
        	answer+=weight[i];
        }
        return answer;
    }
}
