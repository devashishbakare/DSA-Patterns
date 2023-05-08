link : https://leetcode.com/problems/matrix-diagonal-sum/description/

you can traverse row wise diagonaly like 
mat[i][i]; i++; 
in column you have to do it like this
mat[n-1-i][i]; 
starting from last row(n-1) and as you go you have to reduced it coz you need to go on top
[n-1-i][i] = [i] in column due to it go like 2.0 -> 1 - 1 -> 0 - 2......

public int diagonalSum(int[][] mat) {
        int res = 0;
        int n = mat.length;
        for (int i=0; i<n; i++) {
            res += mat[i][i]; 
            res += mat[n-1-i][i]; 
        }
        return n % 2 == 0 ? res : res - mat[n/2][n/2];
    }