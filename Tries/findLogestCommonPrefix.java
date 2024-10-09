//https://www.naukri.com/code360/problems/complete-string_2687860?utm_source=youtube&utm_medium=affiliate&utm_campaign=striver_tries_videos&leftPanelTabValue=SUBMISSION

//code

import java.util.* ;
import java.io.*; 

class Solution {

  static class TreeNode {
    public TreeNode children[];
    public boolean isEnd;
    public TreeNode(){
      children = new TreeNode[26];
      isEnd = false;
    }
  }
  public static String completeString(int n, String[] a) {
    
    TreeNode root = new TreeNode();

    int max = -1;
    for(String word : a){
      insert(word, root);
    }
    String smallestString = "None";
    for(String word: a){
       if(checkLongestCount(word, root)){
         if(smallestString.equals("None") || word.length() > smallestString.length() || (word.length() == smallestString.length() && word.compareTo(smallestString) < 0)){
           smallestString = word;
         }
       }
    }
    return smallestString;
  }

  public static void insert(String s, TreeNode root){
      TreeNode node = root;
      for(char ch : s.toCharArray()){
        int ind = ch-'a';
        if(node.children[ind] == null){
          node.children[ind] = new TreeNode();
        }
        node = node.children[ind];
      }
      node.isEnd = true;
  }

  public static boolean checkLongestCount(String s, TreeNode root){
    TreeNode node = root;
    for(int i = 0; i < s.length(); i++){
      char ch = s.charAt(i);
      int ind = ch-'a';
      if(node.children[ind] == null || node.children[ind].isEnd == false){
        return false;
      }
      node = node.children[ind];
    }
    return true;
  }

}