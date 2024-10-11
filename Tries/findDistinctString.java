//https://www.naukri.com/code360/problems/count-distinct-substrings_985292?utm_source=youtube&utm_medium=affiliate&utm_campaign=striver_tries_videos&leftPanelTabValue=SUBMISSION

//code
 public class Solution 
{
    public static class TrieNode{
        public TrieNode children[];
        
        public TrieNode(){
            children = new TrieNode[26];
        }
    }

    public static TrieNode root;
    
    public static int countDistinctSubstrings(String s) 
    {
        root = new TrieNode();
        int count = 0;
        int n = s.length();
        
        for(int i = 0; i < n; i++){
            count += insert(s, i);
        }
        return count + 1; 
    }

    public static int insert(String s, int start){
        TrieNode node = root;
        int count = 0;
        
        for(int i = start; i < s.length(); i++){
            char ch = s.charAt(i);
            int ind = ch - 'a';
            if(node.children[ind] == null){
                node.children[ind] = new TrieNode();
                count++; 
            }
            node = node.children[ind];
        }
        return count;
    }
}
