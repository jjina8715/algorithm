package programmers;

import java.util.HashMap;
import java.util.Iterator;

public class Camouflage {

	public static void main(String[] args) {
		String[][] clothes = {
				{"yellow_hat", "headgear"},
				{"blue_sunglasses", "eyewear"},
				{"green_turban", "headgear"},
				{"crow_mask", "face"},
				{"blue_sunglasses", "face"},
		};

		System.out.print(solution(clothes));
	}
	public static int solution(String[][] clothes) {
        int answer = 1;
        HashMap<String, Integer> map = new HashMap<>();
        for(String[] c: clothes)
        	map.put(c[1], map.getOrDefault(c[1], 0)+1);
        Iterator<String> it = map.keySet().iterator();
        while(it.hasNext())
        	answer *= map.get(it.next())+1;
        
        return answer-1;
    }
}
