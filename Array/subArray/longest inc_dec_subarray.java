/*
Idea: Use a DP array to store the length of the longest increasing subarray ending at each index.
Steps:

Iterate through the array:
    If arr[i] > arr[i-1], then dp[i] = dp[i-1] + 1.
    
    Else, dp[i] = 1 (start a new subarray).
    
    The answer is the maximum value in the dp array.
    
    Time Complexity: 
    O(n)
    Space Complexity: 
    O(n)


 */
class Solution {
    public int longestMonotonicSubarray(int[] nums) {
        int maxCount = 0;
        int n = nums.length;
        Integer dp[] = new Integer[n];
        //here dp[i] = having increasing subarray count at this index
        //maximum of it will be longest one
        for(int i = 0; i < n; i++){
            maxCount = Math.max(maxCount, getLIS(i, nums, dp));
        }

        dp = new Integer[n];
        for(int i = 0; i < n; i++){
            maxCount = Math.max(maxCount, getLISS(i, nums, dp));
        }

        return maxCount;
    }
    
    public int getLIS(int ind, int nums[], Integer[] dp){
    
        if(ind == 0) return 1;

        if(dp[ind] != null) return dp[ind];
        // 1 2 3
        // 2 is > 1 then go and check for 1 and before 1 and return ans
        if(nums[ind] > nums[ind-1]){
            dp[ind] =  1 + getLIS(ind-1, nums, dp);
        }else{
           dp[ind] = 1;
        }
        return dp[ind];
    }
    public int getLISS(int ind, int nums[], Integer[] dp){
    
        if(ind == 0) return 1;

        if(dp[ind] != null) return dp[ind];
        // 4 3 2
        if(nums[ind] < nums[ind-1]){
            dp[ind] =  1 + getLIS(ind-1, nums, dp);
        }else{
           dp[ind] = 1;
        }
        return dp[ind];
    }

}