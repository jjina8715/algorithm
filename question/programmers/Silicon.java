package 실기;

public class Silicon {

	public static void main(String[] args) {
		System.out.println(solution("happy-birthday", 45));
	}
	 public static String solution(String phrases, int second) {
		 	 int size = 14;
	        String answer = "";
	       StringBuffer tmp =new StringBuffer("______________");
	       tmp.append(phrases);
	       tmp.append("______________");
	        int mod = second%(size*2);
	        answer = tmp.substring(mod, mod+size).toString();
	        /*
	        System.out.println(mod);
	        if(mod<size) {
	        	size--;
	        	tmp.delete(size-mod, size);
	        	tmp.append(phrases.substring(0, mod));
	        }else if(mod>size){
	        	mod -= size;
	        	tmp.delete(0, size-mod);
	        	tmp.insert(0, phrases.substring(mod));
	        }
	        answer = mod==14?phrases:tmp.toString();*/
	        return answer;
	    }
	 
	/* public static int solution(int[] estimates, int k) {
	        int answer = 0, len = estimates.length, sum = 0;
	        
	        for(int i = 0; i<=len-k; i++) {
	        	sum = 0;
	        	for(int j = i; j<i+k; j++) 
	        		sum+=estimates[j];
	        	if(answer<sum)
	        		answer = sum;
	        }
	        for(int i = 0; i<k; i++)
	        	sum += estimates[i];
	        answer = sum;
	        for(int i  = 1; i<=len-k; i++) {
	        	sum = sum-estimates[i-1]+estimates[i+k-1];
	        	answer = answer>sum?answer:sum;
	        }
	        return answer;
	    }*/
	static private int[][] board = null;
	public static int solution(int[][] office, int k) {
        int answer = 0, len = office.length, cnt = 0;
        board = office;
        for(int i  = 0; i<=len-k;i++) {
        	for(int j = 0; j<=len-k;j++) {
        		cnt = countEmp(i,j,k);
        		answer = answer>cnt?answer:cnt;
        	}
        }
        return answer;
    }
	private static int countEmp(int i, int j, int k) {
		int cnt = 0;
		for(int m = i; m<i+k;m++) {
			for(int n = j; n<j+k;n++) {
				cnt += board[m][n];
			}
		}
		System.out.println(cnt);
		return cnt;
	}
}
