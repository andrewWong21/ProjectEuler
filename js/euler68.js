var nums = [1, 2, 3, 4, 5, 6, 7, 8, 9, 10];
var seen = new Array(nums.length).fill(false);
var perm = [], perms = [];

function euler68(){
    var res = 0;
    backtrack(0);
    for (let p of perms){
        if(isValidRing(p)) res = Math.max(res, Number(stringifyRing(p)));
    }
    return res;
}

function backtrack(idx){
    if (idx == nums.length){
        perms.push(Array.from(perm));
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
}

function isValidRing(p){
    let inner = p.slice(0, 5);
    if (inner.includes(10)) return false;
    let outer = p.slice(5);
    // valid ring must start with numerically lowest external node
    if (outer[0] != Math.min(...outer)) return false;
    let sum = inner[0] + inner[1] + outer[0];
    for (let i = 0; i < 5; i++){
        let curr = inner[i] + inner[(i + 1) % 5] + outer[i];
        if (curr != sum) return false;
    }
    return true;
}

function stringifyRing(p){
    let inner = p.slice(0, 5);
    let outer = p.slice(5);
    let str = "";
    for (let i = 0; i < 5; i++){
        str += outer[i].toString() + inner[i].toString() + inner[(i + 1) % 5].toString();
    }
    return str;
}

console.log(euler68());
