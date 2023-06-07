problem : https://leetcode.com/problems/minimum-flips-to-make-a-or-b-equal-to-c/description/


Note : 

-if we want most significant bit of oprand then we can do 
    a = 5 -> 0101 & 1 -> 1, basically we got the first value of a binary
- we can use to check whether if this value if even or odd
    example : 

                 8421 if most significant bit is 0 then its even, if its 1 then its odd 
        a = 4 -> 0100 & 1 => 0 then its even  
        a = 5 -> 0101 % 1 => 1 then its odd 


-> if you do left shift by 1 then result will be multiply by 2 
                                      8421 
    example ->    a = 5 -> 0101 << 1  1010 -> 10  

-> if you do right shift by 1 then result will be divide by 2 
                        8421    8421
    example -> a = 6    0110 >> 0011 -> 3 so we divide by 2

code : 
class Solution {
    public int minFlips(int a, int b, int c) {
        
        int result = 0;

        while(a != 0 || b != 0 || c != 0 ){

            if( (c & 1) == 1){
                if( (a & 1) == 0 && (b & 1) == 0){
                    result++;
                }
            }else{
                result += (a & 1) + (b & 1);
            }

            a = a >> 1;
            b = b >> 1;
            c = c >> 1;

        }
        return result;
    }
}