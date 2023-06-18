Link : https://leetcode.com/problems/number-of-increasing-paths-in-a-grid/description/

editorial : https://leetcode.com/problems/number-of-increasing-paths-in-a-grid/editorial/
code : 

class Solution {
    int[][] dp;
    int dir[] = {1,0,-1,0,1};
    int mod = (int)1e9+7;;
    
    int dfs(int[][] grid, int row, int col) {
       
        if (dp[row][col] != 0)
            return dp[row][col];

        
        int answer = 1;

       
      for(int i = 0; i < 4; i++){
            int prevI = row + dir[i];
            int prevJ = col + dir[i+1];
            if (0 <= prevI && prevI < grid.length && 0 <= prevJ && 
                prevJ < grid[0].length && grid[prevI][prevJ] < grid[row][col]) {
                answer += dfs(grid, prevI, prevJ);
                answer %= mod;
            }
        }

        
        dp[row][col] = answer;
        return answer;
    }
    
    public int countPaths(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        dp = new int[m][n];

        int answer = 0;
        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                answer = (answer + dfs(grid, i, j)) % mod;
            }
        }

        return answer;
    }
}