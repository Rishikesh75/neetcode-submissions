class Solution {
    public TreeNode ans = null;

    public boolean recurssion(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null) return false;

        boolean left = recurssion(root.left, p, q);
        boolean right = recurssion(root.right, p, q);

        boolean curr = (root.val == p.val || root.val == q.val);

        if((left && right) || (curr && left) || (curr && right)) {
            ans = root;
        }

        return left || right || curr;
    }

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        recurssion(root, p, q);
        return ans;
    }
}