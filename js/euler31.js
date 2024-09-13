function euler31(){
    var dp = new Array(201).fill(0);
    dp[0] = 1;
    for (let coin of [1, 2, 5, 10, 20, 50, 100, 200]){
        for (let i = coin; i < dp.length; i++){
            dp[i] += dp[i - coin];
        }
    }
    
    return dp[200];
}

console.log(euler31());
