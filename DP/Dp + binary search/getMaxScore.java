link : https://leetcode.com/problems/maximum-number-of-events-that-can-be-attended-ii/description/

Editorial : https://leetcode.com/problems/maximum-number-of-events-that-can-be-attended-ii/editorial/
code : 
class Solution {
    public int maxValue(int[][] events, int k) {
        Arrays.sort(events, (a, b) -> a[0] - b[0]);
        int n = events.length;
        
        Integer dp[][] = new Integer[n][k+1];
        
        return dfs(0, k, events, dp);
    }    
    
   
    private int dfs(int ind, int k, int[][] events, Integer dp[][]) {
        if (k == 0 || ind == events.length) {
            return 0;
        }
        if (dp[ind][k] != null) {
            return dp[ind][k];
        }
        int nextIndex = bisectRight(events, events[ind][1]);
        int notTake = dfs(ind+1, k, events, dp);
        int cost = events[ind][2];
        int take = dfs(nextIndex, k-1, events,dp) + cost;
        
        return dp[ind][k] = Math.max(take, notTake);
    }
    
    public static int bisectRight(int[][] events, int target) {
        int left = 0, right = events.length;
        while (left < right) {
            int mid = (left + right) / 2;
            if (events[mid][0] <= target) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return left;
    }   
}
