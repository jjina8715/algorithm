package practice;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class H_index {

	public static void main(String[] args) {
		int[] citations = {3, 5, 6, 1, 0};//{22, 42};
		System.out.println(solution(citations));
	}
	public static int solution(int[] citations) {
        int answer = 0;
        List<Integer> list = new ArrayList<Integer>(citations.length);
        
       	for(int i : citations)
       		list.add(i);
       	
        Collections.sort(list, new Comparator<Integer>() {
			@Override
			public int compare(Integer o1, Integer o2) {
				return o2.compareTo(o1);
			}
        });
       
        System.out.println(list);
        for(int i = list.get(list.size()-1); i>=0;i--) {
        	if((i+1)>=list.get(i)) {
        		answer = list.get(i);
        		break;
        	}
        }
        return answer;
    }
}
