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

        ArrayList res = new 全排列().Permutation("abac");
        for (Object re : res) {
            System.out.println(re);

        }
    }

    public ArrayList<String> Permutation(String str) {

        // 递归回溯法
        // 用一个map来表示字符集合，并能解决重复字符问题
        Map<String, Integer> map = new ConcurrentHashMap<>();// 需要在遍历集合的时候进行集合的增删操作，这里用ConcurrentHashMap
        for (char c : str.toCharArray()) {
            map.put(String.valueOf(c), map.getOrDefault(String.valueOf(c), 0) + 1);
        }
        LinkedList<String> path = new LinkedList<>();
        ArrayList<String> res = new ArrayList<>();

        // 用dfs来输出整个全排列，全排列为树顶点到所有叶子节点的所有路径集合
        permutation(map, path, res);
        return res;

    }

    public void permutation(Map<String, Integer> map, LinkedList<String> path, List<String> res) {
        if (map.isEmpty()) {
            String re = String.join("", path);
            res.add(re);
            return;
        }
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            String key = entry.getKey();
            Integer value = entry.getValue();
            path.add(key);
            if (value == 1) {
                map.remove(key);
            } else {
                map.put(key, value - 1);
            }
            permutation(map, path, res);
            // 回溯
            path.removeLast();
            map.put(key, map.getOrDefault(key, 0) + 1);
        }
    }

    public String[] permutation(String S) {
        Set<Character> set = new HashSet<>();
        char[] ss = S.toCharArray();
        for(char c : ss){
            set.add(c);
        }
        List<String> res = new ArrayList<>();
        dfs(ss,set,res,new StringBuilder());
        return res.toArray(new String[0]);
    }

    public void dfs(char[] S,Set<Character> set,List<String> res,StringBuilder path){
        if(set.size() == S.length){
            res.add(path.toString());
            return;
        }
        for(char c : S){
            if(set.contains(c)) continue;
            path.append(c);
            set.add(c);
            dfs(S,set,res,path);
            path.deleteCharAt(path.length()-1);
            set.remove(c);
        }
    }
}
