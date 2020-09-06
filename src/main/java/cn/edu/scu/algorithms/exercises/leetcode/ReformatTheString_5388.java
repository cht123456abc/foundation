package cn.edu.scu.algorithms.exercises.leetcode;



/**
 * 输入：s = "a0b1c2"
 * 输出："0a1b2c"
 * 解释："0a1b2c" 中任意两个相邻字符的类型都不同。 "a0b1c2", "0a1b2c", "0c2a1b" 也是满足题目要求的答案。
 * 示例 2：
 *
 * 输入：s = "leetcode"
 * 输出：""
 * 解释："leetcode" 中只有字母，所以无法满足重新格式化的条件。
 * 示例 3：
 *
 * 输入：s = "1229857369"
 * 输出：""
 * 解释："1229857369" 中只有数字，所以无法满足重新格式化的条件。
 * 示例 4：
 *
 * 输入：s = "covid2019"
 * 输出："c2o0v1i9d"
 * 示例 5：
 *
 * 输入：s = "ab123"
 * 输出："1a2b3"
 *
 *
 * 提示：
 *
 * 1 <= s.length <= 500
 * s 仅由小写英文字母和/或数字组成。
 */
public class ReformatTheString_5388 {

    public String reformat(String s) {
        StringBuilder res = new StringBuilder();
        int n = s.length();
        if (n <= 1) return s;
        int i = 0,j = 0,k = 0;
        int letter_cnt = 0,digit_cnt = 0;
        for(;k < n;k++){
            while (i < n && !Character.isLetter(s.charAt(i))) i++;
            while (j < n && !Character.isDigit(s.charAt(j))) j++;
            if(i < n && k%2==0){
                res.append(s.charAt(i));
                i++;
            }
            if(j < n && k%2==1){
                res.append(s.charAt(j));
                j++;
            }
            if (Character.isLetter(s.charAt(k))) letter_cnt++;
            else digit_cnt++;
        }
        if (Math.abs(digit_cnt-letter_cnt) >=2 ) return "";
        // 如果多的一个数是数字，就加在最前面
        if(j<n) {
            res.insert(0,s.charAt(j));
        }
        return res.toString();
    }

    public static void main(String[] args) {
        String a = "123";
        System.out.println(new ReformatTheString_5388().reformat(a));
    }
}
