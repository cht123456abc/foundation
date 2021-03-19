package cn.edu.scu.exam;

import java.util.ArrayList;
import java.util.List;

public class 二维数组中的平衡线 {

    public static void main(String[] args) {

        int[][] A = new int[][]{{0,0,-1},
                {0,0,1},
                {0,0,0},
                {0,0,-1},
                {0,0,1},
                {0,0,0},
                {0,0,-1},
                {0,0,1}};

//        int[][] A = new int[][]{{0,0,0},
//                                {0,0,1},
//                                {0,0,0},
//                                {0,0,0},
//                                {0,0,1}};

        List res = test(A);
        System.out.println(res);


    }

    public static List<Integer> test(int[][] A) {

        if (A.length == 0) {
            return null;
        }

        List<Integer> lines = new ArrayList<>();

        for (int i = 0; i < A.length; i++) {

            int sum = 0;
            for (int j = 0; j < A[0].length; j++) {
                sum += A[i][j];

            }
            lines.add(sum);
        }

        List<Integer> presum = new ArrayList<>();
        List<Integer> postsum = new ArrayList<>();

        int sum = 0;
        for (Integer line : lines) {
            sum += line;
            presum.add(sum);
        }

        sum = 0;
        for (int i = lines.size()-1; i >= 0; i--) {
            sum += lines.get(i);
            postsum.add(sum);
        }


        List<Integer> res = new ArrayList<>();
        for (int i = 1; i < lines.size()-1; i++) {
            if (presum.get(i-1).equals(postsum.get(A.length-i-2)))
                res.add(i);
        }

        return res;
    }
}
