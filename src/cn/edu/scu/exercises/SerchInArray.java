package cn.edu.scu.exercises;

public class SerchInArray {
	public static void main(String[] args) {
		// int[][] arr1 = new int[][]{{1,2}, {2, 3}, {4, 5}};
		int[][] arr1 = { { 1, 2 }, { 3, 4 }, { 5, 6 } };
		for (int i = 0; i < 3; ++i) {
			for (int j = 0; j < 2; ++j)
				System.out.print(arr1[i][j] + " ");
			System.out.println();
		}
		System.out.println(find2(5, arr1));
	}

	public static boolean find(int target, int[][] arr) {
		for(int i=0;i<arr.length;i++) {
			int lo = 0;
			int hi = arr[i].length-1;
			while(lo < hi) {
				int mid = (lo + hi) / 2;
				if(target > arr[i][mid]) {
					lo = mid + 1;
				}else if(target < arr[i][mid]) {
					hi = mid - 1;
				}else {
					return true;
				}
			}
		}
		return false;
	}
	
	public static boolean find2(int target ,int[][] arr) {
		//选中矩阵左下角的数
		int row = arr.length-1;
		int col = 0;
		while(row>=0 && col<arr[row].length) {
			if(target < arr[row][col]) row--;
			else if(target > arr[row][col]) col++;
			else return true;
		}
		return false;
	}
}
