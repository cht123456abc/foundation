package cn.edu.scu.test;

import cn.edu.scu.algorithms.tree.TreeNode;

import java.util.HashMap;
import java.util.Map;

public class TestMap {

    public static void main(String[] args) {
        Map<TreeNode,Integer> map =new HashMap<>();
        TreeNode t1  =new TreeNode(1);
        TreeNode t2  =new TreeNode(1);
        System.out.println(t1.equals(t2));


    }
}
