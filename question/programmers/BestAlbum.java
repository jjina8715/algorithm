package programmers;

import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class BestAlbum {

	public static void main(String[] args) {
		solution(new String[] {"classic", "pop", "classic", "classic", "pop"}, new int[] {500, 600, 150, 800, 2500});
	}
	public static int[] solution(String[] genres, int[] plays) {
        int[] answer = {};
        Map<String, LinkedList<Integer[]>> list = new HashMap<String, LinkedList<Integer[]>>();
        Map<String, Integer> g_plays = new LinkedHashMap<>();
        for(int i=0; i<genres.length;i++) {
        	list.put(i, new String[] {genres[i], plays[i]+""});
        	g_plays.put(genres[i], g_plays.getOrDefault(genres[i], plays[i])+plays[i]);
        }
        Iterator<Map.Entry<String, Integer>> it = sortByPlays(g_plays).iterator();
        while(it.hasNext())
        	System.out.println(it.next().getValue());
        return answer;
    }
	public static List<Map.Entry<String, Integer>> sortByPlays(Map<String, Integer> map) {
		List<Map.Entry<String, Integer>> list = new LinkedList<>(map.entrySet());
		Collections.sort(list, new Comparator<Map.Entry<String, Integer>>(){
			@Override
			public int compare(Entry<String, Integer> o1, Entry<String, Integer> o2) {
				return o2.getValue().compareTo(o1.getValue());
			}
		});
		return list;
	}
}