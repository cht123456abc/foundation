package cn.edu.scu.utils;

import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MatchUtil
{
    /**
     * 返回匹配到字符串
     * @param str
     * @param regex
     * @return
     */
    public static String match(String str, String regex)
    {
        String result = null;
        Pattern p = Pattern.compile(regex);
        Matcher m = p.matcher(str);

        while (m.find())
        {
            result = m.group(0);
        }
        return result;
    }

    /**
     * 返回匹配到字符串数组
     * @param str
     * @param regex
     * @return
     */
    public static List<String> multipleMatch(String str, String regex)
    {
        List<String> result = new LinkedList<String>();
        Pattern p = Pattern.compile(regex);
        Matcher m = p.matcher(str);


        while (m.find())
        {
            result.add(m.group());
        }
        return result;
    }


    /**
     * 返回匹配到字符串数组
     * @param str
     * @param regex
     * @return
     */
    public static List<String> multipleMatchN(String str, String regex, Integer index)
    {
        List<String> result = new LinkedList<String>();
        Pattern p = Pattern.compile(regex);
        Matcher m = p.matcher(str);


        while (m.find())
        {
            result.add(m.group(index));
        }
        return result;
    }

    /**
     * 返回匹配到的第二组字符串
     * @param str
     * @param regex
     * @return
     */
    public static String matchColumn(String str, String regex)
    {
        String result = null;
        Pattern p = Pattern.compile(regex);
        Matcher m = p.matcher(str);

        while (m.find())
        {
            if(m.groupCount() > 0)
            {
                result = m.group(1);
                break;
            }
        }
        return result;
    }

    /**
     * 返回匹配到的第N组字符串
     * @param str
     * @param regex
     * @param index
     * @return
     */
    public static String matchN(String str, String regex, Integer index)
    {
        String result = null;
        Pattern p = Pattern.compile(regex);
        Matcher m = p.matcher(str); // 获取 matcher 对象

        while (m.find())
        {
            result = m.group(index);
        }
        return result;
    }


    /**
     * 将字符串的首字母转大写
     * @param str 需要转换的字符串
     * @return
     */
    private static String upperFirstLetter(String str) {
        // 进行字母的ascii编码前移，效率要高于截取字符串进行转换的操作
        String firstLetter = str.substring(0, 1);
        return firstLetter.toUpperCase() + str.substring(1, str.length());
    }

    /**
     * 是否能匹配到
     * @param str
     * @param regex
     * @return
     */
    public static boolean isMatch(String str, String regex)
    {
        Pattern p = Pattern.compile(regex);
        Matcher m = p.matcher(str);


        while (m.find())
        {
            return true;
        }
        return false;
    }

    // 给文件内容加上行号
    public static String addLineNumber(String content){
        if (content == null || content.isEmpty()) throw new NullPointerException("文件内容为空");
        String[] lines = content.split("\n");
        int n = lines.length;
        for (int i = 0;i<n;i++){
            lines[i] = i+1 + lines[i];
        }
        return String.join("\n", lines);
    }

    // 抽离gradle文件某个属性里面的内容
    public static String subContent(String content,String property){
        int start = content.indexOf(property);
        if (start < 0) throw new RuntimeException("没有找到该属性");
        int n = content.length();
        int count = 0;
        boolean first = true;
        int end = -1;
        for(int i = start;i < n;i++){
            char c = content.charAt(i);
            if('{' == c){
                count++;
                first = false;
            }else if('}'== c){
                count--;
            }
            if (!first && count == 0) {
                end = i;
                return content.substring(start,end+1);
            }
        }
        throw new RuntimeException("错误");
    }

}
