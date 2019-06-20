package practice;

public class Tile {
	public static void main(String[] args) {
		System.out.println(solution(5));
	}

    public static long solution(int n) {
    	long answer = 0;
    	long[] sides = new long[n];
    	sides[0] = sides[1] = 1;
    	if(n==1)
    		return 4;
    	for(int i = 2; i<n;i++)
    		sides[i] = sides[i-1]+sides[i-2];
    	
    	answer = sides[n-1]*2+(sides[n-2]+sides[n-1])*2;
    	return answer;
    }
}
