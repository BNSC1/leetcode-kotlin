/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public boolean isBalanced(TreeNode root) {
        class Helper {
            static Res balanced(TreeNode node) {
                if (node == null) return new Res();
                Res l = balanced(node.left);
                Res r = balanced(node.right);
                boolean balanced = l.isBalanced && r.isBalanced && Math.abs(l.depth - r.depth) <= 1;
                return new Res(Math.max(l.depth, r.depth) + 1,
                               balanced);
            }
        }
        return Helper.balanced(root).isBalanced;
    }
} //TC: O(n), SC: O(n)
class Res {
    int depth = 0;
    boolean isBalanced = true;
    Res(int depth, boolean isBalanced) {
        this.depth = depth;
        this.isBalanced = isBalanced;
    }
    Res() {}
}