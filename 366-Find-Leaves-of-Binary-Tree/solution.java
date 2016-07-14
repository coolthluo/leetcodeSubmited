/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution {
    public List<List<Integer>> findLeaves(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        dfs(res, root);
        return res;
    }
    
    public int dfs(List<List<Integer>> res, TreeNode root) {
        if (root == null) {
            return -1;
        }
        int height = 1 + Math.max(dfs(res, root.left), dfs(res, root.right));
        if (res.size() < height + 1) {
            res.add(new ArrayList<Integer>());
        }
        res.get(height).add(root.val);
        root.left = root.right = null;
        return height;
    }
}