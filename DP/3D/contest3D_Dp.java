link : https://leetcode.com/contest/biweekly-contest-107/problems/decremental-string-concatenation/

explantion : https://www.youtube.com/watch?v=5XER2thL3HI

code : 

class Solution {
    public int minimizeConcatenatedLength(String[] words) {
     
        int ans = 0;
        int n = words.length;
        Integer dp[][][] = new Integer[n][26][26];
        
       return solve(0, ',', ',',words, dp);
    }
    
    public int solve(int ind, char firstChar, char lastChar, String words[], Integer dp[][][]){
        
        //base case
        
        if(ind == words.length){
            return 0;
        }
        
        //dp case
        if(ind != 0 && dp[ind][firstChar-'a'][lastChar-'a'] != null ) return dp[ind][firstChar-'a'][lastChar-'a'];
        
        String currWord = words[ind];
        char currStart = currWord.charAt(0);
        char currEnd = currWord.charAt(currWord.length()-1);
        
        if(firstChar == ',' && lastChar == ','){
            return currWord.length() + solve(ind+1, currStart, currEnd, words, dp);
        }
        
        int xyNotMatch = currWord.length() + solve(ind+1, firstChar, currEnd, words, dp);
        int yxNotMatch = currWord.length() + solve(ind+1, currStart, lastChar, words, dp);
        
        int xyMatch = (int)1e9;
        int yxMatch = (int)1e9;
        
        if(lastChar == currStart){
            xyMatch = currWord.length()-1 + solve(ind+1, firstChar, currEnd, words, dp);
        }
        
        if(currEnd == firstChar) {
            yxMatch = currWord.length()-1 + solve(ind+1, currStart, lastChar, words, dp);   
        }
        
        int currNotMatch = Math.min(xyNotMatch, yxNotMatch);
        int currMatch = Math.min(xyMatch, yxMatch);
        
        return dp[ind][firstChar-'a'][lastChar-'a'] = Math.min(currNotMatch, currMatch);
    
    }
    
}