package practice;

public class IntegerTri {

	public static void main(String[] args) {
		System.out.println(solution(new int[][] {{7}, {3, 8}, {8, 1, 0}, {2, 7, 4, 4}, {4, 5, 2, 6, 5}}));
	}
	public static int solution(int[][] triangle) {
        int answer = 0, height = triangle.length;
        for(int i = height-1; i>0;i--) {
        	for(int j = 1; j<triangle[i].length;j++) {
        		triangle[i-1][j-1] += Math.max(triangle[i][j-1],triangle[i][j]);
        	}
        }
        answer = triangle[0][0];
        return answer;
    }
}
