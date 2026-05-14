class Solution {

    public void dfs(
            int node,
            List<List<Integer>> graph,
            boolean[] visited
    ) {

        visited[node] = true;

        for (int adjNode : graph.get(node)) {

            if (!visited[adjNode]) {
                dfs(adjNode, graph, visited);
            }
        }
    }

    public int countComponents(int n, int[][] edges) {

        // create graph
        List<List<Integer>> graph = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }

        // build adjacency list
        for (int[] edge : edges) {

            int u = edge[0];
            int v = edge[1];

            graph.get(u).add(v);
            graph.get(v).add(u);
        }

        boolean[] visited = new boolean[n];

        int count = 0;

        // run dfs for every unvisited node
        for (int i = 0; i < n; i++) {

            if (!visited[i]) {

                dfs(i, graph, visited);

                count++;
            }
        }

        return count;
    }
}