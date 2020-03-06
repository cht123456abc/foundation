package cn.edu.scu.exercises;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ReplaceSpace {
	public static void main(String[] args) {
		StringBuffer str = new StringBuffer("aa bb  cc   dd		ff");
		System.out.println(replaceSpace(str));
		System.out.println("aaa\taaa");
	}
	public static String replaceSpace(StringBuffer str) {
//		String regex = "\\p{Blank}";
//		String regex = "[ \t]";
		String regex = " ";
		Pattern pattern = Pattern.compile(regex );
		//用法一：分离
		String[] result = pattern.split(str);
		for(String s : result) {
			System.out.println(s);
		}
		//用法二：匹配
		Matcher matcher = pattern.matcher(str);
		System.out.println(matcher.matches());
		System.out.println(matcher.lookingAt());
		while(matcher.find()) {
			System.out.println("start:"+matcher.start());
			System.out.println("end:"+matcher.end());
		}
		String output = matcher.replaceAll("%20");
		return output;
	}
}
