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
    public boolean isValidBST(TreeNode root) {
        LinkedList<TreeNode> st = new LinkedList<>();
        TreeNode cur = root;
        TreeNode small = null;
        while (cur != null || !st.isEmpty()) {
            while (cur != null) {
                st.push(cur);
                cur = cur.left;
            }
            cur = st.poll();
            if (small != null && cur.val <= small.val) return false;
            small = cur;
            cur = cur.right;
        }
        return true;
    }
} //TC: O(n), SC: O(height of tree), where n is node count