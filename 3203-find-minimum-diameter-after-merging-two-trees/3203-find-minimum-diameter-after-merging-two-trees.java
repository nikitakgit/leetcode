class Solution {
        public int minimumDiameterAfterMerge(int[][] edges1, int[][] edges2) {
        int[] d1 = diameter(edges1);
        int[] d2 = diameter(edges2);
        return Math.max(d1[1], Math.max(d2[1], d1[0] + d2[0] + 1));
    }
    
    static int[] diameter(int[][] edges) {
        List<Set<Integer>> graph = new ArrayList<Set<Integer>>();
        for (int i = 0; i < edges.length + 1; ++i) {
            graph.add(new HashSet<Integer>());
        }
        for (int[] edge : edges) {
            Integer u = edge[0], v = edge[1];
            graph.get(u).add(v);
            graph.get(v).add(u);
        }

        LinkedList<Integer> leaves = new LinkedList<Integer>();
        for (int vertex = 0; vertex < graph.size(); ++vertex) {
            if (graph.get(vertex).size() == 1)
                leaves.add(vertex);
        }

        int layers = 0;
        int vertexLeft = edges.length + 1;
        while (vertexLeft > 2) {
            vertexLeft -= leaves.size();

            LinkedList<Integer> next = new LinkedList<Integer>();

            for (int leaf : leaves) {
                int neighbor = graph.get(leaf).iterator().next();
                graph.get(neighbor).remove(leaf);
                if (graph.get(neighbor).size() == 1) {
                    next.add(neighbor);
                }
            }

            layers += 1;
            leaves = next;
        }

        if (vertexLeft == 1) {
            return new int[]{layers, 2 * layers};
        } else {
            return new int[]{layers + 1, 2 * layers + 1};
        }
    }
}