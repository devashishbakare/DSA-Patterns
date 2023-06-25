link : https://leetcode.com/problems/tallest-billboard/description/

Note : 1) out some can go upto -5000 Or 5001 so dp created new Integer[n][10001];
          Or we can make new Integer[n][5001][5001]; it will give us memory limit exided
       2) Here we have to created 2 set
            a) sum + arr[ind]; Adding in set1
            b) sum - arr[ind]; Adding in set2
       3) we have cover a left side sum and right side sum in array new Integer[n][10001];

code : 

class Solution {
   
    public int tallestBillboard(int[] rods) {
    
        int n = rods.length;
        Integer dp[][] = new Integer[n][10001];
    
        return getMaxLength(0, 0, rods, dp);
    }

    public int getMaxLength(int ind, int sum, int arr[], Integer dp[][]){
        
        //base case
        if(ind == arr.length){
            if(sum == 0){
                return 0;
            }else{
                return -(int)1e9;
            }
        }
        if(dp[ind][5001 + sum] != null) return dp[ind][5001+sum];

        
        int takeFirstHalf = arr[ind] + getMaxLength(ind+1, sum + arr[ind], arr, dp);
        int takeSecHalf = getMaxLength(ind+1, sum - arr[ind], arr, dp);

        int notTake = getMaxLength(ind+1, sum, arr, dp);

        return dp[ind][5001+sum] = Math.max(notTake, Math.max(takeFirstHalf, takeSecHalf));
    }

}