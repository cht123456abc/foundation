package cn.edu.scu.algorithms.exercises.cracking_the_coding_interview;

import java.util.ArrayList;
import java.util.List;


/**
 * 面试题 08.09. 括号
 * 括号。设计一种算法，打印n对括号的所有合法的（例如，开闭一一对应）组合。
 *
 * 说明：解集不能包含重复的子集。
 *
 * 例如，给出 n = 3，生成结果为：
 *
 * [
 *   "((()))",
 *   "(()())",
 *   "(())()",
 *   "()(())",
 *   "()()()"
 * ]
 */
public class Bracket_0809 {

    // dfs + 剪枝，从空数组开始，每次有左右两个括号的选择
    public List<String> generateParenthesis1(int n) {

        List<String> res = new ArrayList<>();
        dfs(res,n,n,"");
        return res;
    }

    // left 左括号剩余，right 右括号剩余
    public void dfs(List<String> res,int left,int right,String path){
        if(left == 0 && right == 0){
            res.add(path);
            return;
        }
        if(left < 0 || right < left) return;
        dfs(res,left-1,right,path+"(");
        dfs(res,left,right-1,path+")");

    }
}
