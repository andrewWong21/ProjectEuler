function euler32(){
    var products = new Set();
    // pandigital product identity has 9 digits in total (1-9)
    // 2-digit * 3-digit = 4-digit (9 digits total)
    // 11 and 99 have repeating digits
    // 100-123 and 988-999 have repeating digits or 0
    for (let a = 12; a <= 98; a++){
        for (let b = 123; b <= 987; b++){
            let iden = "" + a + b + (a * b);
            // split string into character array, sort digits, rejoin into string
            let digits = iden.split("").sort().join("");
            if (digits === "123456789"){
                products.add(a * b);
            }
        }
    }
    // 1-digit * 4-digit = 4-digit (9 digits total)
    // 1000-1233 and 9877-9999 have repeating digits or 0
    for (let a = 2; a <= 9; a++){
        for (let b = 1234; b <= 9876; b++){
            let iden = "" + a + b + (a * b);
            let digits = iden.split("").sort().join("");
            if (digits === "123456789"){
                products.add(a * b);
            }
        }
    }
    var res = 0;
    for (let product of products) res += product;
    return res;
}

console.log(euler32());
