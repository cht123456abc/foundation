package cn.edu.scu.exercises;

import java.util.ArrayList;
import java.util.Scanner;

public class Solution1 {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		Integer max = 0;
			String input = scan.nextLine();
			char[] chars = input.toCharArray();
			ArrayList<Character> list = new ArrayList<>();
			int n = chars.length;
			for(int i=0;i<n;i++){
				if((chars[i] >= 'a' && chars[i] <= 'z') || (chars[i] >= 'A' && chars[i] <= 'Z')) {
					if(!list.isEmpty()) {
						StringBuilder sb = new StringBuilder();
						for(Character c : list) {
							sb.append(c);
						}
						Integer num = Integer.valueOf(sb.toString());
						if(num > max) {
							max = num;
						}
						list.clear();
					}
					continue;
				}else {
					list.add(chars[i]);
				}
			}
		scan.close();
		System.out.println(max);
	}
	
}
