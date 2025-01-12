//link : https://leetcode.com/problems/shifting-letters-ii/description/?envType=daily-question&envId=2025-01-05

//code

class Solution {
    public String shiftingLetters(String s, int[][] shifts) {
        int size = s.length();
        int track[] = new int[size+1];
        for(int shift[] : shifts){
            int dir = shift[2];
            if(dir == 1){
                track[shift[0]]++;
                track[shift[1]+1]--;
            }else{
                track[shift[0]]--;
                track[shift[1]+1]++;
            }
        }   

        //get the actual diff
        for(int i = 1; i <= size; i++){
            track[i] += track[i-1];
        }

        StringBuilder sb = new StringBuilder();

        for(int i = 0; i < size; i++){

            int count = track[i] % 26;
            //this is how we do the reminder of negative value
            if(count < 0){
                count += 26;
            }
            int ind = (s.charAt(i) - 'a' + count)%26;
            char newChar = (char)(ind + 'a');
            sb.append(newChar);
        }
        return sb.toString();

    }
}