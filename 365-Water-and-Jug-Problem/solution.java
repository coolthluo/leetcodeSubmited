public class Solution {
    public boolean canMeasureWater(int x, int y, int z) {
        if (x + y < z) {
            return false;
        }
        if (x == z || y == z || x + y == z) {
            return true;
        }
        return z % GCD(x, y) == 0;
    }
    
    public int GCD(int x, int y) {
        while (x != 0 && y != 0) {
            int temp = y;
            y = x % y;
            x = temp;
        }
        return x;
    }
}