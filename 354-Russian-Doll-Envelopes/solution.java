public class Solution {
    public int maxEnvelopes(int[][] envelopes) {
        if (envelopes == null || envelopes.length == 0) {
            return 0;
        }
        int res = 1;
        int m = envelopes.length;
        int n = envelopes[0].length;
        
        Arrays.sort(envelopes, new Comparator<int[]>() {
            public int compare(int[] a, int[] b) {
                if (a[0] == b[0]) {
                    return b[1] - a[1];
                } else {
                    return a[0] - b[0];
                }
            }
        });
        
        int[] dp = new int[envelopes.length];
        int len = 0;
        for (int i = 0; i < m; i++) {
            int index = Arrays.binarySearch(dp, 0, len, envelopes[1]);
            if (index < 0) {
                index = -(index + 1);
            }
            dp[index] = envelopes[1];
            if (index == len) {
                len++;
            }
        }
        return res;
    }
}