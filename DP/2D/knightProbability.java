link : https://leetcode.com/problems/knight-probability-in-chessboard/description/

explantion : https://www.youtube.com/watch?v=54nJhM2AZv4

code : 

class Solution {
    public double knightProbability(int n, int K, int r, int c) {
        int dir[][] = {{-2, -1}, {-2, 1}, {-1, 2}, {1, 2}, {2, -1}, {2, 1}, {-1,-2}, {1, -2}};

        double curr[][] = new double[n][n];
        curr[r][c] = 1;
        double next[][] = new double[n][n];

        for(int k=0 ; k < K; k++){
            for(int row = 0; row < n; row++){
                for(int col = 0; col < n; col++){
                    if(curr[row][col] != 0){
                        for(int i = 0; i < 8; i++){
                        int path[] = dir[i];
                        int newRow = row + path[0];
                        int newCol = col + path[1];
                        if(check(newRow, newCol, n)){
                                next[newRow][newCol] += (double)curr[row][col]/8;
                        }
                    }
                    }
                    
                }
            }
            curr = next;
            next = new double[n][n];
        }
        double sum = 0;
        for(int row = 0; row < n; row++){
            for(int col = 0; col < n; col++){
                sum += curr[row][col];
            }
        }
        return sum;
    }
    public boolean check(int row, int col, int n){
        if(row < n && row >= 0 && col < n && col >=0) return true;
        return false;
    }
}