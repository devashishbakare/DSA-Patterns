link : https://leetcode.com/problems/frog-jump/description/

editorial : https://leetcode.com/problems/frog-jump/solutions/3966051/easy-explanation-with-intuition/

code : 


class Solution {
    Map<Integer, Integer> store = new HashMap<>();
    public boolean canCross(int[] stones) {
        int i = 0;
        for(int stone : stones){
            store.put(stone, i++);
        } 
        if(stones[1]-stones[0] > 1) return false; 
        int n = stones.length;
       
        Integer dp[][] = new Integer[n][n+1];
        return isPossible(1, stones, 1, dp);
    }

    public boolean isPossible(int ind, int arr[], int lastJump, Integer dp[][]){

        if(arr[ind] == arr[arr.length-1]) return true;

        if(ind >= arr.length) return false; 

        if(dp[ind][lastJump] != null) return dp[ind][lastJump] == 1 ? true : false;

        if(lastJump - 1 > 0){
            if(store.containsKey(arr[ind] + (lastJump-1))){
                int updatedInd = store.get(arr[ind] + (lastJump-1));
                if(isPossible(updatedInd, arr, lastJump-1, dp)){
                    dp[ind][lastJump-1] = 1;
                    return true;
                } 
            }
            
        }


        if(store.containsKey(arr[ind] + lastJump)){
            int updatedInd = store.get(arr[ind] + (lastJump));
            if(isPossible(updatedInd, arr, lastJump, dp)) {
                    dp[ind][lastJump] = 1;
                    return true;
                } 
        }
        

        if(store.containsKey(arr[ind] + lastJump+1)){
            int updatedInd = store.get(arr[ind] + (lastJump+1));
            if(isPossible(updatedInd, arr, lastJump+1, dp)) {
                    dp[ind][lastJump+1] = 1;
                    return true;
                } 
        }
        
        dp[ind][lastJump] = 0;
        return false;

    }
}












