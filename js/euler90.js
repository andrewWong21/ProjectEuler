function euler90(){
    const combs = generateCombinations([0, 1, 2, 3, 4, 5, 6, 7, 8, 9], 6);
    const seen = new Set();
    let count = 0;
    for (let i = 0; i < combs.length; i++){
        for (let j = i; j < combs.length; j++){
            if (showsAllSquares(combs[i], combs[j])) count++;
        }
    }
    return count;
}

function generateCombinations(nums, r){
    const combs = [];
    function backtrack(start, curr){
        if (curr.length == r){
            combs.push([...curr]);
            return;
        }
        for (let i = start; i < nums.length; i++){
            curr.push(nums[i]);
            backtrack(i + 1, curr);
            curr.pop();
        }
    }
    backtrack(0, []);
    return combs;
}

function showsAllSquares(arr1, arr2){
    const s1 = new Set(arr1);
    const s2 = new Set(arr2);
    if (s1.has(6) || s1.has(9)){
        s1.add(6);
        s1.add(9);
    }
    if (s2.has(6) || s2.has(9)){
        s2.add(6);
        s2.add(9);
    }
    for (let i = 1; i <= 9; i++){
        let n = i * i;
        let x = Math.floor(n / 10);
        let y = n % 10;
        if (!(s1.has(x) && s2.has(y)) && !(s1.has(y) && s2.has(x))) return false;
    }
    return true;
}

console.log(euler90());
