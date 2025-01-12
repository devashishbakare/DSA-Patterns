//link : https://leetcode.com/problems/range-addition/description/
//https://www.geeksforgeeks.org/print-modified-array-multiple-array-range-increment-operations/

//code

int diff[] = new int[n+1];

for(int query[] : queries){
    int start = query[0];
    int end = query[1];
    int d = query[2];
    diff[start] += d;
    diff[end+1] -= d; 
}

//comulative sum will give you exact diff
for(int i = 1; i <= n; i++){
    arr[i] += arr[i-1];
}

return arr;