package programmers;

public class ColoringBook {

	public static void main(String[] args) {
		int[][] picture = {{1, 1, 1, 0}, {1, 2, 2, 0}, {1, 0, 0, 1}, 
		                   {0, 0, 0, 1}, {0, 0, 0, 3}, {0, 0, 0, 3}};
		int[] ans = solution(6,4,picture);
		System.out.println(ans[0]+" "+ans[1]);
	}
	static int height = 0;
	static int width = 0;
	static int[] idxX = {-1 , 0 , 1 , 0};
	static int[] idxY = {0 , 1 , 0 , -1};
	static int[][] board = null;
	static boolean[][] check = null;
	 public static int[] solution(int m, int n, int[][] picture) {
	      int numberOfArea = 0;
	      int maxSizeOfOneArea = 0;
	      int size = 0;
	      board = picture;
	      height = m;
	      width = n;
	      check = new boolean[m][n];
	      for(int i = 0; i<m; i++) {
	    	  for(int j = 0; j<n; j++) {
	    		  	if(board[i][j]!=0&&!check[i][j]) {
	    		  		size = bfs(i,j,board[i][j]);
	    		  		numberOfArea++;
	    		  		if(size>maxSizeOfOneArea)
	    		  			maxSizeOfOneArea = size;
	    		  	}
	    	  }
	      }
	      int[] answer = new int[2];
	      answer[0] = numberOfArea;
	      answer[1] = maxSizeOfOneArea;
	      return answer;
	  }
	private static int bfs(int x, int y, int color) {
		int addx,addy;
		int size = 1;
		check[x][y] = true;
		for(int i = 0; i<4;i++) {
			addx = idxX[i]+x;
			addy = idxY[i]+y;
			if(addx>=0&&addy>=0&&addx<height&&addy<width
					&&!check[addx][addy]&&board[addx][addy]==color) {
				size += bfs(addx,addy, color);
			}
		}
		return size;
	}
}
