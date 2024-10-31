function euler79(){
    const codes = [
        "319", "680", "180", "690", "129", "620", "762", "689", "762", "318",
        "368", "710", "720", "710", "629", "168", "160", "689", "716", "731",
        "736", "729", "316", "729", "729", "710", "769", "290", "719", "680",
        "318", "389", "162", "289", "162", "718", "729", "319", "790", "680",
        "890", "362", "319", "760", "316", "729", "380", "319", "728", "716"
    ];
    // directed graph of digits and their following digits
    const order = new Map();
    for (const code of codes){
        for (let i = 0; i < code.length; i++){
            if (!order.has(code[i])){
                order.set(code[i], new Set());
            }
            // add subsequent digits to digit i's set
            for (let j = i + 1; j < code.length; j++){
                order.get(code[i]).add(code[j]);
            }
        }
    }
    let digits = Array.from(order.keys());
    // sort digits by out-degree (number of following digits)
    digits.sort((a, b) => (order.get(b).size - order.get(a).size));
    return digits.join('');
}

console.log(euler79());
