public class Solution {
    public boolean isReflected(int[][] points) {
        if (points == null || points.length == 0) {
            return true;
        }
        HashSet<String> set = new HashSet<>();
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        for (int[] point : points) {
            max = Math.max(point[0], max);
            min = Math.min(point[0], min);
            String num = point[0] + "a" + point[1];
            set.add(num);
        }
        int mid = max + min;
        for (int[] point : points) {
            String num = (mid - point[0] + "a" + point[1]);
            if (!set.contains(num)) {
                return false;
            }
        }
        return true;
    }
}