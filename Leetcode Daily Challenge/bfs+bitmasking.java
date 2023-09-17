link : https://leetcode.com/problems/shortest-path-visiting-all-nodes/description/?envType=daily-question&envId=2023-09-17

code :

class Solution {
    public int shortestPathLength(int[][] graph) {

        if (graph.length == 1)
            return 0;
        int finalState = (1 << graph.length) - 1;

        Queue<int[]> q = new LinkedList();

        for (int i = 0; i < graph.length; i++)
            q.add(new int[] { i, 1 << i });

        int[][] visitedMap = new int[graph.length][finalState + 1];

        int shortestPath = 0;
        while (!q.isEmpty()) {
            int size = q.size();
            shortestPath++;
            for (int i = 0; i < size; i++) {
                int[] head = q.poll();
                int nodeId = head[0];
                int visitedNodeBitState = head[1];
                for (int neigh : graph[nodeId]) {
                    int newVisitedNodeBitState = visitedNodeBitState | (1 << neigh);

                    if (visitedMap[neigh][newVisitedNodeBitState] == 1)
                        continue;
                    visitedMap[neigh][newVisitedNodeBitState] = 1;
                    if (newVisitedNodeBitState == finalState)
                        return shortestPath;
                    q.add(new int[] { neigh, newVisitedNodeBitState });
                }
            }
        }
        return -1;
    }
}