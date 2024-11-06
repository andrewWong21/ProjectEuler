function euler85(){
    let area = 0, bestDiff = 2_000_000;
    for (let length = 1; length < 100; length++){
        for (let width = 1; width < 100; width++){
            let count = 0;
            for (let i = 1; i <= length; i++){
                for (let j = 1; j <= width; j++){
                    // number of rectangles of dimensions i*j
                    // than can fit in grid with dimensions length*width
                    count += (length - i + 1) * (width - j + 1);
                }
            }
            let diff = Math.abs(2e6 - count);
            // closer solution found, update area of grid
            if (diff < bestDiff){
                area = length * width;
                bestDiff = diff;
            }
        }
    }
    return area;
}

console.log(euler85());
