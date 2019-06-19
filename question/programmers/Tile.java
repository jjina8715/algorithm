package programmers;

public class Tile {
	public static void main(String[] args) {
		System.out.println(solution(5));
	}
	public static long solution(int n) {
		long answer = 0;
        answer = getRound(n)*2+(getRound(n-1)+getRound(n))*2;
        return answer;
    }
    public static long getRound(long n){  	
    	if(n==1)
        	return 1;
    	else if(n==2)
    		return 1;
    	else {
    		
    		return getRound(n-1)+getRound(n-2);
    	}
    }
}
