link : https://leetcode.com/problems/remove-duplicate-letters/description/?envType=daily-question&envId=2023-09-26
editorial : https://www.youtube.com/watch?v=j313ttNJjo0
code : 
class Solution {
    public String removeDuplicateLetters(String s) {
        int size = s.length();
        int freq[] = new int[26];
        for(char ch : s.toCharArray()) freq[ch-'a']++;
        Stack<Character> stack = new Stack();
        int vis[] = new int[26];

        for(int i = 0; i < size; i++){
            char ch = s.charAt(i);
            if(vis[ch-'a'] == 0){

                while(stack.size() > 0 && ch < stack.peek() && freq[stack.peek()-'a'] > 0){
                    vis[stack.peek() -'a'] = 0;
                    stack.pop();
                }

                stack.push(ch);
                freq[ch-'a']--;
                vis[ch-'a'] = 1;
            }else{
                freq[ch-'a']--;
            }
        }
        StringBuilder sb = new StringBuilder();
        while(stack.size() > 0){
            sb.append(stack.pop());
        }
        sb.reverse();
        return sb.toString();
    }
}