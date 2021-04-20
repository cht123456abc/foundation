package cn.edu.scu.exam;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

/**
 * 字符串的排列 相似的企业真题
 * 时间限制：C/C++ 1秒，其他语言2秒 空间限制：C/C++ 64M，其他语言128M 热度指数：770947
 * 本题知识点： 字符串 动态规划
 * 算法知识视频讲解
 * 题目描述
 * 输入一个字符串,按字典序打印出该字符串中字符的所有排列。例如输入字符串abc,则按字典序打印出由字符a,b,c所能排列出来的所有字符串abc,acb,bac,bca,cab和cba。
 * 输入描述:
 * 输入一个字符串,长度不超过9(可能有字符重复),字符只包括大小写字母。
 * 示例1
 * 输入
 * 复制
 * "ab"
 * 返回值
 * 复制
 * ["ab","ba"]
 */
public class 全排列 {

    public static void main(String[] args) {

        String[] res = new 全排列().permutation("iiih");
        for (String re : res) {
            System.out.println(re);

        }
    }

    public String[] permutation(String str) {

        StringBuilder path = new StringBuilder();
        List<String> res = new ArrayList<>();
        boolean[] used = new boolean[str.length()];
        char[] c = str.toCharArray();
        // 排序
        Arrays.sort(c);

        dfs(c,used,path, res);
        return res.toArray(new String[0]);

    }

    public void dfs(char[] s,boolean[] used,StringBuilder path, List<String> res) {
        if(path.length() == used.length){
            res.add(path.toString());
            return;

        }
        for(int i = 0;i < used.length;i++){
            if(used[i]) continue;
            if(i > 0 && s[i-1] == s[i] && !used[i-1]) continue;// 剪枝
            path.append(s[i]);
            used[i] = true;
            dfs(s,used,path,res);
            path.deleteCharAt(path.length()-1);
            used[i] = false;
        }
    }
}
