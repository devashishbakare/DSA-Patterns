link : https://leetcode.com/problems/number-of-provinces/description/

code : 

class Solution {
    
    int[] root;    
    int[] rank;
        
    public int find(int x){
        if(root[x] == -1)
            return x;
        return root[x] = find(root[x]);
    }
    
    public void union (int i, int j){
        int i_p = find(i);
        int j_p = find(j);
        if(i_p == j_p)
            return;
        if(rank[i_p] > rank[j_p])            
            root[j_p] = i_p;
        else if(rank[j_p] > rank[i_p])            
           root[i_p] = j_p;
        else{
            root[j_p] = i_p;
            rank[i_p]++;
        }
    }
    
    public int findCircleNum(int[][] isConnected) {
        this.root = new int[isConnected.length];    
        this.rank = new int[isConnected.length];
        Arrays.fill(root, -1);
        
        for(int i = 0; i<isConnected.length; i++){
            rank[i] = 1;
        }
        
        for(int i = 0; i < isConnected.length; i++){
            for(int j = 0; j < isConnected[0].length; j++){
                if(i != j && isConnected[i][j] == 1){
                    union(i,j);
                }
            }
        }
        
        int countSteps = 0;
        for(int i = 0; i < root.length; i++){
            if(root[i] == -1){
                countSteps++;
            }
        }
        return countSteps;
    }
}