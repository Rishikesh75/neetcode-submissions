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

public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {

        if (root == null) {
            return "";
        }

        StringBuilder sb = new StringBuilder();
        Queue<TreeNode> queue = new LinkedList<>();

        queue.offer(root);

        while (!queue.isEmpty()) {

            TreeNode current = queue.poll();

            if (current == null) {
                sb.append("null,");
                continue;
            }

            sb.append(current.val).append(",");

            queue.offer(current.left);
            queue.offer(current.right);
        }

        return sb.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {

        if (data == null || data.isEmpty()) {
            return null;
        }

        String[] values = data.split(",");

        TreeNode root = new TreeNode(Integer.parseInt(values[0]));
        Queue<TreeNode> queue = new LinkedList<>();

        queue.offer(root);

        int index = 1;

        while (!queue.isEmpty() && index < values.length) {

            TreeNode current = queue.poll();

            // Left child
            if (!values[index].equals("null")) {
                current.left = new TreeNode(Integer.parseInt(values[index]));
                queue.offer(current.left);
            }

            index++;

            // Right child
            if (index < values.length && !values[index].equals("null")) {
                current.right = new TreeNode(Integer.parseInt(values[index]));
                queue.offer(current.right);
            }

            index++;
        }

        return root;
    }
}