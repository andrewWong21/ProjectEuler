function euler01(){
    nums3 = Math.floor((1000 - 1) / 3);
    mult3 = 3 * nums3 * (nums3 + 1) / 2;
    nums5 = Math.floor((1000 - 1) / 5);
    mult5 = 5 * nums5 * (nums5 + 1) / 2;
    nums15 = Math.floor((1000 - 1) / 15);
    mult15 = 15 * nums15 * (nums15 + 1) / 2;
    return mult3 + mult5 - mult15;
}

console.log(euler01());
