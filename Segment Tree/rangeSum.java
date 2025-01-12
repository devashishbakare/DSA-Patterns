//link : https://leetcode.com/problems/range-sum-query-mutable/description/

//code

class SegmentTree{

    public int n;
    public int tree[];

    public SegmentTree(int n, int arr[]){
        this.n = n;
        tree = new int[4 * n];
        buildTree(arr, 0, 0, n-1);
    }

    public void buildTree(int arr[], int node, int left, int right){

        if(left == right){
            tree[node] = arr[left];
        }else{
            int mid = left + (right-left)/2;
            int leftTree = 2 * node + 1;
            int rightTree = 2 * node + 2;

            buildTree(arr, leftTree, left, mid);
            buildTree(arr, rightTree, mid+1, right);
            
            tree[node] = tree[leftTree] + tree[rightTree];
        }
    }

    public int rangeSum(int left, int right){
        return getRangeSum(0, 0, n-1, left, right);
    }

    public int getRangeSum(int node, int left, int right, int rLeft, int rRight){

        //completly out of the range
        if(left > rRight || right < rLeft) return 0;

        //completly in range 
        if(left >= rLeft && right <= rRight){
            return tree[node];
        }

        //overlap of one of the side
            //side which has outside they return 0
            //side which is overlap that will return the sum of that overlap part

        int mid = left + (right-left)/2;
        int leftTree = 2 * node + 1;
        int rightTree = 2 * node + 2;


        int leftSum = getRangeSum(leftTree, left, mid, rLeft, rRight);
        int rightSum = getRangeSum(rightTree, mid+1, right, rLeft, rRight);

        return leftSum + rightSum;

    }

    public void update(int ind, int value){
        updateTree(0, 0, n-1, ind, value);
    }
    
    public void updateTree(int node, int left, int right, int ind, int value){

        if(left == right){
            tree[node] = value;
        }else{
            int mid = left + (right-left)/2;
            int leftTree = 2 * node + 1;
            int rightTree = 2 * node + 2;

            if(ind <= mid){
                updateTree(leftTree, left, mid, ind, value);
            }else{
                updateTree(rightTree, mid+1, right, ind, value);
            }
            
            tree[node] = tree[leftTree] + tree[rightTree];
        }
    }
}

class NumArray {
    public SegmentTree seg;
    public NumArray(int[] nums) {
     seg = new SegmentTree(nums.length, nums);   
    }
    
    public void update(int index, int val) {
        seg.update(index, val);
    }
    
    public int sumRange(int left, int right) {
        return seg.rangeSum(left, right);
    }
}
