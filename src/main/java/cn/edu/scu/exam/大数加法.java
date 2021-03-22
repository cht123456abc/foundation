package cn.edu.scu.exam;

/**
 * 大数加法
 * 时间限制：C/C++ 1秒，其他语言2秒 空间限制：C/C++ 256M，其他语言512M 热度指数：31030
 * 本题知识点： 字符串 模拟
 *  算法知识视频讲解
 * 题目描述
 * 以字符串的形式读入两个数字，编写一个函数计算它们的和，以字符串形式返回。
 * （字符串长度不大于100000，保证字符串仅由'0'~'9'这10种字符组成）
 * 示例1
 * 输入
 * 复制
 * "1","99"
 * 返回值
 * 复制
 * "100"
 * 说明
 */
public class 大数加法 {

    public static void main(String[] args) {
        System.out.println(solve("1000", "99"));
    }

    public static String solve (String s, String t) {
        //
        StringBuilder sb = new StringBuilder();
        int k = s.length()-1;
        int p = t.length()-1;
        int carry = 0;
        while (k >= 0 || p >= 0) {
            int a = 0;
            int b = 0;
            if (k >= 0) a = Integer.parseInt(String.valueOf(s.charAt(k--)));
            if( p >= 0) b = Integer.parseInt(String.valueOf(t.charAt(p--)));

            int bit = a + b + carry;
            if (bit >= 10) {
                carry = 1;
                bit = bit - 10;
            } else {
                carry = 0;
            }
            sb.append(bit);
        }
        if(carry == 1) sb.append(1);
        return sb.reverse().toString();

    }

}
