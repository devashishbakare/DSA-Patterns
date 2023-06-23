//link : https://leetcode.com/contest/weekly-contest-350/problems/painting-the-walls/

//code : 

//Note: we know how to use take and not take way of solving problem, but here some twist, good to see

class Solution {
   
    public int paintWalls(int[] cost, int[] time) {
       
         int size = cost.length; 
         Integer dp[][] = new Integer[size][size+1];
         return getSubset(0, size, cost, time, dp);
    }
    
    public int getSubset(int ind, int remainingWall, int cost[], int time[], Integer dp[][]){
            
        if(remainingWall <= 0) return 0;
        if(ind >= cost.length)return (int)1e9;
        
        
        if(dp[ind][remainingWall] != null) return dp[ind][remainingWall];
        
        int take = cost[ind] + getSubset(ind+1, remainingWall-time[ind]-1 ,cost, time, dp);
        int notTake = 0 + getSubset(ind+1, remainingWall, cost, time, dp);
        
        return dp[ind][remainingWall] = Math.min(take, notTake);
        
    }
    
}