public class Solution {
    public int maxEnvelopes(int[][] envelopes) {
        int res = 0;
        if (envelopes.length == 0 || envelopes[0].length == 0) {
            return res;
        }
        int m = envelopes.length;
        int n = envelopes[0].length;
        
        Arrays.sort(envelopes);
        
        for (int i = 0; i < m - 1; i++) {
            int max = 1;
            int rowValue = envelopes[i][0];
            int colValue = envelopes[i][1];
            for (int j = i + 1; j < m; j++) {
                if (rowValue < envelopes[j][0] && colValue < envelopes[j][1]) {
                    max++;
                    res = Math.max(res, max);
                    rowValue = envelopes[j][0];
                    colValue = envelopes[j][1];
                } else {
                    max = 1;
                }
            }
        }
        return res;
    }
}