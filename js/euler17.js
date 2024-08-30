function euler17(){
    var ones = "onetwothreefourfivesixseveneightnine";
    var tens = "twentythirtyfortyfiftysixtyseventyeightyninety";
    var teens = "teneleventwelvethirteenfourteenfifteensixteenseventeeneighteennineteen";
    
    var res = 0;
    // 100 times (100-199) plus 9 times (1, 21, 31, ... 91) for each group of 100
    res += 190 * ones.length;
    // 10 times for each group of 100 (20-29, 120-129, ..., 920-929)
    res += 100 * tens.length;
    // 1 time for each group of 100 (10, 110, 210, ..., 910)
    res += 10 * teens.length;
    // 100 times for each group of 100 (100-199, 200-299, ..., 900-999)
    res += 900 * "hundred".length;
    // 109 numbers (1-99, *00, and 1000) do not contain the word "and"
    res += 891 * "and".length;
    res += "onethousand".length;
    return res;
}

console.log(euler17());
