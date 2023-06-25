link : https://leetcode.com/problems/count-all-possible-routes/description/

Note : There is one condition 
       we can take start end point, and same path any number of time, that makes it interesting
       we dont know where to stop, so base case is interesting as well, take a look

code : 

class Solution {
    public int mod = (int)1e9+7;
    public int countRoutes(int[] locations, int start, int finish, int fuel) {
        
       int n = locations.length;
       Integer dp[][] = new Integer[n][fuel+1];

       return getAllWays(start, fuel, finish, locations, dp);
    }
    public int getAllWays(int start, int feulRemaining, int endPoint, int loc[], Integer dp[][]){
        
        //base case
        if(feulRemaining < 0) return 0;

        if(dp[start][feulRemaining] != null) return dp[start][feulRemaining];        

        int count = 0;
        if(start == endPoint) count++;

        for(int ind = 0; ind < loc.length; ind++){
            
            int feulRequird = Math.abs(loc[start]-loc[ind]);
            if(ind == start || feulRequird > feulRemaining) continue;

            count = (count + getAllWays(ind, feulRemaining - feulRequird, endPoint, loc, dp)) % mod;
        }

        return dp[start][feulRemaining] = count % mod;

    }
}