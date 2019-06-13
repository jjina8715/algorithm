package practice;

public class BoggleGame {

	public static void main(String[] args) {
		char[][] board= {
				 {'T', 'W', 'I', 'C', 'E'},
			     {'I', 'S', 'C', 'U', 'B'},
			     {'L', 'E', 'M', 'O', 'E'},
			     {'U', 'F', 'M', 'O', 'A'},
			     {'S', 'O', 'I', 'T', 'U'}
		};
		System.out.println(search(board, new String("TWICE"), 0));
		System.out.println(search(board, new String("IS"), 0));
		System.out.println(search(board, new String("SO"), 0));
		System.out.println(search(board, new String("BEATIFUL"), 0));
	}
	public static boolean Boggle(char[][] board, String word, int wIdx, ) {
			
		return true;
	}
	public static boolean find()
}
