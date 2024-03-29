package cn.edu.scu.exam;

public class 字符串相减 {

    public static void main(String[] args) {

        System.out.println(reduce("998","888"));
        System.out.println(reduce("998","88"));
        System.out.println(reduce("998","988"));
        System.out.println(reduce("134","55"));
        System.out.println(reduce("1000","9"));
    }

    private static String reduce(String a, String b) {
        char[] as = a.toCharArray();
        char[] bs = b.toCharArray();
        String res = "";
        int flag = 0;
        int i = as.length - 1,j = bs.length-1;
        for (;i >= 0 && j>=0; i--,j--) {

            if (flag == 1) {
                if (as[i] == '0') {
                    as[i] = '9';
                    flag = 1;
                } else {
                    as[i]--;
                }
            }
            if (as[i] < bs[j]) {
                flag = 1;
                res += 10 + as[i] - bs[j];
            } else {
                res += as[i] - bs[j];
            }
        }
        while (i >= 0) {
            if (flag == 1) {
                if (as[i] == '0') {
                    as[i] = '9';
                    flag = 1;
                } else {
                    as[i]--;
                }
            }
            res += as[i];
            i--;
        }
        res = res.charAt(res.length()-1) == '0' ? res.substring(0,res.length()-1) : res;
        StringBuilder ans = new StringBuilder(res);
        return ans.reverse().toString();
    }

}
