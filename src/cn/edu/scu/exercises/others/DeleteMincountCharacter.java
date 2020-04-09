package cn.edu.scu.exercises.others;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

public class DeleteMincountCharacter {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		System.out.println("输入字符串：");
		String input = in.nextLine();
		System.out.println("删除完数目最少的字母后：");
		String output = deleteMin(input);
		System.out.println(output);
	}

	private static String deleteMin(String input) {
		StringBuilder sb = new StringBuilder(input);
		char[] chars = input.toCharArray();
		Map<Character,Integer> map = new LinkedHashMap<Character,Integer>();
		for(int i=0;i<chars.length;i++) {
			if(!map.containsKey(chars[i])) {
				map.put(chars[i], 1);
			}else {
				int count = map.get(chars[i]) + 1;
				map.put(chars[i], count);
			}
		}
		System.out.println(map);
		//找出最小的数值
		Integer min = map.entrySet().stream().sorted((a,b) -> a.getValue().compareTo(b.getValue())).findFirst().map(e -> e.getValue()).get();
		System.out.println(min);
		//找到最小数值的字母
		Character[] list =map.entrySet().stream().filter(e -> e.getValue()==min).map(m -> m.getKey()).collect(Collectors.toList()).toArray(new Character[0]);
		System.out.println(Arrays.toString(list));
		//删除最小数值的字母
		String regex = "[";
		for(int i=0;i<list.length;i++) {
			regex += list[i];
		}
		regex += "]";
		System.out.println(regex);
		String output = input.replaceAll(regex, "");
		return output;
	}
	
	/*class CharacterCount {
		private char character;
		private int count;
		public CharacterCount(char character){
			this.character = character;
			this.count = 1;
		}
	}*/
}
