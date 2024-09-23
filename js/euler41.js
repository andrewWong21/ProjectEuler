var nums = [7, 6, 5, 4, 3, 2, 1];
var seen = new Array(nums.length).fill(false);
var perms = [];
var perm = [];
function euler41(){
  // a 1-9 pandigital number has a digital sum of 45, so it is divisible by 3
  // a 1-8 pandigital number has a digital sum of 36, so it is divisible by 3
  // a 1-7 pandigital number has a digital sum of 28, so it is not divisible by 3
  // a pandigital prime may have at most 7 digits
  
  // approach 1: generate 7-digit primes and check for pandigitalness
  // start with list of 10 million booleans and check 580,000 7-digit primes
  
  // approach 2: generate permutations of 7-digit pandigital integers and check for primality
  // generate list of 5040 permutations in reverse lexicographical order
  backtrack(0);
  for (let p of perms){
    if (isPrime(p)) return p;
  }
  return 0;
}

// generate permutations
function backtrack(idx){
  if (idx == nums.length){
    perms.push(Number(perm.join("")));
    return;
  }
  for (let i = 0; i < nums.length; i++){
    if (!seen[i]){
      seen[i] = true;
      perm.push(nums[i]);
      backtrack(idx + 1);
      perm.pop();
      seen[i] = false;
    }
  }
  return;
}

function isPrime(n){
  for (let i = 2; i * i <= n; i++){
    if (n % i == 0) return false;
  }
  return true;
}

console.log(euler41());
