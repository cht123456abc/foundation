package cn.edu.scu.exercises;

public class JumpFloor {
	  public static int JumpFloor(int target) {
			if(target==0) return 0;
	        if(target==1) return 1;
	        if(target==2) return 2;
	        return JumpFloor(target-1)+JumpFloor(target-2);
	    }
	  public static void main(String[] args) {
		System.out.println(JumpFloor(10));
	}
}
