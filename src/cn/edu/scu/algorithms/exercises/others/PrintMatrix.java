package cn.edu.scu.algorithms.exercises.others;

import java.util.ArrayList;
import java.util.Arrays;

public class PrintMatrix {
	public static void main(String[] args) {
		int[][] a = new int[][]{{1,2,3,4,5},{5,6,7,8,9},{9,10,11,12,13},{14,15,16,17,18}};
		System.out.println(Arrays.toString(a[0]));
		System.out.println(Arrays.toString(a[1]));
		System.out.println(Arrays.toString(a[2]));
		System.out.println(Arrays.toString(a[3]));
		System.out.println(printMatrix(a));
	}
	
	 public static ArrayList<Integer> printMatrix(int [][] matrix) {
		 	int imax = matrix.length;
		 	int imin = 0;
		 	int jmax = matrix[0].length;
		 	int jmin = 0;
		 	
		 	ArrayList<Integer> result = new ArrayList<Integer>();
		 	//只有1行
		 	if(imax == 1) {
		 		for(int j=0;j<jmax;j++) {
		 			result.add(matrix[0][j]);
		 		}
		 		return result;
		 	//只有1列
		 	}else if(jmax == 1) {
		 		for(int i=0;i<imax;i++) {
		 			result.add(matrix[i][0]);
		 		}
		 		return result;
		 	//二维
		 	}else {
		 		//设定i,j指针代表二维数组索引
		 		int i=0;
		 		int j=0;
		 		//标志位，遍历过的值为1
		 		int[][] flags = new int[imax][jmax];
		 		//循环，向右，向下，向左，向上；
		 		while(true) {
		 			if(imin >= imax || jmin >= jmax) break;
		 			imin++;
		 			if(flags[i][j] == 1) break;
		 			while(j<jmax) {
		 				flags[i][j] = 1;
		 				result.add(matrix[i][j++]);
		 			}
		 			j--;
		 			i++;
		 			jmax--;
		 			if(flags[i][j] == 1) break;
		 			while(i<imax) {
		 				flags[i][j] = 1;
		 				result.add(matrix[i++][j]);
		 			}
		 			i--;
		 			j--;
		 			imax--;
		 			if(flags[i][j] == 1) break;
		 			while(j>=jmin) {
		 				flags[i][j] = 1;
		 				result.add(matrix[i][j--]);
		 			}
		 			j++;
		 			i--;
		 			jmin++;
		 			if(flags[i][j] == 1) break;
		 			while(i>=imin) {
		 				flags[i][j] = 1;
		 				result.add(matrix[i--][j]);
		 			}
		 			i++;
		 			j++;
		 		}
		 	}
	    	return result;
	    }
}
