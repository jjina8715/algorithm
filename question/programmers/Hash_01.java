package practice;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;


public class Hash_01 {

	public static void main(String[] args) {
		String[] participant = { "mislav", "stanko", "mislav", "ana"};
		String[] completion = {"stanko", "mislav", "ana"};
		String result = solution2(participant, completion);
		System.out.println(result);
	}

	public static String solution(String[] participant, String[] completion) {
		String answer = "";
		HashMap<String, Integer> map = new HashMap<String, Integer>();
		for(String player: participant) {
			if(!map.containsKey(player))
				map.put(player, 1); 
			else 
				map.put(player, map.get(player)+1);
		}
		
		for(String player: completion) {
			if(map.get(player)==1)
				map.remove(player);
			else
				map.put(player, map.get(player)-1);	
		}
		Iterator<String> it = map.keySet().iterator();
		answer = it.next();
		return answer;
	}
	public static String solution2(String[] participant, String[] completion) {
		String answer = "";
		HashMap<String, Integer> map = new HashMap<String, Integer>();
		for(String player: participant)
			map.put(player, map.getOrDefault(player, 0)+1);
		
		for(String player: completion)
			map.put(player, map.get(player)-1);
		
		Set<String> key = map.keySet();
		for(String player: key)
			if(map.get(player)!=0)
				answer = player;
		return answer;
	}
}
