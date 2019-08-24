package practice;

import java.util.PriorityQueue;
import java.util.Queue;

public class RamenFactory {
	// 4, {1,2,3,4}, {10,40,30,20},100 4
	public static void main(String[] args) {
		System.out.println(solution(4, new int[] { 1, 2, 3, 4 }, new int[] { 10, 40, 30, 20 }, 100));
	}

	public static int solution(int stock, int[] dates, int[] supplies, int k) {
		int answer = 0, i = 0, len = dates.length;
		Queue<Integer> q = new PriorityQueue<>((o1, o2) -> { return o1 < o2 ? 1 : -1; });

		for (int d = 0; d < k; d++, stock--) {
			if (i < len && d == dates[i])
				q.offer(supplies[i++]);
			if (stock <= 0) {
				stock += q.poll();
				answer++;
			}
		}
		return answer;
	}
}