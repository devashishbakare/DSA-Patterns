link : https://leetcode.com/problems/strange-printer/description/

explantion : https://www.youtube.com/watch?v=yDaWPjVkWk8

code :

class Solution {
    public int strangePrinter(String s) {
        int n = s.length();
        Integer dp[][] = new Integer[n][n];
        return solve(0, n-1, s, dp);
    }

    public int solve(int start, int end, String s, Integer dp[][]){

        //base case
        if(start == end) return 1;

        if(dp[start][end] != null) return dp[start][end];

        int ans = (int)1e9;
        for(int k = start; k < end ; k++){
            int left = solve(start, k, s, dp);
            int right = solve(k+1,end, s, dp);
            ans = Math.min(ans, left+right);
        }
        return dp[start][end] = s.charAt(start) == s.charAt(end) ? ans-1 : ans;
    }
}

