function euler91(){
    const gridSize = 50;
    const triangles = new Set();
    for (let x1 = 0; x1 <= gridSize; x1++){
        for (let y1 = 0; y1 <= gridSize; y1++){
            if (x1 == 0 && y1 == 0) continue;
            for (let x2 = 0; x2 <= gridSize; x2++){
                for (let y2 = 0; y2 <= gridSize; y2++){
                    if ((x2 == x1 && y2 == y1) || (x2 == 0 && y2 == 0)) continue;
                    let str = [x1, y1, x2, y2].join(' ');
                    if (triangles.has([x2, y2, x1, y1].join(' '))) continue;
                    if (isRightTriangle(x1, y1, x2, y2)) triangles.add(str);
                }
            }
        }
    }
    return triangles.size;
}

function isRightTriangle(x1, y1, x2, y2){
    // calculate squared side lengths
    const a = x1 * x1 + y1 * y1;
    const b = x2 * x2 + y2 * y2;
    const c = (x2 - x1) ** 2 + (y2 - y1) ** 2;
    // check if the Pythagorean identity holds for any combination of squared lengths
    return (a + b == c) || (a + c == b) || (b + c == a);
}

console.log(euler91());
