link : https://leetcode.com/problems/number-of-ways-to-form-a-target-string-given-a-dictionary/description/

Read this before going to solution : 
1) https://leetcode.com/problems/number-of-ways-to-form-a-target-string-given-a-dictionary/editorial/
2) https://leetcode.com/problems/number-of-ways-to-form-a-target-string-given-a-dictionary/solutions/917739/java-recursion-with-memo/?orderBy=most_votes&topicTags=memoization
3) https://leetcode.com/problems/number-of-ways-to-form-a-target-string-given-a-dictionary/solutions/2234922/c-recursion-memoization-optimization-step-by-step-solution/?orderBy=most_votes&topicTags=memoization


code : 
class Solution {
    int MOD = (int)1e9+7;
    Integer[][] memo;
    long[][] counts;
    int maxLength = 0;
    public int numWays(String[] w, String target) {
        counts = new long[1000][26];
      
        for (String q : w) {
            maxLength = Math.max(maxLength, q.length());
            for (int i = 0; i < q.length(); i++) {
                counts[i][q.charAt(i) - 'a']++;
            }
        }
        memo = new Integer[maxLength][target.length()];
        return function(target, 0, 0);
    }
    
    int function(String target, int j, int i) {
	    
        if (i == target.length()) return 1;
		
        if (j == maxLength) return 0;
        if (memo[j][i] != null) return memo[j][i];
        int f = target.charAt(i) -  'a';
        int res = 0;
       
        if (counts[j][f] > 0) {
            // substitute the character in i position from j position in words
			// we can choose it from counts[j][f] words, it would be different solutions, so we multiply
            res = (int) ((counts[j][f] * function(target, j + 1, i + 1)) % MOD);
        }
        
        res += function(target, j + 1, i);
        res %= MOD;
        
        return memo[j][i] = res;
    }
}