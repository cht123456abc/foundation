package cn.edu.scu.exam;

import java.util.*;


/**
 * 描述
 * 现在有一个只包含数字的字符串，将该字符串转化成IP地址的形式，返回所有可能的情况。
 * 例如：
 * 给出的字符串为"25525522135",
 * 返回["255.255.22.135", "255.255.221.35"]. (顺序没有关系)
 *
 * 数据范围：字符串长度 0 \le n \le 120≤n≤12
 * 要求：空间复杂度 O(n!)O(n!),时间复杂度 O(n!)O(n!)
 *
 * 注意：ip地址是由四段数字组成的数字序列，格式如 "x.x.x.x"，其中 x 的范围应当是 [0,255]。
 *
 * 示例1
 * 输入：
 * "25525522135"
 * 复制
 * 返回值：
 * ["255.255.22.135","255.255.221.35"]
 * 复制
 * 示例2
 * 输入：
 * "1111"
 * 复制
 * 返回值：
 * ["1.1.1.1"]
 * 复制
 * 示例3
 * 输入：
 * "000256"
 * 复制
 * 返回值：
 * []
 */
public class 数字字符串转化为ip地址 {


    List<String> ip = new ArrayList<>();
    List<String> res = new ArrayList<>();

    public ArrayList<String> restoreIpAddresses (String s) {
        // 形成四个部分，才能算完整的ip地址
        dfs(s, 0);
        return (ArrayList<String>) res;
    }

    // 递归地形成ip地址的四个部分的一部分
    private void dfs(String s, int index) {
        // 出口
        if (ip.size() == 4) {
            if (index == s.length()) {
                // 形成一条结果
                res.add(String.join(".", ip));
            }
            return;
        }

        StringBuilder temp = new StringBuilder();
        // 形成一段地址
        for (int i = index; i < index + 3 && i < s.length(); i++) {
            char c = s.charAt(i);
            temp.append(c);
            int oneInt = Integer.parseInt(temp.toString());
            if (oneInt < 256 && (temp.toString().length() == 1 || temp.toString().charAt(0) != '0')) {
                // 加入ip地址
                ip.add(temp.toString());
                // 递归形成其余ip段
                dfs(s, i + 1);
                // 回溯
                ip.remove(ip.size() - 1);
            }
        }
    }


    public static void main(String[] args) {
        数字字符串转化为ip地址 main = new 数字字符串转化为ip地址();
        main.restoreIpAddresses("25525522135");
    }
}