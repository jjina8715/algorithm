package practice;

public class RotationMatrix {
	public static void main(String[] args) {
		int[][] arr = { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 } };
		int[][] arr1 = { { 1, 2, 3, 4, 5 }, { 6, 7, 8, 9, 10 }, { 11, 12, 13, 14, 15 }, { 16, 17, 18, 19, 20 },
				{ 21, 22, 23, 24, 25 } };
		int[][] arr2 = new int[10][10];
		int count = 1;
		for (int i = 0; i < arr2.length; i++) {
			for (int j = 0; j < arr2[i].length; j++) {
				arr2[i][j] = count++;
			}
		}

		// rotateMatrix testCase
		printMatrix(arr);
		printMatrix(rotateMatrix(arr));
		printMatrix(arr1);
		printMatrix(rotateMatrix(arr1));
		printMatrix(arr2);
		printMatrix(rotateMatrix(arr2));
		
		// rotateMatrix1 testCase

		 printMatrix(arr); 
		 printMatrix(rotateMatrix1(arr)); 
		 printMatrix(arr1);
		 printMatrix(rotateMatrix1(arr1)); 
		 printMatrix(arr2);
		 printMatrix(rotateMatrix1(arr2));

	}

	// 정사각형 배열을 시계방향으로 한칸씩 이동
	// 여기를 구현하세요 :)
	public static int[][] rotateMatrix(int[][] arr) {
		int mCnt = arr.length, x = 0, y = 0;
		int[][] result = new int[mCnt][mCnt];
		if(mCnt%2==1)
			result[mCnt/2][mCnt/2] = arr[mCnt/2][(mCnt)/2];
		mCnt--;
		while (mCnt > 0) {
			for (int i = 0; i < mCnt; i++)
				result[x][y + 1] = arr[x][y++];

			for (int i = 0; i < mCnt; i++)
				result[x + 1][y] = arr[x++][y];

			for (int i = 0; i < mCnt; i++)
				result[x][y - 1] = arr[x][y--];

			for (int i = 0; i < mCnt; i++)
				result[x - 1][y] = arr[x--][y];

			y++;
			x++;
			mCnt -= 2;
		}
		return result;
	}

	// 정사각형 배열의 홀수번째 줄은 반시계방향, 짝수번째 줄은 시계방향으로 한칸씩 이동
	// 여기를 구현하세요 :)
	public static int[][] rotateMatrix1(int[][] arr) {
		int mCnt = arr.length, x = 0, y = 0;
		int[][] result = new int[mCnt][mCnt];
		if(mCnt%2==1)
			result[mCnt/2][mCnt/2] = arr[mCnt/2][(mCnt)/2];
		mCnt--;
		while (mCnt > 0) {
			if (x % 2 == 0) {
				for (int i = 0; i < mCnt; i++)
					result[x][y + 1] = arr[x][y++];

				for (int i = 0; i < mCnt; i++)
					result[x + 1][y] = arr[x++][y];

				for (int i = 0; i < mCnt; i++)
					result[x][y - 1] = arr[x][y--];

				for (int i = 0; i < mCnt; i++)
					result[x - 1][y] = arr[x--][y];

				y++;
				x++;
			}
			else {
				for (int i = 0; i < mCnt; i++)
					result[x + 1][y] = arr[x++][y];

				for (int i = 0; i < mCnt; i++)
					result[x][y + 1] = arr[x][y++];

				for (int i = 0; i < mCnt; i++)
					result[x - 1][y] = arr[x--][y];

				for (int i = 0; i < mCnt; i++)
					result[x][y - 1] = arr[x][y--];

				y++;
				x++;
			}
			mCnt -= 2;
		}
		return result;
	}

	public static void printMatrix(int[][] arr) {
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr[i].length; j++) {
				if (j > 0) {
					System.out.print(" ");
					if (arr[i][j] < 10)
						System.out.print(" ");
				} else if (j == 0 && arr[i][j] < 10)
					System.out.print(" ");
				System.out.print(arr[i][j]);
			}
			System.out.println();
		}
		System.out.println();
	}
}
