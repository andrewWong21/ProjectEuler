function euler46(){
  var res = 0, n = 35;
  while (res == 0){
    let isSum = false;
    // n must be an odd composite
    if (isPrime(n)){
      n += 2;
      continue;
    }
    // n = p + 2r^2, n - 2r^2 = p
    for (let r = 1; 2*r*r < n; r++){
      // check if n - 2r^2 is prime
      if (isPrime(n - 2*r*r)){
        // n can be written as a sum of a prime and twice a square
        isSum = true;
        break;
      }
    }
    if (!isSum) res = n;
    n += 2;
  }
  return res;
}

function isPrime(n){
  if (n == 1) return false;
  for (let i = 2; i*i <= n; i++){
    if (n % i == 0) return false;
  }
  return true;
}

console.log(euler46());
