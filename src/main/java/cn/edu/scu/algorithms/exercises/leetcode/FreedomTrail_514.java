package cn.edu.scu.algorithms.exercises.leetcode;

import java.util.*;

/**
 * 514. 自由之路
 * 电子游戏“辐射4”中，任务“通向自由”要求玩家到达名为“Freedom Trail Ring”的金属表盘，并使用表盘拼写特定关键词才能开门。
 * <p>
 * 给定一个字符串 ring，表示刻在外环上的编码；给定另一个字符串 key，表示需要拼写的关键词。您需要算出能够拼写关键词中所有字符的最少步数。
 * <p>
 * 最初，ring 的第一个字符与12:00方向对齐。您需要顺时针或逆时针旋转 ring 以使 key 的一个字符在 12:00 方向对齐，然后按下中心按钮，以此逐个拼写完 key 中的所有字符。
 * <p>
 * 旋转 ring 拼出 key 字符 key[i] 的阶段中：
 * <p>
 * 您可以将 ring 顺时针或逆时针旋转一个位置，计为1步。旋转的最终目的是将字符串 ring 的一个字符与 12:00 方向对齐，并且这个字符必须等于字符 key[i] 。
 * 如果字符 key[i] 已经对齐到12:00方向，您需要按下中心按钮进行拼写，这也将算作 1 步。按完之后，您可以开始拼写 key 的下一个字符（下一阶段）, 直至完成所有拼写。
 * 示例：
 * <p>
 * <p>
 * <p>
 * <p>
 * <p>
 * 输入: ring = "godding", key = "gd"
 * 输出: 4
 * 解释:
 * 对于 key 的第一个字符 'g'，已经在正确的位置, 我们只需要1步来拼写这个字符。
 * 对于 key 的第二个字符 'd'，我们需要逆时针旋转 ring "godding" 2步使它变成 "ddinggo"。
 * 当然, 我们还需要1步进行拼写。
 * 因此最终的输出是 4。
 * 提示：
 * <p>
 * ring 和 key 的字符串长度取值范围均为 1 至 100；
 * 两个字符串中都只有小写字符，并且均可能存在重复字符；
 * 字符串 key 一定可以由字符串 ring 旋转拼出。
 */
public class FreedomTrail_514 {

    // dp[i][j] ：指针指向第ring[i]时，完成key[j..]字符(指针从i调到指向key[j])的最小步数
    int[][] dp;
    Map<Character, List<Integer>> map;

    public int findRotateSteps(String ring, String key) {

        int m = ring.length();
        int n = key.length();
        // 初始化备忘录
        dp = new int[m][n];
        // 优化：建立ring的倒排索引
        map = new HashMap<>();
        for (int i = 0; i < ring.length(); i++) {
            char c = ring.charAt(i);
            List<Integer> indexs;
            if (map.containsKey(c)) {
                indexs = map.get(c);
            } else {
                indexs = new ArrayList<>();
                map.put(c, indexs);
            }
            indexs.add(i);
        }

        return dfs(ring, 0, key, 0);
    }

    // 递归+备忘录解法
    private int dfs(String ring, int i, String key, int j) {
        if (j == key.length()) return 0;

        if (dp[i][j] != 0) return dp[i][j];

        // 找到key[j]在ring中的位置k
        int res = Integer.MAX_VALUE;
        for (Integer k : map.get(key.charAt(j))) {
            // 把指针从i顺时针和逆时针调到k时的距离
            int span = Math.abs(i - k);
            int step = Math.min(span, ring.length() - span);
            res = Math.min(res, 1 + step + dfs(ring, k, key, j + 1));
        }
        dp[i][j] = res;
        return res;
    }

    // 递推
    public int findRotateSteps2(String ring, String key) {
        int n = ring.length();
        int m = key.length();
        List<Integer>[] pos = new List[26];// ring的倒排索引
        for (int i = 0; i < 26; i++) {
            pos[i] = new ArrayList<>();
        }
        for (int i = 0; i < n; i++) {
            pos[ring.charAt(i) - 'a'].add(i);
        }
        int[][] dp = new int[m][n];
        for (int i = 0; i < m; i++) {
            Arrays.fill(dp[i], 0x3f3f3f);// 作最大值
        }
        // 初始化
        for (int i : pos[key.charAt(0) - 'a']) {
            dp[0][i] = Math.min(i, n - i) + 1;
        }
        // 状态转移方程及递推顺序
        for (int i = 1; i < m; i++) {
            for (int j : pos[key.charAt(i) - 'a']) {
                for (int k : pos[key.charAt(i - 1) - 'a']) {
                    dp[i][j] = Math.min(dp[i][j], dp[i - 1][k] + Math.min(Math.abs(j - k), n - Math.abs(j - k)) + 1);
                }
            }
        }

        return Arrays.stream(dp[m - 1]).min().getAsInt();
    }
}
