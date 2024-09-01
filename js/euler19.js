function euler19(){
    var res = 0;
    for (let year = 1901; year <= 2000; year++){
        for (let month = 1; month <= 12; month++){
            let components = [year, month, 1];
            let first = new Date(components.join("-"));
            // Date.getDay() returns day of week
            // Sunday is first day of week in JS (0)
            if (first.getDay() == 0)  res++;
        }
    }
    return res;
}

console.log(euler19());
