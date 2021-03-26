package cn.edu.scu.exam;

import java.util.*;
import java.util.stream.Collectors;

public class 三元和 {

    public static void main(String[] args) {

        int[] a = new int[]{-2, 0, 1, 1, 2};
        System.out.println(new 三元和().threeSum(a));


    }

    public ArrayList<ArrayList<Integer>> threeSum(int[] num) {
        int n = num.length;
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        for(int i = 0;i < n-2;i++){
            Map<Integer,int[]> map = new HashMap<>();
            int a = num[i];
            for(int j = i+1;j < n;j++){
                int b = num[j];
                if(map.containsKey(b)){
                    ArrayList<Integer> re = new ArrayList<>();
                    re.add(map.get(b)[0]);
                    re.add(map.get(b)[1]);
                    re.add(b);
                    Collections.sort(re);
                    res.add(re);
                    System.out.println(re);
                }else{
                    map.put(-a-b,new int[]{a,b});
                }
            }
        }
        // 去重
        return (ArrayList<ArrayList<Integer>>) res.stream().distinct().sorted((o1, o2) -> {
            for (int i = 0 ;i < o1.size();i++){
                int res1 = o1.get(i) - o2.get(i);
                if (res1 == 0) continue;
                return res1;
            }
            return 0;
        }).collect(Collectors.toList());
    }
}
