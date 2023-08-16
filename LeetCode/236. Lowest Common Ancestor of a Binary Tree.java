/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        class Helper {
            TreeNode lca(TreeNode node) {
                return lowestCommonAncestor(node, p, q);
            }
        }
        Helper helper = new Helper();
        if (root == null || root == p || root == q) return root;
        TreeNode left = helper.lca(root.left);
        TreeNode right = helper.lca(root.right);

        if (left == null) return right;
        if (right == null) return left;
        return root;
    }
}