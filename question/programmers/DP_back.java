package programmers;

import java.util.Stack;

public class DP_back {

	public static void main(String[] args) {
		System.out.println(solution(4, 3, new int[][] {}));
	}
	public static int solution(int m, int n, int[][] puddles) {
        int answer = 0;
        long cnt = 0;
        long[][] path = new long[n][m];
        path[0][0]=1;
        for(int[] p: puddles)
        	path[p[1]][p[0]] = 0;
        for(int i =0; i<n;i++) {
        	for(int j=0; j<m;j++) {
        		if(path[i][j]!=0) {
        			if(i==0||i==n||j==0||j==m)
        				path[i][j] = 1;
        			else{
        				path[i][j] = path[i][j-1]+path[i-1][j];
        			}
        		}
        	}
        }
        answer = (int)(path[n-1][m-1]%1000000007L);
        /*Stack<int[]> s = new Stack<>();
		
        for(int[] p : puddles)
        	path[p[1]][p[0]] = true;

		int[] index = {0, 0};
		int i, j;
		s.add(index);
		while(!s.isEmpty()) {
			index=s.pop();
			i=index[0];
			j=index[1];
			if(i==n-1&&j==m-1)
				cnt++;
			else{
				if(j+1!=m&&path[i][j+1]==false)
					s.push(new int[] {i, j+1});
				if(i+1!=n&&path[i+1][j]==false)
					s.push(new int[] {i+1, j});
			}
		}
		answer=(int)(cnt%1000000007L);*/
        return answer;
    }

}
