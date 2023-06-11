link : https://leetcode.com/problems/snapshot-array/description/

code : 

class SnapshotArray {

    public TreeMap<Integer, Integer> store[];
    public int snapId = 0;
    public SnapshotArray(int length) {
        store = new TreeMap[length];
        int i = 0;
        while( i < length){
            store[i] = new TreeMap<>();
            store[i].put(0, 0);
            i++;
        }
    }
    
    public void set(int index, int val) {
        store[index].put(snapId, val);
    }
    
    public int snap() {
        return snapId++;
    }
    
    public int get(int index, int snap_id) {
        return store[index].floorEntry(snap_id).getValue();
    }
}

