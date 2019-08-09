package programmers;

import java.util.ArrayList;
import java.util.Arrays;

public class Lifeboat {

	public static void main(String[] args) {
		System.out.println("ans: " + solution(new int[] { 
				50, 70, 50, 80 }, 100));
	}

	public static int solution(int[] people, int limit) {
		int answer = 0, i, j;
		Arrays.sort(people);
		for (i = 0, j=people.length-1;i<=j ; j--, answer++) {
			if(people[i]+people[j]<=limit)
				i++;
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
