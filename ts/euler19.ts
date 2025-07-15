function countingSundays(): number {
    let res: number = 0;
    let date = new Date("1901-01-01T00:00:00");
    while (date.getFullYear() < 2001) {
        if (date.getDay() == 0) res++;
        date.setMonth(date.getMonth() + 1);
    }
    return res;
}

console.log(countingSundays());
