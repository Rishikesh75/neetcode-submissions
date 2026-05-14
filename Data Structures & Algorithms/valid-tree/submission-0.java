class Solution {

    public boolean dfs(
            int node,
            int parent,
            List<List<Integer>> graph,
            boolean[] visited
    ) {

        visited[node] = true;

        for (int adjNode : graph.get(node)) {

            // skip the node we came from
            if (adjNode == parent) continue;

            // cycle detected
            if (visited[adjNode]) return false;

            if (!dfs(adjNode, node, graph, visited)) {
                return false;
            }
        }

        return true;
    }

    public boolean validTree(int n, int[][] edges) {

        // tree must have exactly n-1 edges
        if (edges.length != n - 1) return false;

        // create graph
        List<List<Integer>> graph = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }

        for (int[] edge : edges) {

            int u = edge[0];
            int v = edge[1];

            graph.get(u).add(v);
            graph.get(v).add(u);
        }

        boolean[] visited = new boolean[n];

        // check cycle
        if (!dfs(0, -1, graph, visited)) {
            return false;
        }

        // check connected
        for (boolean nodeVisited : visited) {
            if (!nodeVisited) return false;
        }

        return true;
    }
}