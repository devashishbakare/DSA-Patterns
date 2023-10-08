link : https://leetcode.com/problems/build-array-where-you-can-find-the-maximum-exactly-k-comparisons/description/?envType=daily-question&envId=2023-10-07

//see how we are created solution
//see how we careated dp array

code : 

class Solution {
    public int mod = (int)1e9+7;
    public int numOfArrays(int n, int m, int k) {
        Integer dp[][][] = new Integer[m+1][n+1][k+1];
        return getMaxWays(0, n, m, k, dp);
    }
    public int getMaxWays(int lastValue, int n, int m, int k, Integer dp[][][]){

        //base case
         if(n == 0 && k == 0) return 1;
         if(n < 0) return 0;
         if(dp[lastValue][n][k] != null) return dp[lastValue][n][k];
        int ans = 0;
        for(int num = 1; num <= m ; num++){
            if(num > lastValue){
                if(k > 0 && n > 0)
                    ans = (ans + getMaxWays(num, n-1, m, k-1, dp))%mod;
            }else{
                if(n > 0)
                    ans = (ans + getMaxWays(lastValue, n-1, m, k, dp))%mod;
            }
        }
        return dp[lastValue][n][k] = ans%mod;
    }
}