package baekjoon;

import java.util.LinkedList;
import java.util.Scanner;
import java.util.Stack;

public class Lab3 {

	public static void main(String[] args) {
		int m, n;
		int[][] lab;
		Scanner in = new Scanner(System.in);
		Stack<Integer[]> stack = new Stack<>();
		LinkedList<Integer> result = new LinkedList<Integer>();
 		n = in.nextInt();
		m = in.nextInt();
		lab = new int[n][n];
		for(int i = 0; i<n;i++) 
			for(int j = 0; j<n;j++) {
				lab[i][j] = in.nextInt();
				if(lab[i][j]==2)
					stack.add(new Integer[] {i, j});
			}
		
		System.out.println("docom");
		doCom(result, stack.size(), m, 0, 0, stack);
		
	}
	public static void doCom(LinkedList<Integer> result, int len, int m, int index, int target, Stack<Integer[]> stack) {
		 
		if(m==0) {
			for(int i = 0; i<result.size();i++)
				System.out.print(result.get(i)+" ");
			System.out.println();
		}else if(target==len) {
			return ;
		}else {
			result.add(target);
			doCom(result, len, m-1, index+1, target+1, stack);
			doCom(result, len, m, index, target+1, stack);
		}
						
	}
}
