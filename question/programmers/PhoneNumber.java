package programmers;

import java.util.HashSet;
import java.util.Iterator;

public class PhoneNumber {

	public static void main(String[] args) {
		String[] phone_book = {"119", "97674223", "1195524421"};
		System.out.println(solution(phone_book));
	}
	public static boolean solution(String[] phone_book) {
        boolean answer = true;
        String temp;
        HashSet<String> hash = new HashSet<>();
        for(String num: phone_book) 
        	hash.add(num);
        Iterator<String> it = hash.iterator(); 
        while(it.hasNext()) {
        	temp = it.next();
        	for(String num : phone_book) {
        		if(!num.equals(temp)&&temp.startsWith(num))
        			return false;
        	}
        }
        return answer;
    }
}
