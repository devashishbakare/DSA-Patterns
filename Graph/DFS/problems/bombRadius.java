link : https://leetcode.com/problems/detonate-the-maximum-bombs/

code : 

class Solution {
    public long getDistance(int x1, int x2, int y1, int y2){
        return ((long)Math.pow((x2-x1), 2) + (long)Math.pow((y2-y1), 2));
    }

    public void dfs(int src, int count[], int vis[], List<Integer> graph[]){

        if(vis[src]== 1) return;
        vis[src] = 1;
        count[0]++;
        List<Integer> nbrs = graph[src];
        for(int nbr : nbrs){
            dfs(nbr, count, vis, graph);
        }

    }
    public int maximumDetonation(int[][] bombs) {
        int size = bombs.length;
        List<Integer> graph[] = new ArrayList[size];
        int counter = 0;
        while(counter < size) graph[counter++] = new ArrayList<>();
        
        for(int i = 0; i < size; i++){
            for(int j = i + 1; j < size; j++){

                int x1 = bombs[i][0];
                int y1 = bombs[i][1];
                int x2 = bombs[j][0];
                int y2 = bombs[j][1];
                int r1 = bombs[i][2];
                int r2 = bombs[j][2];

                long twoPointDist = getDistance(x1, x2, y1, y2);

                long firstBombCircleRadius = r1 * 1L * r1;
                long secondBombCircleRadius = r2 * 1L * r2;

                if(twoPointDist <= firstBombCircleRadius){
                    graph[i].add(j);
                }

                if(twoPointDist <= secondBombCircleRadius){
                    graph[j].add(i);
                }

            }
        }
        int ans = 0;
        for(int i = 0; i < size; i++){
            int count[] = new int[1];
            int vis[] = new int[size];
            dfs(i, count, vis, graph);
            ans = Math.max(ans, count[0]);
        }
        return ans;
    }
}