link : https://leetcode.com/contest/weekly-contest-359/problems/maximize-the-profit-as-the-salesman/

editorial : https://www.youtube.com/watch?v=Vk_ItvUIGEE

code :

class Solution {
    public int maximizeTheProfit(int n, List<List<Integer>> offers) {
        Collections.sort(offers, (a, b) -> {
            if(a.get(0) == b.get(0)){
                return a.get(1)-b.get(1);
            }
            
            return a.get(0)-b.get(0);
        });
        Integer dp[] = new Integer[offers.size()];
        return getMaxScore(offers, 0, dp);
    }
    
    public int getMaxScore(List<List<Integer>> offers, int ind, Integer dp[]){
        
        if(ind >= offers.size()) return 0;
        if(dp[ind] != null) return dp[ind];
        int notBuying = getMaxScore(offers, ind+1, dp);
    
        int nextBuyIndex = offers.get(ind).get(1)+1;
        int low = ind+1, high = offers.size()-1;
        while(low <= high){
            int mid = low + (high-low)/2;
            if(offers.get(mid).get(0) >= nextBuyIndex){
                high = mid-1;
            }else{
                low = mid+1;
            }
        }
        
        int buying = offers.get(ind).get(2) + getMaxScore(offers, low, dp);
        return dp[ind] = Math.max(buying, notBuying);
    }
}