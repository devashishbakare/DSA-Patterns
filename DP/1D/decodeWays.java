link : https://leetcode.com/problems/decode-ways/description/

code : 
class Solution {
    public int numDecodings(String s) {
        int dp[] = new int[s.length()+2];
        dp[s.length()] = 1;
        for(int ind = s.length()-1; ind >= 0 ; ind--){

            if(s.charAt(ind) == '0') continue;
            int oneDigitPartition = dp[ind+1];
            int twoDigitPartition = 0;

            if(ind < s.length()-1){
                
                String str = s.substring(ind, ind+2);
                int parseIntValue = Integer.parseInt(str);

                if(parseIntValue <= 26){
                    twoDigitPartition = dp[ind+2];
                }
            }
             dp[ind] = oneDigitPartition + twoDigitPartition;
        }

        return dp[0];
    }

}