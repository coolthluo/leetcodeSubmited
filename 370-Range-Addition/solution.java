public class Solution {
    //O(n * k)
    // public int[] getModifiedArray(int length, int[][] updates) {
    //     if (length == 0) {
    //         return new int[]{};
    //     }
    //     int[] res = new int[length];
    //     for (int[] update : updates) {
    //         int startIndex = update[0];
    //         int endIndex = update[1];
    //         int inc = update[2];
    //         for (int i = startIndex; i <= endIndex; i++) {
    //             res[i] += inc;
    //         }
    //     }
    //     return res;
    // }
    // 
    
    //Brilliant solution O(n + k)
    public int[] getModifiedArray(int length, int[][] updates) {
        if (length == 0) {
            return new int[]{};
        }
        int[] res = new int[length];
        for (int[] update : updates) {
            int startIndex = update[0];
            int endIndex = update[1];
            int inc = update[2];
            res[startIndex] += inc;
            if (endIndex < length - 1) {
                res[endIndex + 1] -= inc;
            }
        }
        int sum = 0;
        for (int i = 0; i < length; i++) {
            sum += res[i];
            res[i] = sum;
        }
        return res;
    }
}