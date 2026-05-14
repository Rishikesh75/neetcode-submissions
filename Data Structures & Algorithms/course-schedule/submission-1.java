class Solution {

    public Stack<Integer> stack = new Stack<>();

    public boolean dfs(
            Integer currNode,
            List<List<Integer>> graph,
            List<Boolean> visitedArr,
            List<Boolean> pathVisited
    ){

        visitedArr.set(currNode, true);
        pathVisited.set(currNode, true);

        for (var adjNode : graph.get(currNode)) {

            // cycle detected
            if (pathVisited.get(adjNode)) {
                return true;
            }

            if (!visitedArr.get(adjNode)) {
                if (dfs(adjNode, graph, visitedArr, pathVisited)) {
                    return true;
                }
            }
        }

        pathVisited.set(currNode, false);

        stack.push(currNode);

        return false;
    }

    public boolean canFinish(int numCourses, int[][] prerequisites) {

        // create graph
        List<List<Integer>> graph = new ArrayList<>();

        for (int i = 0; i < numCourses; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < prerequisites.length; i++) {

            int u = prerequisites[i][1];
            int v = prerequisites[i][0];

            graph.get(u).add(v);
        }

        List<Boolean> visitedArr =
                new ArrayList<>(Collections.nCopies(numCourses, false));

        List<Boolean> pathVisited =
                new ArrayList<>(Collections.nCopies(numCourses, false));

        // run dfs
        for (int i = 0; i < numCourses; i++) {

            if (!visitedArr.get(i)) {

                // if cycle exists
                if (dfs(i, graph, visitedArr, pathVisited)) {
                    return false;
                }
            }
        }

        // topological order
        Map<Integer, Integer> hashMap = new HashMap<>();

        int count = 1;

        while (!stack.isEmpty()) {

            var ele = stack.pop();

            hashMap.put(ele, count);

            count++;
        }

        // validate topo order
        for (var cond : prerequisites) {

            if (hashMap.get(cond[1]) > hashMap.get(cond[0])) {
                return false;
            }
        }

        return true;
    }
}