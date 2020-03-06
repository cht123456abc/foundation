package cn.edu.scu.exercises;

/**
 * 题目描述
 * HZ偶尔会拿些专业问题来忽悠那些非计算机专业的同学。
 * 今天测试组开完会后,他又发话了:在古老的一维模式识别中,常常需要计算连续子向量的最大和,当向量全为正数的时候,问题很好解决。
 * 但是,如果向量中包含负数,是否应该包含某个负数,并期望旁边的正数会弥补它呢？例如:{6,-3,-2,7,-15,1,2,2},连续子向量的最大和为8(从第0个开始,到第3个为止)。
 * 你会不会被他忽悠住？(子向量的长度至少是1)
 * 
 * @author cht
 *
 */
public class FindGreatestSumOfSubArray {
	
	//动态规划
//	使用动态规划
//	F（i）：以array[i]为末尾元素的子数组的和的最大值，子数组的元素的相对位置不变
//	F（i）=max（F（i-1）+array[i] ， array[i]）
//	res：所有子数组的和的最大值
//	res=max（res，F（i））
//
//	如数组[6, -3, -2, 7, -15, 1, 2, 2]
//	初始状态：
//	    F（0）=6
//	    res=6
//	i=1：
//	    F（1）=max（F（0）-3，-3）=max（6-3，3）=3
//	    res=max（F（1），res）=max（3，6）=6
//	i=2：
//	    F（2）=max（F（1）-2，-2）=max（3-2，-2）=1
//	    res=max（F（2），res）=max（1，6）=6
//	i=3：
//	    F（3）=max（F（2）+7，7）=max（1+7，7）=8
//	    res=max（F（2），res）=max（8，6）=8
//	i=4：
//	    F（4）=max（F（3）-15，-15）=max（8-15，-15）=-7
//	    res=max（F（4），res）=max（-7，8）=8
//	以此类推
//	最终res的值为8
	 public int FindGreatestSumOfSubArray(int[] array) {
	        int res = array[0];
	        int max = array[0];
	        int n = array.length;
	        for(int i = 1;i<n;i++) {
	            max = (max + array[i]) > array[i] ? (max + array[i]) : array[i];
	            res = res > max ? res : max;
	        }
	        return res;
	    }
//方法一
//    public int FindGreatestSumOfSubArray(int[] array) {
//        int n = array.length;
//        int sum = 0;
//        int maxSum = 0;
//        int flag = 0;
//        int maxNum = array[0];
//        
//        for(int i=0;i<n;i++) {
//            if(maxNum < array[i]) maxNum = array[i];
//        	if(array[i] <= 0) continue;
//        	for(int j=i;j<n;j++) {
//        		sum += array[j];
//        		if(sum > maxSum) {
//        			maxSum = sum;
//        		}
//        	}
//            sum = 0;
//            flag = 1;
//        }
//        if(flag == 0) return maxNum;
//        return maxSum;
//    }
}
