package practice;

import java.util.Stack;

public class DP_back {

	public static void main(String[] args) {
		System.out.println(solution(4,3, new int[][] {{2,2}}));
	}
	public static int solution(int m, int n, int[][] puddles) {
		int answer = 0;
        long[][] path = new long[m][n];
        for(int[] p: puddles) {
        	if(--p[0]==0)
        		for(int i=p[1];i<n;i++)
        			path[p[0]][i]=-1;
        	if(--p[1]==0)
        		for(int i=p[0];i<m;i++)
        			path[i][p[1]]=-1;
        		path[p[0]][p[1]] = -1;
        }
        path[0][0]=1;
        for(int i =0; i<m;i++) {
        	for(int j=0; j<n;j++) {
        		if(path[i][j]!=-1) {
        			if(i==0||j==0) {
        				path[i][j] = 1;
        			}else{
        				path[i][j] = (path[i][j-1]+path[i-1][j])%1000000007L;
        			}
        		}else {
        			path[i][j]=0;
        		}
        	}
        }
        answer =  (int)path[m-1][n-1];
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
