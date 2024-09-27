function euler44(){
    // P_j = j * (3 * j - 1) / 2 = (3j^2 - j) / 2
    // P_k = k * (3 * k - 1) / 2 = (3k^2 - k) / 2
    
    // k = j + x
    // P_k = (3(j + x)^2 - (j + x)) / 2 = (3(j^2 + 2jx + x^2) - j - x)) / 2
    // P_k = (3j^2 + 6jx + 3x^2 - j - x) / 2
    
    // D = P_k - P_j = (3j^2 + 6jx + 3x^2 - j - x - 3j^2 + j) / 2
    // D = (6jx + 3x^2 - x) / 2
    // P_x = (3x^2 - x) / 2
    // D = 6jx / 2 + (3x^2 - x) / 2 = 3jx + P_x
    // j = (D - P_x) / (3x)
    
    var res = 0, n = 4;
    while (res == 0){
      let pentD = getPentagon(n);
      
      // if j > 0, then P_x < D, so x < n
      for (let x = 1; x < n; x++){
        let pentX = getPentagon(x);
        
        if ((pentD - pentX) % (3*x) == 0){
          let j = (pentD - pentX) / (3*x);
          let pentJ = getPentagon(j);
          let pentK = pentJ + pentD;
          // by construction, difference of pentJ and pentK is pentagonal
          // pentD = pentK - pentJ
          // pentJ + pentK = 2 * pentJ + pentD
          
          // check if sum of pentJ and pentK is also pentagonal
          if (isPentagonal(pentJ + pentK)){
            // both sum and difference of pentJ and pentK are pentagonal
            res = pentD;
            break;
          }
        }
      }
      // continue with next smallest candidate value of pentD - next pentagonal number
      n++;
    }
    return res;
}

function isPentagonal(p){
  // p = n*(3n - 1)/2
  // 3n^2 - n - 2p = 0
  // n = (1 +/- sqrt(1 + 24p)) / 6
  // n = (1 + sqrt(24p + 1)) / 6
  let n = (Math.sqrt(24 * p + 1) + 1) / 6;
  return n == Math.floor(n);
}

function getPentagon(n){
  return n * (3 * n - 1) / 2;
}

console.log(euler44());
