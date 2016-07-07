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
                return Integer.compare(a[0], b[0]);
            }
        });
        
        for (int i = 0; i < m; i++) {
            dp[i] = 1;
            for (int j = 0; j < i; j++) {
                if (envelopes[i][0] > envelopes[j][0] && envelopes[i][1] < envelopes[j][1]) {
                    res = Math.max(res, max);
                    rowValue = envelopes[j][0];
                    colValue = envelopes[j][1];
                }
            }
        }
        return res;
    }
}