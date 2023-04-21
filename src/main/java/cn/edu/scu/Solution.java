package cn.edu.scu;

public class Solution {
    public String gcdOfStrings(String str1, String str2) {
        if(!str1.concat(str2).equals(str2.concat(str1))) return "";

        return str1.substring(0,gcd(str1.length(),str2.length()));
    }

    // 求最大公因数gcd
    private int gcd(int a,int b){
        int remainder = a % b;
        while(remainder > 0){
            a = b;
            b = remainder;
            remainder = a % b;
        }
        return b;

    }

    public static void main(String[] args) {
        new Solution().gcdOfStrings("ABCABC", "ABC");
    }
}
