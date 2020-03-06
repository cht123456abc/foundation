package cn.edu.scu.exercises;

import java.util.Scanner;

/**
 * 小Q最近遇到了一个难题：
 * 把一个字符串的大写字母放到字符串的后面，各个字符的相对位置不变，且不能申请额外的空间。 
 * 你能帮帮小Q吗？
 * 
 * 输入用System.in
 * 输出用Syste.out
 * @author cht
 *
 */
public class Solution {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		String sb = scan.nextLine();
		scan.close();
		System.out.println(sb);
		
		char[] chars = sb.toCharArray();
		int n = chars.length;
		for(int i=0;i<n;i++) {
			for(int j=i;j<n-1;j++){
				if(chars[j] > 'A' && chars[j] < 'Z' ) {
					char temp = chars[j + 1];
					chars[j + 1] = chars[j];
					chars[j] = temp;
				} 
			}
		}
	}
}
