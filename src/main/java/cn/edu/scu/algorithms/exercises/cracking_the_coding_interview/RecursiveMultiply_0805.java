package cn.edu.scu.algorithms.exercises.cracking_the_coding_interview;



public class RecursiveMultiply_0805 {

     // 13 * 12 = 13 * (8 + 4) = 13 << 3 + 13 << 2
     public int multiply(int A, int B) {
         int res = 0;
         for(int i = 0;A != 0;i++){
             if((A&1) == 1){
                 res += B<<i;
             }

             A >>= 1;
         }
         return res;
     }

    public int multiply1(int A, int B) {

        return B == 0 ? B : A+multiply(A,B-1);
    }
}
