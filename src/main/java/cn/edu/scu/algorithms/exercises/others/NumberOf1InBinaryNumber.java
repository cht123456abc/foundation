package cn.edu.scu.algorithms.exercises.others;

public class NumberOf1InBinaryNumber {
	//查看二进制数的为1的个数统计，思想:用1来循环左移与该数做位与比较，结果不为0则该位置上有1，count++
    public static int NumberOf1(int n) {
    	int count = 0;
    	int flag = 1;
    	while(flag != 0) {
    		if((n & flag) != 0) count++;
    		flag <<= 1;
    	}
    	return count;
    }
    
    public static void main(String[] args) {
    	System.out.println(Integer.toBinaryString(5));
    	System.out.println(NumberOf1(5));
    	System.out.println(Integer.toBinaryString(-5));
    	System.out.println(NumberOf1(-5));
    }
}
