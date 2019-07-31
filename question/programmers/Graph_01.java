package programmers;

import java.util.LinkedList;
import java.util.Queue;

public class Graph_01 {
	public static void main(String args[]) {
		System.out.println(solution(6, new int[][] {
			{3,6}, {4,3}, {3,2}, {1,3}, {1,2},{2,4},{5,2}
		}));
		
	}
	public static int solution(int n, int[][] edge) {
        int answer = 0, a, b, node = 0;
        Queue<Integer> q = new LinkedList<Integer>();
        int[][] graph = new int[n][n];
        boolean[] check = new boolean[n];
        for(int i=0 ; i<n;i++) {
        	graph[i][i] = 1;
        	a = edge[i][0]-1;
        	b = edge[i][1]-1;
        	graph[a][b] = 1;
        	graph[b][a] = 1;
        }
        q.add(node);
		check[node] = true;
		while(!q.isEmpty()) {
			node = q.remove();
			for(int i = 0; i<n;i++) {
				if(!check[i]&&graph[node][i]==1) {
					q.add(i);
					check[i] = true;
				}
			}
		}
        return answer;
    }
}
