package practice;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class H_index {

	public static void main(String[] args) {
		int[] citations = {3, 5, 6, 1, 0};
		System.out.println(solution(citations));
		int[] citations2 = {22, 42};
		System.out.println(solution(citations2));
		int[] citations3 = {10,100};
		System.out.println(solution(citations3));
		int[] citations4 = {6,6,6,6,6,6};
		System.out.println(solution(citations4));
		int[] citations5 = {2,2,2};
		System.out.println(solution(citations5));
	}
	public static int solution(int[] citations) {
        int answer = 0;
        /*ArrayList<Integer> list = new ArrayList<Integer>(citations.length);
        
       	for(int i : citations)
       		list.add(i);
       	
        Collections.sort(list, Collections.reverseOrder());
        for(int i = list.size(); i>0;i--) {
        	if(list.get(i-1)>=i) {
        		answer=i;
        		break;
        	}
        }*/
        Arrays.sort(citations);
        int len = citations.length;
        for(int i = len;i>0;i--)
        	if(citations[len-i]>=i) {
        		answer=i;
        		break;
        	}
        return answer;
    }
}
