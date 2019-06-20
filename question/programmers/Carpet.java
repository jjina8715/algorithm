package practice;

public class Carpet {

	public static void main(String[] args) {
		int[] an = solution(10,2);
		System.out.println(an[0]+" "+an[1]);
		an = solution(8,1);
		System.out.println(an[0]+" "+an[1]);
	}
	public static int[] solution(int brown, int red) {
        int[] answer = {0,0};
        int hap = brown/2+2;
        if(brown%2==1)
        	return answer;
        for(int s=3; s<=hap;s++) {
        	for(int g=s; g+s<=hap;g++) {
        		if((2*(g+s)-4==brown)&&(g-2)*(s-2)==red) {
        			answer[0] = g;
        			answer[1] = s;
        			break;
        		}
        	}
        	if(answer[0]!=0)
        		break;
        }
        return answer;
    }
	public int[] solution2(int brown, int red) {
        int[] answer = {0,0};
        double side = (brown+4)/2;
        double area = (red+brown)*4;

        answer[0] = (int)(side+Math.sqrt(side*side-area))/2;
        answer[1] = (int)(side-Math.sqrt(side*side-area))/2;
       return answer; 
    }
}
