public class MaxSumTest {
    public static void main(String [] args){
         
          MaxSum maxSum = new MaxSum();
    int[] A = {1, 2, 3, 4, 5, 6, -10};
 
    System.out.println(maxSum.maxsubSlow(A));
    System.out.println("Faster " + maxSum.maxSubFaster(A));
    System.out.println("Fastest " + maxSum.maxSubFastest(A));
    }
  
}
