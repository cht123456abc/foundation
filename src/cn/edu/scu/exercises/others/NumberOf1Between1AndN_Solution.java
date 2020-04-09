package cn.edu.scu.exercises.others;

/**
 * 题目描述
 * 求出1~13的整数中1出现的次数,并算出100~1300的整数中1出现的次数？
 * 为此他特别数了一下1~13中包含1的数字有1、10、11、12、13因此共出现6次,但是对于后面问题他就没辙了。
 * ACMer希望你们帮帮他,并把问题更加普遍化,可以很快的求出任意非负整数区间中1出现的次数。
 * @author cht
 */
public class NumberOf1Between1AndN_Solution {
	/**
	 * 思路:分位数求区间数的数字1的总和.每个位数要判断<1,=1,>1三种情况；
	 * 当该位数数字
	 * <1时:左边所有位乘上该位位数
	 * =1时：左边所有位乘上该位位数+右边所有位组成的数+1
	 * >1时:（左边所有位+1）* 该位位数
	 * 拿4127作为例子，每一位上的数字1的总数：
	 * 个位：(412+1)*1
	 * 十位：(41+1)*10
	 * 百位:4*100+(27+1)
	 * 千位:(0+1)*1000
	 * @param n
	 * @return
	 */
	public int NumberOf1Between1AndN_Solution(int n) {
	    int right;//该位右边所有位所组成的数
	    int left;//该位左边所有位所组成的数
	    int cur;//该位的数字
	    int sum = 0;
	    //从低位往高位遍历,i为位数
	    for(int i=1;n/i>0;i*=10){
	    	left = n / (i*10);
	    	right = n % i;
	    	cur = n / i % 10;// "/" 除相当于留下小数点左边的数， "%" 求余相当于留下小数点右边的数
	    	if(cur < 1) {
	    		sum += left * i;
	    	}else if (cur == 1) {
	    		sum += left * i + right + 1;
	    	}else {
	    		sum += (left + 1) * i;
	    	}
	    }
	    return sum;
    }
	
	public static void main(String[] args) {
		System.out.println(new NumberOf1Between1AndN_Solution().NumberOf1Between1AndN_Solution(23));
	}
}
