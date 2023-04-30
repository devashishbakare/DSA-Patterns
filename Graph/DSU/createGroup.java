link : https://leetcode.com/problems/similar-string-groups/description/

code : Understand question correctly here, why we need check two string, understand this

class DSU{
    
    public int parent[];
    public int height[];
    
    public DSU(int n){
        parent = new int[n];
        height = new int[n];
        Arrays.fill(parent, -1);
        Arrays.fill(height, 1);
    }
    
    public int find(int node){
        if(parent[node] == -1) return node;
        return parent[node] = find(parent[node]);
    }
    
    public void union(int node1, int node2){
        
        if(node1 != node2){
            
            if(height[node1] < height[node2]){
                parent[node1] = node2; 
            }else if(height[node1] > height[node2]){
                parent[node2] = node1;
            }else{
                parent[node2] = node1;
                height[node1]++;
            }
        }
        return;
    }
}

class Solution {
    public boolean check(String strs[], int ind1, int ind2) {
        int count = 0;
        for (int i = 0; i < strs[ind1].length(); i++) {
            if (strs[ind1].charAt(i) != strs[ind2].charAt(i)) {
                count++;
            }
        }
        return count == 0 || count == 2;
    }

    public int numSimilarGroups(String[] strs) {
        int n = strs.length;
        DSU dsu = new DSU(n);
        int count = n;
       
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (check(strs, i, j)){
                    int parent1 = dsu.find(i);
                    int parent2 = dsu.find(j);

                    if(parent1 != parent2){
                        count--;
                        dsu.union(parent1, parent2);
                    }
                    
                }
            }
        }

        return count;
    }
}