package cn.edu.scu;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Solution {

    public static void main(String[] args) {

        String regex = "(.{3,}).*?\\1";
        String str = "021Abc9Abc1";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(str);
        System.out.println(matcher.find()); // true
    }


}
