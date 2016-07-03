public class Solution {
    public int maxEnvelopes(int[][] envelopes) {  
        Arrays.sort(envelopes, new Comparator<int[]>() {  
            @Override public int compare(int[] e1, int[] e2) {  
                return e1[0] - e2[0];  
            }  
        });  
        int max = 0;  
        int[] counts = new int[envelopes.length];  
        for(int i=0; i<envelopes.length; i++) {  
            counts[i] = 1;  
            for(int j=0; j<i; j++) {  
                if (envelopes[j][0] < envelopes[i][0] && envelopes[j][1] < envelopes[i][1]) {  
                    counts[i] = Math.max(counts[i], counts[j] + 1);  
                }  
            }  
            max = Math.max(max, counts[i]);  
        }  
        return max;  
    }
}