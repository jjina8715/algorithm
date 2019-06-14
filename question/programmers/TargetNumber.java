package programmers;

public class TargetNumber {

	public static void main(String[] args) {
		int[] numbers = { 1, 2, 3 };
		System.out.println(solution(numbers, 2));
	}

	public static int solution(int[] numbers, int target) {
		int answer = 0;
		answer += bfs(numbers, target, 0, 0, 1);
		answer += bfs(numbers, target, 0, 0, -1);
		return answer;
	}

	public static int bfs(int[] numbers, int target, int idx, int sum, int flag) {
		int answer = 0;
		sum += numbers[idx] * flag;
		if (idx == numbers.length-1) {
			if (sum == target)
				return 1;
		} else {
			idx++;
			answer += bfs(numbers, target, idx, sum, 1);
			answer += bfs(numbers, target, idx, sum, -1);
		}
		return answer;
	}
}
