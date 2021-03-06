/**
 * // This is the interface that allows for creating nested lists.
 * // You should not implement it, or speculate about its implementation
 * public interface NestedInteger {
 *
 *     // @return true if this NestedInteger holds a single integer, rather than a nested list.
 *     public boolean isInteger();
 *
 *     // @return the single integer that this NestedInteger holds, if it holds a single integer
 *     // Return null if this NestedInteger holds a nested list
 *     public Integer getInteger();
 *
 *     // @return the nested list that this NestedInteger holds, if it holds a nested list
 *     // Return null if this NestedInteger holds a single integer
 *     public List<NestedInteger> getList();
 * }
 */
public class Solution {
    public int depthSum(List<NestedInteger> nestedList) {
        int res = dfs(nestedList, 1);
        return res;
    }
    
    public int dfs(List<NestedInteger> list, int level) {
        if (list == null) {
            return 0;
        }
        int res = 0;
        for (NestedInteger num : list) {
            if (num.isInteger()) {
                res += level * num.getInteger();
            } else {
                res += dfs(num.getList(), level + 1);
            }
        }
        return res;
    }
}