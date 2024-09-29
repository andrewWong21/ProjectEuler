function euler47(){
  var streak = 0, n = 2;
  var primes = new Set();
  while (true){
    if (!isPrime(n)){
      // n is composite, count number of distinct prime factors
      let num = n, factors = new Set();
      for (let prime of primes){
        while (num > 1 && num % prime == 0){
          factors.add(prime);
          num /= prime;
        }
        if (num == 1) break;
      }
      if (factors.size == 4){
        streak++;
        if (streak == 4) return n - 3;
      }
      else streak = 0;
    }
    else{
      // n is prime, cache prime and reset streak 
      primes.add(n);
      streak = 0;
    }
    n++;
  }
}

function isPrime(n){
  for (let i = 2; i * i <= n; i++){
    if (n % i == 0) return false;
  }
  return true;
}

console.log(euler47());
