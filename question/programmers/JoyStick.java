package practice;

public class JoyStick {
//AZAAAZ 5
	public static void main(String[] args) {
		
	}
	 public int solution(String name) {
	        int answer = 0, len = name.length(), next, where = len-1, min;
	        char cur;
	        
	        for(int i = 0; i<len; i++) {
	        	next = i+1;
	        	cur = name.charAt(i);
	        	if(cur<='N')
	        		answer+=cur-'A';
	        	else
	        		answer+='Z'-cur+1;
	        	
	        	while(next<len&&name.charAt(next)=='A')
	        		next++;
	        	
	        	min = i+len-next +Math.min(i, len-next);
	        	where = Math.min(where, min);
	        }
	        answer += where;
	        return answer;
	    }
}
