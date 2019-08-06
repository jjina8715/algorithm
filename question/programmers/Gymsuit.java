package practice;

import java.util.HashMap;

public class Gymsuit {

	public static void main(String[] args) {
		System.out.println("ans : "+solution(5, new int[] {2,4}, new int[] {1,3,5}));
	}
	public static int solution(int n, int[] lost, int[] reserve) {
        int answer = 0, suit, fid;
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i = 1; i<= n ;i++)
        	map.put(i, 1);
        for(int i = 0; i< reserve.length ;i++)
        	map.put(reserve[i], 2);
        for(int i = 0; i<lost.length ;i++)
        	map.put(lost[i], map.get(lost[i])-1);
       
        for(int i = 1; i<= n ;i++) {
        	suit = map.get(i);
        	if(suit==0) {
        		fid = i-1;
        		if(fid>0&&map.get(fid)>1) {
        			map.put(fid, 1);
        			map.put(i, 1);
        			answer++;
        			continue;
        		}
        		fid = i+1;
        		if(fid<=n&&map.get(fid)>1) {
        			map.put(fid, 1);
        			map.put(i, 1);
        			answer++;
        		}
        	}else if(suit>0)
        		answer++;
        }

        return answer;
    }
}
