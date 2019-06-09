package practice;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Solution {

	public static void main(String[] args) {
		int[] numbers = {3, 30, 34, 5, 9};
		System.out.println(solution(numbers));
	}

	public static String solution(int[] numbers) {
		String answer = "";
        List<String> arr = new ArrayList<String>();
        
        for(int i : numbers) {
        	arr.add(Integer.toString(i));
        }
        Collections.sort(arr, new Comparator<String>() {
			@Override
			public int compare(String o1, String o2) {
				return (o2+o1).compareTo(o1+o2);
			}
        });
       if(arr.get(0)=="0")
    	   answer = "0";
       else
    	   for(String i:arr)
    		   answer+=i;
        
        return answer;
    }
}
