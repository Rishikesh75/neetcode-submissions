class Solution {

    public String foreignDictionary(String[] words) {

        // Step 1: Create graph
        Map<Character, Set<Character>> graph = new HashMap<>();
        Map<Character, Integer> indegree = new HashMap<>();

        // Initialize all characters
        for (String word : words) {
            for (char ch : word.toCharArray()) {
                graph.putIfAbsent(ch, new HashSet<>());
                indegree.putIfAbsent(ch, 0);
            }
        }

        // Step 2: Build graph using adjacent words
        for (int i = 0; i < words.length - 1; i++) {

            String w1 = words[i];
            String w2 = words[i + 1];

            // Invalid case
            if (w1.length() > w2.length() && w1.startsWith(w2)) {
                return "";
            }

            int minLen = Math.min(w1.length(), w2.length());

            for (int j = 0; j < minLen; j++) {

                char c1 = w1.charAt(j);
                char c2 = w2.charAt(j);

                // First different character decides ordering
                if (c1 != c2) {

                    // Avoid duplicate edges
                    if (!graph.get(c1).contains(c2)) {
                        graph.get(c1).add(c2);
                        indegree.put(c2, indegree.get(c2) + 1);
                    }

                    break;
                }
            }
        }

        // Step 3: Topological Sort (Kahn's Algorithm)
        Queue<Character> queue = new LinkedList<>();

        for (char ch : indegree.keySet()) {
            if (indegree.get(ch) == 0) {
                queue.offer(ch);
            }
        }

        StringBuilder result = new StringBuilder();

        while (!queue.isEmpty()) {

            char curr = queue.poll();
            result.append(curr);

            for (char neighbor : graph.get(curr)) {

                indegree.put(neighbor, indegree.get(neighbor) - 1);

                if (indegree.get(neighbor) == 0) {
                    queue.offer(neighbor);
                }
            }
        }

        // Cycle exists
        if (result.length() != indegree.size()) {
            return "";
        }

        return result.toString();
    }
}