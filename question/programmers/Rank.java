package practice;

import java.util.ArrayList;
import java.util.HashSet;

public class Rank {

	public static void main(String[] args) {
		System.out.println(solution(5, new int[][] {{4, 3}, {4, 2}, {3, 2}, {1, 2}, {2, 5}}));
	}
	 public static int solution(int n, int[][] results) {
	        int answer = 0;
	        ArrayList<Player> list = new ArrayList<>();
	        Player player;
	        HashSet<Integer> add;
	        
	        for(int i = 0; i<=n; i++)
	        	list.add(new Player());
	        for(int[] l:results) {
	        	list.get(l[1]).lose.add(l[0]);
	        	list.get(l[0]).win.add(l[1]);
	        }
	        for (int k = 0; k < 2; k++)
	        	for(int i = 1; i<=n; i++) {
	        		player = list.get(i);
	        		add = new HashSet<Integer>();
	        		for(int l : player.lose)
	        			add.addAll(list.get(l).lose);
	        		player.lose.addAll(add);
	        	
	        		add = new HashSet<Integer>();
	        		for(int w : player.win)
	        			add.addAll(list.get(w).win);
	        		player.win.addAll(add);
	        	}
	        
	        for(Player p : list) {
	        	answer += p.lose.size()+p.win.size()>=n-1?1:0;
	        }
	        return answer;
	    }
}
class Player{
	 HashSet<Integer> win = new HashSet<>();
	 HashSet<Integer> lose = new HashSet<>();
}