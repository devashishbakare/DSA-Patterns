link : https://leetcode.com/problems/reorganize-string/description/

code : class Solution {
    public String reorganizeString(String s) {
        Map<Integer,Integer> map =new HashMap<>();
        StringBuilder result=new StringBuilder();
        for(char ch:s.toCharArray()) {
            int key=ch;
            map.put(key,map.getOrDefault(key,0)+1);
        }
        PriorityQueue<int[]> pq=new PriorityQueue<int[]>((a,b) -> Integer.compare(b[1],a[1]));
        for(Integer key:map.keySet()) {
            pq.add(new int[]{key,map.get(key)});
        }
        while(pq.size()>1) {
            int[] first=pq.poll();
            int[] second=pq.poll();
            first[1]--;
            second[1]--;
            result.append((char)first[0]);
            result.append((char)second[0]);
            if(first[1]>0) {
                pq.add(first);
            }
            if(second[1]>0) {
                pq.add(second);
            }
        }
        if(!pq.isEmpty()) {
            if(pq.peek()[1]>1) {
                return "";
            } else {
                result.append((char)pq.peek()[0]);
            }
        }
        return result.toString();
    }
}