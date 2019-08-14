package practice;

public class Theft {
	public static void main(String[] args) {
		System.out.println("ans: " + solution(new int[] { 1, 2, 3, 1 }));
	}

	public static int solution(int[] money) {
		int answer = 0, len = money.length;
		int[] stolen = new int[len];
		
		stolen[0] = stolen[1] =  money[0];//첫번째 집을 훔쳤을 때
		for (int i = 2; i < len - 1; i++) {
			stolen[i] = Math.max(stolen[i-2]+money[i], stolen[i-1]);
		}
		answer = stolen[len-2];
		stolen[0] = 0;
		stolen[1] = money[1];//두번째 집을 훔쳤을 때
		for (int i = 2; i < len; i++) {
			stolen[i] = Math.max(stolen[i-2]+money[i], stolen[i-1]);
		}
		answer = Math.max(answer, stolen[len-1]);
		return answer;
	}

}
