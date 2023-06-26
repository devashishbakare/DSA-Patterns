link : https://leetcode.com/problems/total-cost-to-hire-k-workers/description/

code : 

class Pair implements Comparable<Pair>{
    int cost;
    int ind;
    
    public Pair(int cost, int ind){
        this.cost = cost;
        this.ind = ind;
    }
    
    public int compareTo(Pair pair){
        if(this.cost != pair.cost){
            return this.cost-pair.cost;
        }else{
            return this.ind-pair.ind;
        }
    }
    
}

class Solution {
    public long totalCost(int[] costs, int k, int candidates) {
     
        int size = costs.length;
        int cand = candidates;
        PriorityQueue<Pair> pq = new PriorityQueue<>();
        int i = 0;
        int j = size-1;
        
        if(i == j) return costs[0];
        
        while(cand > 0 && i < j){
            cand--;
            pq.add(new Pair(costs[i], i));
            pq.add(new Pair(costs[j], j));
            i++;
            j--;
        }
        
        long sum = 0;
        while(k > 0 && i <= j ){
            k--;
            Pair node = pq.remove();
            sum += node.cost;
            
            if(node.ind < i){
                pq.add(new Pair(costs[i], i));
                i++;
            }else{
                pq.add(new Pair(costs[j], j));
                j--;
            }
            
        }
        
        while(k > 0 && pq.size() > 0){
            k--;
            Pair pair = pq.remove();
            sum += pair.cost;
        }
        
        return sum;
       
    }
}