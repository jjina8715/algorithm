package practice;


public class ChangeWord {

	public static void main(String[] args) {
		System.out.println(solution("hit", "cog", new String[] {"hot", "dot", "dog", "lot", "log", "cog"}));
	}
	static private boolean[] check;
	 public static int solution(String begin, String target, String[] words) {
	        int listLen = words.length;
	        int answer = listLen, cnt = 0;
	        for(int i = 0; i<listLen;i++) {
				check = new boolean[listLen];
				if(checkWord(begin, words[i])) {
					check[i] = true;
					cnt =1+ dfs(words[i], target, words);
				}
				if(answer>cnt) answer = cnt;
			}
	        return answer;
	}
	public static int dfs(String begin, String target, String[] words) {
		int listLen = words.length, cnt = 0;
		String word;
		for(int i = 0; i<listLen;i++) {
			word = words[i];
			if(!check[i]&&checkWord(begin, word)) {
				if(word.equals(target))
					return 1;
				check[i] = true;
				cnt = 1 + dfs(word, target, words);
			}
		}
		return cnt;
	}
	public static boolean checkWord(String begin, String word) {
		int m = 0;
		for(int j = 0; j<begin.length();j++) {
			if(word.charAt(j)==begin.charAt(j))
				m++;
		}
		return (m==begin.length()-1);
	}
}
