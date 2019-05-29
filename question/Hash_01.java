package practice;

import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;

public class Hash_01 {

	public static void main(String[] args) {
		String[] participant = {"mislav", "stanko", "mislav", "ana"};
		String[] completion = {"stanko", "mislav", "ana"};
		String result = solution(participant, completion);
		System.out.println(result);
	}

	public static String solution(String[] participant, String[] completion) {
		String answer = "";
		String player;
		HashMap<String, Integer> map = new HashMap<String, Integer>();
		for(int i = 0; i<participant.length;i++) {
			player = participant[i];
			if(!map.containsKey(player))
				map.put(player, 1);
			else 
				map.put(player, map.get(player)+1);
		}
		
		for(int i =0; i<completion.length;i++) {
			player = completion[i];
			if(map.get(player)==1)
				map.remove(player);
			else
				map.put(player, map.get(player)-1);	
		}
		Iterator<String> it = map.keySet().iterator();
		answer = it.next();
		return answer;
	}
}
