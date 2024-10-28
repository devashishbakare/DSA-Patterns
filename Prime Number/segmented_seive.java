/*

## Segmented Sieve :

- Get the prime number till √R
- From that √R isPrime[] array, you can create the rangePrime[]
- Important things
    - boolean rangePrime[] = new boolean[**(int)(R-L+1)**];
    - long j = **Math.max(i*i, (L+i-1)/i*i )**
    - if**(L == 1)** rangePrime[0] = false;

here Idea is do not calulate the prime number till n, take a square root of n -> here R
and with his reference draw all the other prime number
this approatch will be use when input size is near 10^9 -> 10^14

*/

import java.util.*;
class HelloWorld {
     public static void main(String args[]) {
      
      List<Long> prime = giveMePrime(100, 1000);
      for(long p : prime) System.out.print(p + " ");
      
    }
    public static List<Long> giveMePrime(long L, long R){
      
      int sqrt = (int)Math.sqrt(R);
      
      boolean isPrime[] = getPrime(sqrt);
      
      boolean highRangePrime[] = getRangePrime(L, R, isPrime);
      
      List<Long> store = new ArrayList<>();
      for(int i = 0; i < highRangePrime.length; i++) if(highRangePrime[i] == true) {
              long val = L+i;
              store.add(val);
      }
      
      return store;
      
    }
    
    public static boolean[] getPrime(int R){
        
       
        boolean prime[] = new boolean[R+1];
        Arrays.fill(prime, true);
        
        prime[0] = false;
        prime[1] = false;
        
        for(int i = 2; i*i <= R; i++){
            if(prime[i]){
                for(int j = i * i; j <= R; j += i){
                    prime[j] = false;
                }
            }
        }
        
        return prime;
    }
    
    public static boolean[] getRangePrime(long L, long R, boolean prime[]){
        
        int len = (int)(R-L+1);
        boolean rangePrime[] = new boolean[len];
        Arrays.fill(rangePrime, true);
        if(L == 1) rangePrime[0] = false;
        
        for(long i = 2; i*i <= R; i++){
            if(prime[(int)i]){
                for(long j = Math.max(i*i, (L+i-1)/i*i); j <= R; j += i){
                    rangePrime[(int)(j-L)] = false;
                }
            }
        }
        
        return rangePrime;
    }
}
