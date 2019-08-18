package practice;

import java.util.ArrayList;
import java.util.Collections;

public class ConnectIslands {

	public static void main(String[] args) {
		
	}
	public static int[] parent;
	public static ArrayList<Edge> edgeList;
	
	 public int solution(int n, int[][] costs) {
	        int answer = 0;
	        edgeList = new ArrayList<>();
	        for(int i = 0; i<costs.length;i++) {
	        	edgeList.add(new Edge(costs[i][0], costs[i][1], costs[i][2]));
	        }
	        parent = new int[n];
	        for(int i =0; i<n;i++)
	        	parent[i] = i;
	        
	        Collections.sort(edgeList);
	        
	        for(int i = 0; i<edgeList.size();i++) {
	        	Edge edge = edgeList.get(i);
	        	if(!isSameParent(edge.v1, edge.v2)) {
	        		answer+= edge.cost;
	        		union(edge.v1, edge.v2);
	        	}
	        }
	        return answer;
	        
	  }
	 public static void union(int x, int y) {
		 x = find(x);
		 y = find(y);
		 if(x!=y)
			 parent[y] = x;
	 }
	private static int find(int x) {
		if(parent[x] == x)
			return x;
		return parent[x] = find(parent[x]);
	}
	public static boolean isSameParent(int x, int y) {
		 x = find(x);
	        y = find(y);
	        if(x == y) return true;
	        else return false;
	}
}
class Edge implements Comparable<Edge>{
	 int v1;
	 int v2;
	 int cost;
	 Edge(int v1, int v2, int cost) {
		 this.v1 = v1;
		 this.v2 = v2;
		 this.cost = cost;
	 }
	@Override
	public int compareTo(Edge o) {
		if(this.cost<o.cost)
			return -1;
		else if(this.cost==o.cost)
			return 0;
		else
			return 1;
	}
}