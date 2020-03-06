package cn.edu.scu.exercises;

import java.util.HashMap;

/**
 * 题目描述
 * 数组中有一个数字出现的次数超过数组长度的一半，请找出这个数字。例如输入一个长度为9的数组{1,2,3,2,2,2,5,4,2}。由于数字2在数组中出现了5次，超过数组长度的一半，因此输出2。如果不存在则输出0。
 * 
 * @author cht
 *
 */
public class MoreThanHalfNum_Solution {
	public int MoreThanHalfNum_Solution(int[] array) {
		HashMap<Integer,Integer> count = new HashMap<Integer,Integer>(); 
		int n = array.length;
		for (int i = 0; i < n; i++) {
			if(count.containsKey(array[i])) {
				count.put(array[i], count.get(array[i])+1);
			}else{
				count.put(array[i], 1);
			}
			if(count.get(array[i]) > n/2) return array[i];
		}
		return 0;
	}
}
