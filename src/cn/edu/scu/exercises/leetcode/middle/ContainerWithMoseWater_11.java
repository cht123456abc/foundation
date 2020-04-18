package cn.edu.scu.exercises.leetcode.middle;

/**
 * 11. 盛最多水的容器
 * 给你 n 个非负整数 a1，a2，...，an，每个数代表坐标中的一个点 (i, ai) 。在坐标内画 n 条垂直线，垂直线 i 的两个端点分别为 (i, ai) 和 (i, 0)。找出其中的两条线，使得它们与 x 轴共同构成的容器可以容纳最多的水。
 *
 * 说明：你不能倾斜容器，且 n 的值至少为 2。
 *
 *
 *
 *
 *
 * 图中垂直线代表输入数组 [1,8,6,2,5,4,8,3,7]。在此情况下，容器能够容纳水（表示为蓝色部分）的最大值为 49。
 *
 *
 *
 * 示例：
 *
 * 输入：[1,8,6,2,5,4,8,3,7]
 * 输出：49
 */
public class ContainerWithMoseWater_11 {

    public int maxArea(int[] height) {
        // 左右双指针 每次缩小一边
        int left = 0,right = height.length-1;
        int max = 0;
        while(left < right) {
            int h = 0;
            if (height[left] < height[right]){
                h = height[left];
                max = Math.max(max,h*(right - left));
                while(left < right && height[left] <= h){
                    left++;
                }
            }else{
                h = height[right];
                max = Math.max(max,h*(right - left));
                while(left < right && height[right] <= h){
                    right--;
                }
            }

        }
        return max;
    }
}
