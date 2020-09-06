package cn.edu.scu.algorithms.math;

/**
 * 204. 计数质数
 * 统计所有小于非负整数 n 的质数的数量。
 *
 * 示例:
 *
 * 输入: 10
 * 输出: 4
 * 解释: 小于 10 的质数一共有 4 个, 它们是 2, 3, 5, 7 。
 */
public class CountPrime_204 {

    // 厄拉多塞筛法
    public int countPrimes(int n) {
        if (n <= 2) return 0;
        boolean[] notPrime = new boolean[n];
        int count = 0;
        for (int i = 2; i*i < n; i++) {
            if (!notPrime[i]) {
                for (int j = i*i; j < n ; j += i) {
                    if (!notPrime[j]) {
                        notPrime[j] = true;// i的平方以及后面的i的倍数都设置为非质数
                        count++;// 对这些非质数计数
                    }
                }
            }
        }
        return n - count - 2;
    }
}
