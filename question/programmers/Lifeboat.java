package programmers;

import java.util.ArrayList;
import java.util.Arrays;

public class Lifeboat {

	public static void main(String[] args) {
		System.out.println("ans: " + solution(new int[] { 50, 60, 70, 80, 90, 100, 100, 110, 120, 150, }, 200));
	}

	public static int solution(int[] people, int limit) {
		int answer = 0, j;
		boolean[] leave = new boolean[people.length];
		Arrays.sort(people);
		for (int i = 0; i < people.length; i++) {
			if (!leave[i]) {
				leave[i] = true;
				for (j = people.length - 1; j > i; j--) {
					if (!leave[j] && people[i] + people[j] <= limit) {
						leave[j] = true;
						break;
					}
				}
				answer++;
			}
		}
		return answer;
	}

	public int solution2(int[] people, int limit) {
		int answer = 0, nextidx;
		int curwei;
		ArrayList<Integer> sorted = new ArrayList<Integer>();
		Arrays.sort(people);
		for (int i : people)
			sorted.add(i);

		while (sorted.size() > 0) {
			answer++;
			curwei = sorted.remove(0);
			nextidx = sorted.size() - 1;
			if (curwei > limit / 2) {
				answer += sorted.size();
				break;
			}
			while (nextidx >= 0) {
				if (curwei + sorted.get(nextidx) <= limit)
					break;
				nextidx--;
			}
			if (nextidx >= 0)
				sorted.remove(nextidx);
		}
		return answer;
	}
}
