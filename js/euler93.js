function euler93(){
    let maxStreak = 0;
    let res = "";
    let opsList = generateOps();
    let combs = generateCombs([0, 1, 2, 3, 4, 5, 6, 7, 8, 9], 4);
    let groups = [
        "xoxoxox", "(xox)oxox", "xo(xox)ox", "xoxo(xox)", "(xox)o(xox)",
        "(xoxox)ox", "((xox)ox)ox", "(xo(xox))ox",
        "xo(xoxox)", "xo((xox)ox)", "xo(xo(xox))"
    ];
    for (let comb of combs){
        let perms = generatePerms(comb);
        let results = getResults(perms, opsList, groups);
        let streak = getStreak(results);
        if (streak > maxStreak){
            maxStreak = streak;
            res = comb.join('');
        }
    }
    return res;
}

function generateOps(){
    const ops = ['+', '-', '/', '*'];
    const res = [];
    for (let x of ops){
        for (let y of ops){
            for (let z of ops){
                res.push([x, y, z]);
            }
        }
    }
    return res;
}

function generateCombs(nums, r){
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

function generatePerms(nums){
    const perms = [];
    var seen = new Array(nums.length).fill(false);
    function backtrack(perm){
        if (perm.length == nums.length){
            perms.push([...perm]);
            return;
        }
        for (let i = 0; i < nums.length; i++){
            if (!seen[i]){
                perm.push(nums[i]);
                seen[i] = true;
                backtrack(perm);
                perm.pop();
                seen[i] = false;
            }
        }
    }
    backtrack([]);
    return perms;
}

function getResults(perms, ops, groups){
    const results = new Set();
    for (let perm of perms){
        for (let group of groups){
            for (let op of ops){
                let i = 0, j = 0;
                let resStr = "";
                for (let c of group){
                    if (c == "x") resStr += perm[i++];
                    else if (c == "o") resStr += op[j++];
                    else resStr += c;
                }
                let res = eval(resStr);
                if (isFinite(res) && res > 0 && res == Math.floor(res)) results.add(res);
            }
        }
    }
    return results;
}

function getStreak(vals){
    let streak = 0;
    while (vals.has(streak + 1)) streak++;
    return streak;
}

console.log(euler93());
