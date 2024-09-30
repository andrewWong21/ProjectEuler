function euler48(){
  var sum = 0;
  for (let i = 1; i <= 1000; i++){
    if (i % 10 == 0) continue;
    let pow = 1;
    for (let j = 1; j <= i; j++){
      pow = (pow * i) % 1e10;
    }
    sum = (sum + pow) % 1e10;
  }
  return sum;
}

console.log(euler48());
