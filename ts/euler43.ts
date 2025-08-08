function substringDivisibility(): number {
    // abcdefghij
    // bcd % 2 = 0, cde % 3 = 0, def % 5 = 0, efg % 7 = 0
    // fgh % 11 = 0, ghi % 13 = 0, hij % 17 = 0

    // def % 5 = 0: f = 5 (f = 0 requires g = h for fgh % 11 = 0)
    // fgh = 506, 517, 528, 539, 561, 572, 583, 594

    // ghi % 13 = 0
    // 06i: 065, i = f = 5
    // 17i: no solution (169, 182)
    // 28i: 286
    // 39i: 390
    // 61i: 611 (i = h = 1)
    // 72i: 728
    // 83i: 832
    // 94i: 949, (i = g = 9)
    // fghi = 5286, 5390, 5728, 5832

    // hij % 17 = 0
    // 86j: 867
    // 90j: 901
    // 28j: 289
    // 32j: 323 (j = h = 3)
    // fghij = 52867, 53901, 57289

    // efg % 7 = 0
    // e52: 252 (e = g = 2), 952
    // e53: 553 (e = f = 5)
    // e57: 357
    // efghij: 952867, 357289

    // bcd % 2 = 0, d % 2 = 0
    // d952867: d = 0, 4
    // d357289: d = 0, 6
    // defghij: 0952867, 4952867, 0357289, 6357289

    // cde % 3 = 0
    // c0952867: c = 3
    // c4952867: c = 2, 5, 8 (all repeats)
    // c0357289: c = 6
    // c6357289: c = 0
    // cdefghij: 30952867, 60357289, 06357289

    // remaining digits: 1, 4
    // ab = 14, 41
    const prefixes: string[] = ["14", "41"];
    const suffixes: string[] = ["30952867", "60357289", "06357289"];
    let res: number = 0;
    for (let prefix of prefixes) {
        for (let suffix of suffixes) {
            res += Number(prefix + suffix);
        }
    }
    return res;
}

console.log(substringDivisibility());
