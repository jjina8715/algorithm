package programmers;

public class LargeNumber {

	public static void main(String[] args) {
		System.out.println("ans: " + solution("1924", 2));
	}

	public static String solution(String number, int k) {
		String answer = "";
		int length = number.length(), len = length - k, idx = 0, str = 0, end = k + 1;
		char[] ans = new char[len];
		while (idx < len) {
			ans[idx] = number.charAt(str);
			if (end > length)
				end = length;
			for (int i = str + 1; i < end; i++) {
				if (ans[idx] == 9)
					break;
				if (number.charAt(i) > ans[idx]) {
					str = i;
					ans[idx] = number.charAt(i);
				}
			}
			idx++;
			str++;
			end++;
		}

		answer = String.copyValueOf(ans);
		return answer;
	}
}
