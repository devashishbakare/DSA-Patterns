//problem : https://leetcode.com/problems/count-square-submatrices-with-all-ones/description/

//code

class Solution {
    public int countSquares(int[][] matrix) {
        int rowLen = matrix.length;
        int colLen = matrix[0].length;
        int dp[][] = new int[rowLen][colLen];
        for(int i = 0; i < rowLen; i++) dp[i][0] = matrix[i][0];
        for(int i = 0; i < colLen; i++) dp[0][i] = matrix[0][i];
        int count = 0;
        for(int row = 1; row < rowLen; row++){
            for(int col = 1; col < colLen; col++){
                if(matrix[row][col] > 0){
                    int min = Math.min(dp[row][col-1], Math.min(dp[row-1][col-1], dp[row-1][col]));
                    dp[row][col] = min + 1;
                }
            }
        }
        for(int row = 0; row < rowLen; row++){
            for(int col = 0; col < colLen; col++){
                count += dp[row][col];
            }
        }
        return count;
    }
}