package practice;

import java.util.Scanner;
//±º¼ö¿­
public class GroupSeq {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		long k = in.nextInt();
		
		System.out.println(solution(k));
	}
	public static long solution(long k) {
		/*long cnt = 0, group = 1, n = 0;
		while(cnt < k) {
			cnt++;
			if((++n)==group) {
				n = 1;
				group++;
			}
		}
		return n;
		*/
		long cnt = 0, group = 0;
		while(cnt<k) {
			cnt += ++group;
		}
		return group-(cnt-k);
	}
}
