
class Solution {

    HashMap<Node, Node> map = new HashMap<>();

    public Node dfs(Node node) {

        // already cloned
        if (map.containsKey(node)) {
            return map.get(node);
        }

        // create clone
        Node newNode = new Node(node.val);

        // store in map
        map.put(node, newNode);

        // clone neighbors
        for (Node adjNode : node.neighbors) {
            newNode.neighbors.add(dfs(adjNode));
        }

        return newNode;
    }

    public Node cloneGraph(Node node) {

        if (node == null) {
            return null;
        }

        return dfs(node);
    }
}