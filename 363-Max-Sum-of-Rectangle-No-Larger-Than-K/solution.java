public class Solution {
    public int maxSumSubmatrix(int[][] matrix, int k) {
        if (matrix == null || matrix.length == 0) {
            return 0;
        }
        //2D Kadane's algorithm + 1D maxSum problem with sum limit k
        //2D subarray sum solution
        
        //boundary check
        int m = matrix.length;
        int n = matrix[0].length;
        
        int res = Integer.MIN_VALUE;
        
        //outer loop should use smaller axis
        //now we assume we have more rows than cols, therefore outer loop will be based on cols 
        for (int left = 0; left < n; left++) {
            //array that accumulate sums for each row from left to right 
            int[] sums = new int[m];
            for (int right = left; right < n; right++) {
                //update sums[] to include values in cur right col
                for (int i = 0; i < m; i++) {
                    sums[i] += matrix[i][right];
                }
                
                //we use TreeSet to help us find the rectangle with maxSum <= k with O(logN) time
                TreeSet<Integer> set = new TreeSet<>();
                //add 0 to cover the single row case
                set.add(0);
                int curSum = 0;
                
                for (int sum : sums) {
                    curSum += sum;
                    //we use sum subtraction (curSum - sum) to get the subarray with sum <= k
                    //therefore we need to look for the smallest sum >= currSum - k
                    
                    //curSum - preSum <= k -> curSum - k <= preSum -> find max (curSum - preSum);
                    //curSum - preSum 就是sum[0..j] - {sum[0..0], sum[0,1], sum[0..k] } ，可以取得interval sum！
                    Integer preSum = set.ceiling(curSum - k);
                    if (preSum != null) {
                        int intervalSum = curSum - preSum;
                        res = Math.max(intervalSum, res);
                    }
                    set.add(curSum);
                }
            }
        }
        return res;
    }
}
        