package programmers;

public class ChangeWord {

	public static void main(String[] args) {
		System.out.println(solution("hit", "cog", new String[] { "hot", "dog", "cog", "dot", "lot", "log" }));
	}

	static private boolean[] check;

	public static int solution(String begin, String target, String[] words) {
		int listLen = words.length;
		int answer = 0;
		check = new boolean[listLen];

		for (String word : words) {
			if (word.equals(target)) {
				answer = -1;
				break;
			}
		}
		if (answer != 0)
			answer = dfs(begin, target, words);
		return answer;
	}

	public static int dfs(String begin, String target, String[] words) {
		int listLen = words.length, cnt = 0;
		String word;
		for (int i = 0; i < listLen; i++) {
			word = words[i];
			if (!check[i] && checkWord(begin, word)) {
				if (word.equals(target))
					return 1;
				check[i] = true;
				cnt = 1 + dfs(word, target, words);
				check[i] = false;
			}
		}
		return cnt;
	}

	public static boolean checkWord(String begin, String word) {
		int m = 0;
		for (int j = 0; j < begin.length(); j++) {
			if (word.charAt(j) == begin.charAt(j))
				m++;
		}
		return (m == begin.length() - 1);
	}
}
