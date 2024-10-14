const primesSet = new Set();

function euler60(){
  var sieved = new Array(9_000).fill(false);
  // separate primes into two groups
  // those congruent to 1 mod 3, and those congruent to 2 mod 3
  // concatenating a prime from one group with a prime from the other
  // results in a composite number with a digital sum divisible by 3
  var primes1 = new Set();
  var primes2 = new Set();
  for (let i = 2; i < sieved.length; i++){
    if (!sieved[i]){
      for (let j = 2 * i; j < sieved.length; j += i){
        sieved[j] = true;
      }
      primesSet.add(i);
      // concatenating 2 or 5 to the end of another prime will always result in a composite
      if (i == 2 || i == 5) continue;
      if (i == 3){
        // concatenating 3 with another prime will not change the result's congruency modulo 3
        primes1.add(i);
        primes2.add(i);
      }
      else if (i % 3 == 1) primes1.add(i);
      else if (i % 3 == 2) primes2.add(i);
    }
  }
  // no prime pair set of size 5 is generated from primes2
  //return Math.min(findSum(primes1), findSum(primes2));
  return findSum(primes1);
}

function findSum(primes){
  var res = Infinity;
  for (let a of primes){
    for (let b of primes){
      if (b <= a) continue;
      if (isConcatPrime(a, b)){
        for (let c of primes){
          if (c <= b) continue;
          if (isConcatPrime(a, c) && isConcatPrime(b, c)){
            for (let d of primes){
              if (d <= c) continue;
              if (isConcatPrime(a, d) && isConcatPrime(b, d) && isConcatPrime(c, d)){
                for (let e of primes){
                  if (e <= d) continue;
                  if (isConcatPrime(a, e) && isConcatPrime(b, e) && isConcatPrime(c, e) && isConcatPrime(d, e)){
                    console.log(a, b, c, d, e, a + b + c + d + e);
                    res = Math.min(res, a + b + c + d + e);
                  }
                }
              }
            }
          }
        }
      }
    }
  }
  return res;
}

function isConcatPrime(a, b){
  let ab = Number(a.toString() + b.toString());
  let ba = Number(b.toString() + a.toString());
  return isPrime(ab) && isPrime(ba);
}

function isPrime(n){
  if (primesSet.has(n)) return true;
  for (let i = 2; i * i <= n; i++){
    if (n % i == 0) return false;
  }
  return true;
}

console.log(euler60());
