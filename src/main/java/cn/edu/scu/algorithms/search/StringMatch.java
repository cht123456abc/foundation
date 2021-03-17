package cn.edu.scu.algorithms.search;

public class StringMatch {

    /**
     * O(T) = O(n*m)
     * 在s中用t来匹配字串，返回匹配的第一个字符在s中的位置。
     * @param s 原字符串
     * @param t 匹配字符串
     * @return
     */
    private int naiveSerach(String s, String t) {
        int i=0,j=0;
        while (i < s.length() && j < t.length()) {
            if (s.charAt(i) == t.charAt(j)) {
                i++;
                j++;
            } else {
                i = i-j+1;// i要回退
                j=0;// j也重新回到原点
            }
        }
        if (j == t.length()) {
            return i - j;
        } else {
            return -1;
        }
    }

    /**
     * O(T) = O(n+m)
     */
    private int KMP(String s, String t,int[] next) {
        int i = 0,j = 0;
        while (i < s.length() && j < t.length()) {
            if (j == -1 || s.charAt(i) == t.charAt(j)) {
                i++;
                j++;
            } else {
                j = next[j];// 只有j回退
            }
        }
        if (j == t.length()) {
            return i - j;
        } else {
            return -1;
        }
    }

    // 最大公共前后缀得出部分匹配表
    // 由部分匹配表（Partial Match Table）向右移动一位，并且第一个位置置为-1得来的。
    private int[] getNext(String t) {
        int[] next = new int[t.length()+1];
        int i=0,j=-1;
        next[0] = -1;
        while (i < t.length()) {
            if (j == -1 || t.charAt(i) == t.charAt(j)) {
                i++;
                j++;
                next[i] = j;
            } else {
                j = next[j];
            }
        }
        return next;
    }

    public static void main(String[] args) {
        String s = "hello";
        String t = "lo";
        StringMatch stringMatch = new StringMatch();
        int index = stringMatch.naiveSerach(s, t);
        int[] next = stringMatch.getNext(t);
        int index1 = stringMatch.KMP(s,t,next);
        System.out.println(index);
        System.out.println(index1);
    }
}
