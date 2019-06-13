package practice;

public class BoggleGame {

	final static int[] indexX = { -1, -1, -1, 0, 0, 1, 1, 1};
	final static int[] indexY = { -1, 0, 1, -1, 1, -1, 0, 1};
	final static int INDEX_LENGTH = 8, COL_LENTGH = 5, ROW_LENGTH = 5;
	final static char[][] board= {
			 {'T', 'W', 'I', 'C', 'E'},
		     {'I', 'S', 'C', 'U', 'B'},
		     {'L', 'E', 'M', 'O', 'E'},
		     {'U', 'F', 'M', 'O', 'A'},
		     {'S', 'O', 'I', 'T', 'U'}
	};
	public static void main(String[] args) {
		
		System.out.println(hasWord(new String("TWICE")));
		System.out.println(hasWord(new String("IS")));
		System.out.println(hasWord(new String("SO")));
		System.out.println(hasWord(new String("BEATIFUL")));
	}
	public static boolean hasWord(String word) {
			boolean result = false;
			
			for(int i =0; i<board.length;i++) {
				for(int j = 0; j<board[i].length;j++) {
					if(board[i][j] == word.charAt(0)) {
						if(isWord(word, i, j, 0))
							result=true;
					}
				}
			}
		return result;
	}
	public static boolean isWord(String word, int x, int y, int  widx) {
		int newx, newy;
		if(++widx==word.length())
			return true;
		for(int i = 0; i<INDEX_LENGTH;i++) {
			newx = x+indexX[i];
			newy = y+indexY[i];
			if(newx>=0&&newx<ROW_LENGTH&&newy>=0&&newy<COL_LENTGH)
				if(word.charAt(widx)==board[newx][newy]) {
					if(isWord(word, newx, newy, widx))
						return true;
				}
		}
		return false;
	}
}
