class Solution {

    public List<List<Integer>> levelOrder(TreeNode root) {

        List<List<Integer>> arr = new ArrayList<>();

        if(root == null)
            return arr;

        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        List<TreeNode> list = new ArrayList<TreeNode>();

        queue.add(root);

        List<Integer> subArr = new ArrayList<>();

        while(!queue.isEmpty()) {

            TreeNode peekNode = queue.poll();

            subArr.add(peekNode.val);

            if(peekNode.left != null)
                list.add(peekNode.left);

            if(peekNode.right != null)
                list.add(peekNode.right);

            if(queue.isEmpty()) {

                arr.add(subArr);

                subArr = new ArrayList<>();

                for(TreeNode node : list) {
                    queue.add(node);
                }

                list.clear();
            }
        }

        return arr;
    }
}