var count = 0;
function euler73(){
    getMediant(1, 3, 1, 2);
    return count;
}

function getMediant(a, b, c, d){
    if (b + d > 12_000) return;
    count++;
    getMediant(a + c, b + d, c, d);
    getMediant(a, b, a + c, b + d);
}

console.log(euler73());
