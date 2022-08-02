package cn.edu.scu;

import java.util.*;

public class Main {
    public ArrayList<ArrayList<Integer>> permuteUnique(int[] num) {

        Arrays.sort(num);
        boolean[] visited = new boolean[num.length];
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        ArrayList<Integer> path = new ArrayList<>();
        for(int i = 0;i < num.length;i++){
            permute(num,i,visited,path,res);
        }
        return res;
    }

    public void permute(int[] num,int idx,boolean[] visited,ArrayList<Integer> path,ArrayList<ArrayList<Integer>> res){
        if(path.size() == num.length){
            res.add(new ArrayList<>(path));
            return;
        }
        for(int i = 0;i < num.length;i++){
            if(visited[i]) continue;
            if(i > 0 && !visited[i-1] && num[i] == num[i-1]) continue;
            visited[i] = true;
            path.add(num[i]);
            permute(num,i,visited,path,res);
            visited[i] = false;
            path.remove(path.size()-1);
        }

    }
}