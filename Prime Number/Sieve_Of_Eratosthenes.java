/*

## Prime number from the range ( Sieve Of Eratosthenes)
- Range < 10^9
- for loop of j will be start from i * i
- J loop will be incremented by i not just 1(j++)

here idea is to remove those who will not become the prime number, meaning 
remove who has more than 2 division
for example

if 2 is prime number then anything divisible by 2 will not be the prime number
eg : 4, 6, 8, 12....
same with 3
eg : 6, 9, 12, 15

Note : this approatch will be use when input size is < 10^9 if goes beyond you need to use the segmented seive

*/

class HelloWorld {
    
    public static void main(String[] args) {
        
        List<Integer> arr = getPrimeNumber(0, 100);
        for(int a : arr) System.out.print(a+" ");

    }
    
    public static List<Integer> getPrimeNumber(int start, int end){
        
        boolean isPrime[] = new boolean[end+1];
        for(int i = 0; i <= end; i++) isPrime[i] = true;
        
        isPrime[0] = false;
        isPrime[1] = false;
        //start with 2, 3.... i * i nothing but √end
        for(int i = 2; i * i <= end; i++){
            if(isPrime[i] == true){
                for(int j = i * i; j <= end; j += i){
                    isPrime[j] = false;
                }
            }
        }
        List<Integer> store = new ArrayList<>();
        for(int i = start; i <= end; i++){
            if(isPrime[i] == true) store.add(i);
        }
        
        return store;
    }
}

