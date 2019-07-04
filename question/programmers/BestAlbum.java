package programmers;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class BestAlbum {

	public static void main(String[] args) {
		
		int[] ans = solution(
				new String[] {"classic","pop","classic","classic","pop", "jazz", "jazz"},
				new int[] {500, 600, 150, 800, 2500, 2000, 1000});
		for(int i:ans)
			System.out.print(i+" ");
	}
	public static int[] solution(String[] genres, int[] plays) {
        int[] answer = {};
        int sidx;
        Map<String, LinkedList<Integer[]>> list = new HashMap<String, LinkedList<Integer[]>>();
        Map<String, Integer> g_plays = new HashMap<>();
        LinkedList<Integer[]> song = null;
        ArrayList<Integer> ans = new ArrayList<>();
        
        for(int i=0; i<genres.length;i++) {
        	song = list.getOrDefault(genres[i], new LinkedList<Integer[]>());
        	song.add(new Integer[] {i,plays[i]});
        	list.put(genres[i], song);
        	g_plays.put(genres[i], g_plays.getOrDefault(genres[i], 0)+plays[i]);
        }
        Iterator<Map.Entry<String, Integer>> it = sortByPlays(g_plays).iterator();
        while(it.hasNext()){
        	song = list.get(it.next().getKey());
        	Collections.sort(song, new Comparator<Integer[]>(){
				@Override
				public int compare(Integer[] o1, Integer[] o2) {
					if(o1[1].equals(o2[1])) {
						if(o1[0].compareTo(o2[0])==1)
							return 1;
						else
							return -1;
					}else if(o1[1]<o2[1])
						return 1;
					else 
						return -1;
				}
        	});

        	sidx=0;
        	Iterator<Integer[]> it2 = song.iterator();
        	while(it2.hasNext()&&sidx<2) {
        		ans.add(it2.next()[0]);
        		sidx++;
        	}
        }
        int len = ans.size();
        answer = new int[len];
        for(int i=0;i<len;i++) {
        	answer[i]=ans.get(i);
        }
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