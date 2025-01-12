//link : https://leetcode.com/problems/count-vowel-strings-in-ranges/description/?envType=daily-question&envId=2025-01-02

//code
class Solution {

    class SegmentTree{

        public int tree[];
        public int n;
        public int valid[];
        public SegmentTree(int valid[]){
            this.valid = valid;
            n = valid.length;
            tree = new int[4 * n];
            buildTree(0, 0, n-1);
        }

        public void buildTree(int node, int left, int right){

            if(left == right){
                tree[node] = valid[left];
            }else{
                int mid = left + (right-left)/2;
                int leftTree = 2 * node + 1;
                int rightTree = 2 * node + 2;

                buildTree(leftTree, left, mid);
                buildTree(rightTree, mid+1, right);

                tree[node] = tree[leftTree] + tree[rightTree];
            }
        }

        public int getSum(int node, int left, int right, int rLeft, int rRight){
            
            if(left > rRight || right < rLeft){
                return 0;
            }

            if(left >= rLeft && right <= rRight) return tree[node];

            int mid = left + (right-left)/2;
            int leftTree = 2 * node + 1;
            int rightTree = 2 * node + 2;

            int leftSum = getSum(leftTree, left, mid, rLeft, rRight);
            int rightSum = getSum(rightTree, mid+1, right, rLeft, rRight);

            return leftSum + rightSum;
        }

    }

    public int[] vowelStrings(String[] words, int[][] queries) {
        int size = words.length;
        int valid[] = new int[size];
        int ind = 0;
        for(String word : words){
            valid[ind++] = isValid(word) ? 1 : 0;
        }

        SegmentTree segmentTree = new SegmentTree(valid);
        int ans[] = new int[queries.length];
        ind = 0;
        for(int query[] : queries){
            ans[ind++] = segmentTree.getSum(0, 0, valid.length-1, query[0], query[1]);
        }

        return ans;
    }
    public boolean isValid(String word){
        Set<Character> set = new HashSet<>(Arrays.asList('a', 'e', 'i', 'o', 'u'));
        if(set.contains(word.charAt(0)) && set.contains(word.charAt(word.length()-1)) ) return true;
        return false;
    }
}