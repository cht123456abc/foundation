package cn.edu.scu.algorithms.exercises.SwordTowardOffer;

public class MatrixPaths_12 {

    public boolean exist(char[][] board, String word) {
        int n = board.length;
        if(n == 0) return false;
        int m = board[0].length;
        if(m == 0) return false;
        char[] wordc = word.toCharArray();
        for(int i = 0;i<n;i++){
            for(int j = 0;j<m;j++){
                if(dfs(board,wordc,0,i,j)) return true;
            }
        }
        return false;
    }

    // dfs + 剪枝
    public boolean dfs(char[][] board,char[] word,int index,int x,int y){
        if(index >= word.length) return true;
        int n = board.length;
        int m = board[0].length;
        if(x < 0 || x >= n || y < 0 || y >= m || board[x][y] != word[index]) return false;
        int[] X = new int[]{-1,0,1,0};
        int[] Y = new int[]{0,1,0,-1};
        boolean res = false;
        char temp = board[x][y];
        board[x][y] = '/';// 将经历过的元素重置
        for(int i = 0;i < 4;i++){
            res = res || dfs(board,word,index+1,X[i]+x,Y[i]+y);
        }
        board[x][y] = temp;
        return res;

    }
}
