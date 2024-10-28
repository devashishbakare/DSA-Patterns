int divisor[] = new int[n+1];
for(int i = 2; i * i <= n; i++){
    if(divisor[i] == 0){
        for(int j = i; j <= n; j += i){
            divisor[j]++;
        }
    }
}