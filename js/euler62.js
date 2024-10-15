function euler62(){
    // a cube must have at least 3 digits to have 5 or more permutations
    var maxLen = 3;
    var minCube = Number.MAX_VALUE;
    while (minCube == Number.MAX_VALUE){
        // group cubes by sorted digit strings
        let cubeDigits = new Map();
        for (let n = Math.ceil(Math.cbrt(10 ** (maxLen - 1))); n <= Math.floor(Math.cbrt(10 ** maxLen)); n++){
            let cube = n ** 3;
            // get sorted digit string and store as key in map
            let digits = cube.toString().split('').sort().join('');
            if (!cubeDigits.has(digits)){
                cubeDigits.set(digits, new Set());
            }
            cubeDigits.get(digits).add(cube);
        }
        for (let cubes of cubeDigits.values()){
            if (cubes.size == 5){
                // find minimum cube in cubes and update minCube
                minCube = Math.min(minCube, ...cubes);
            }
        }
        maxLen++;
    }
    return minCube;
}

console.log(euler62());
