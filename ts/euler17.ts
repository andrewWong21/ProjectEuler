function numberLetterCounts(): number {
    let res: number = 0;
    res += "onetwothreefourfivesixseveneightnine".length * 190;
    res += "teneleventwelvethirteenfourteenfifteensixteenseventeeneighteennineteen".length * 10;
    res += "twentythirtyfortyfiftysixtyseventyeightyninety".length * 100;
    res += "hundred".length * 900;
    res += "and".length * 891;
    res += "onethousand".length;
    return res;
}

console.log(numberLetterCounts());
