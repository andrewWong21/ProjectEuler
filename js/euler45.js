function euler45(){
  // H_1 = 1 = T_1
  // H_2 = 6 = T_3
  // H_3 = 15 = T_5
  // H_n = T_(2n - 1)
  // H_n = n * (2n - 1) = 2n^2 - n
  // T_(2n-1) = (2n - 1) * (2n) / 2 = (2n - 1) * n = 2n^2 - n
  // all hexagonal numbers are triangular
  
  // generate successive hexagonal numbers and check if they are pentagonal
  var res = 0, n = 144; // H_143 is pentagonal, find next
  while (res == 0){
    let hex = getHexagon(n);
    if (isPentagonal(hex)) res = hex;
    n++;
  }
  return res;
}

function getHexagon(n){
  return 2 * n * n - n;
}

function isPentagonal(p){
  // p = n(3n - 1) / 2
  // 3n^2 - n - 2p = 0
  // n = (1 +/- sqrt(24p + 1)) / 6
  // n > 0, n = (sqrt(24p + 1) + 1) / 6
  let n = (Math.sqrt(24 * p + 1) + 1) / 6;
  return n == Math.floor(n);
}

console.log(euler45());
