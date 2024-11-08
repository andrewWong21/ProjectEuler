function euler87(){
    let limit = 5e7;
    const sieved = new Array(Math.floor(Math.sqrt(limit))).fill(false);
    const squares = [], cubes = [], fourths = [];
    for (let i = 2; i < sieved.length; i++){
        if (!sieved[i]){
            squares.push(i ** 2);
            if (i ** 3 < limit) cubes.push(i ** 3);
            if (i ** 4 < limit) fourths.push(i ** 4);
            for (let j = 2 * i; j < sieved.length; j += i){
                sieved[j] = true;
            }
        }
    }
    const sums = new Set();
    for (let fourth of fourths){
        for (let cube of cubes){
            if (fourth + cube >= limit) break;
            for (let square of squares){
                let total = fourth + cube + square;
                if (total >= limit) break;
                sums.add(total);
            }
        }
    }
    return sums.size;
}

console.log(euler87());
