public class Solution {
    public List<int[]> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        List<int[]> res = new ArrayList<>();
        if (nums1 == null || nums1.length == 0 || nums2.length == 0 || nums2 == null) {
            return res;
        }
        int m = nums1.length;
        int n = nums2.length;
        PriorityQueue<int[]> pq = new PriorityQueue<int[]>((a, b) -> (a[0] + a[1] - b[0] - b[1]));
        for (int i = 0; i < nums1.length; i++) {
            for (int j = 0; j < nums2.length; j++) {
                int[] pair = new int[2];
                pair[0] = nums1[i];
                pair[1] = nums2[j];
                pq.offer(pair);
            }
        }
        while (!pq.isEmpty() && res.size() < k) {
            res.add(pq.poll());
        }
        return res;
    }
}