package practice;

public class Pedestrian {
	public static void main(String[] args) {
		System.out.println(solution(3, 6, new int[][] {{0, 2, 0, 0, 0, 2}, {0, 0, 2, 0, 1, 0}, {1, 0, 0, 2, 2, 0}}));
	}
	static int MOD = 20170805;
	  public static int solution(int m, int n, int[][] cityMap) {
	      int answer = 0;
	      int[][] rightway = new int[m+1][n+1];
	      int[][] downway = new int[m+1][n+1];
	      
	      rightway[1][1] = downway[1][1] =  1;
	      for(int i=1; i<=m; i++) {
	    	  for(int j=1; j<=n; j++) {
	    		  if(cityMap[i-1][j-1] == 0) {
    				  rightway[i][j] += rightway[i][j-1]+downway[i-1][j]%MOD;
    				  downway[i][j] += rightway[i][j-1]+downway[i-1][j]%MOD;
    			  }else if(cityMap[i-1][j-1] == 2) {
    				  rightway[i][j] = rightway[i][j-1]%MOD;
    				  downway[i][j] = downway[i-1][j]%MOD;
    			  }else {
    				  rightway[i][j] = 0;
    				  downway[i][j] = 0;
    			  }
	    	
	    	  }
	      }
	      answer = rightway[m][n];
	      return answer;
	  }
}
 