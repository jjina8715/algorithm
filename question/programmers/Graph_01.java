package practice;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Graph_01 {
	public static void main(String args[]) {
		System.out.println(
				solution2(6, new int[][] { { 3, 6 }, { 4, 3 }, { 3, 2 }, { 1, 3 }, { 1, 2 }, { 2, 4 }, { 5, 2 } }));

	}

	public static int solution(int n, int[][] edge) {
		int answer = 0, a, b, node = 0;
		Queue<Integer> q = new LinkedList<Integer>();
		int[][] graph = new int[n][n];
		boolean[] check = new boolean[n];
		for (int i = 0; i < edge.length; i++) {
			a = edge[i][0] - 1;
			b = edge[i][1] - 1;
			graph[a][b] = 1;
			graph[b][a] = 1;
		}
		q.add(node);
		check[node] = true;
		while (!q.isEmpty()) {
			answer = q.size();
			for (int j = 0; j < answer; j++) {
				node = q.remove();
				for (int i = 0; i < n; i++) {
					if (!check[i] && graph[node][i] == 1) {
						q.add(i);
						check[i] = true;
					}
				}
			}
		}
		return answer;
	}

	public static int solution2(int n, int[][] edge) {
		int answer = 0, a, b, node = 0;
		Queue<Integer> q = new LinkedList<Integer>();
		ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
		boolean[] check = new boolean[n];
		for(int i = 0; i<n;i++)
			graph.add(new ArrayList<>());
		
		for (int i = 0; i < edge.length; i++) {
			a = edge[i][0] - 1;
			b = edge[i][1] - 1;
			graph.get(a).add(b);
			graph.get(b).add(a);
		}

		q.add(node);
		check[node] = true;
		while (!q.isEmpty()) {
			answer = q.size();
			for (int j = 0; j < answer; j++) {
				node = q.remove();
				for (int data: graph.get(node)) {
					if (!check[data] ) {
						q.add(data);
						check[data] = true;
					}
				}
			}
		}
		return answer;
	}
}
