package practice;

import java.util.Scanner;
//±º¼ö¿­
public class GroupSeq {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int cnt = 0, group = 1, n = 0;
		long k = in.nextInt();
		while(cnt < k) {
			cnt++;
			if((++n)==group) {
				n = 1;
				group++;
			}
		}
		System.out.println(n);
	}

}
