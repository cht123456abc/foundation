import java.util.Scanner;

// 注意类名必须为 Main, 不要有任何 package xxx 信息
public class Main {
    public int majorityElement(int[] nums) {

        // 堆栈思想，不一样的数相消，众数始终会多一个以上
        int count = 1;
        int n = nums.length;
        int major = nums[0];
        for (int i = 1; i < n; i++) {
            if (nums[i] == major) {
                count++;
            } else if (count == 0) {
                major = nums[i];
            } else {
                count--;
            }
        }
        return major;
    }

    public static void main(String[] args) {

    }
}