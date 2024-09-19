function euler36(){
    var res = 0;
    for (let i = 1; i < 1 _000_000; i++) {
        // Number.toString() converts number to base 10 representation by default
        // specifying radix of 2 generates binary representation of number
        if (isPalindrome(i.toString()) && isPalindrome(i.toString(2))) {
            res += i;
        }
    }
    return res;
}

function isPalindrome(s){
    // split string by character, reverse character array and rejoin into string
    // check if string and reversed string are the same
    return s == s.split('').reverse().join('');
}

console.log(euler36());
