function euler43(){
  // abcdefghij
  // bcd % 2 = 0, cde % 3 = 0,
  // def % 5 = 0, % efg % 7 = 0,
  // fgh % 11 = 0, ghi % 13 = 0,
  // hij % 17 = 0
  
  // def % 5 = 0
  // f = 0, 5
  // f = 0: 0gh % 11 = 0
  // gh = 11, 22, 33, 44, 55, 66, 77, 88, 99
  // all repeating digits, f cannot be 0
  
  // f = 5: 5gh % 11 = 0
  // fgh = 506, 517, 528, 539, 561, 572, 583, 549, ghi % 13 = 0
  // 06i % 13 = 0: i = 5, but 5 is already assigned to f
  // 17i % 13 = 0: no solution
  // 28i % 13 = 0: i = 6
  // 39i % 13 = 0: i = 0
  // 72i % 13 = 0: i = 8
  // 83i % 13 = 0: i = 2
  // 49i % 13 = 0: i = 4 (duplicate of g)
  
  // fghi = 5286, 5390, 5728, 5832, hij % 17 = 0
  // 86j % 17 = 0: j = 7
  // 90j % 17 = 0: j = 1
  // 28j % 17 = 0: j = 9
  // 32j % 17 = 0: j = 3 (duplicate of h)
  
  // fghij = 52867, 53901, 57289, efg % 7 = 0
  // e52 % 7 = 0: e = 2 (duplicate of g), 9
  // e53 % 7 = 0: e = 5 (duplicate of f)
  // e57 % 7 = 0: e = 3
  
  // efghij = 952867, 357289
  // bcd % 2 = 0, d % 2 = 0
  // d952867: d = 0, 4
  // d357289: d = 0, 4, 6
  
  // defghij = 0952867, 4952867, 0357289, 4357289, 6357289, cde % 3 = 0
  // c0952867: c = 3
  // c4952867: no solution (c = 2, 5, 8, all duplicates)
  // c0357289: c = 6 (3, 9 are duplicates)
  // c4357289: no solution (c = 2, 5, 8, all duplicates)
  // c6357289: c = 0 (3, 6, 9 are duplicates)
  
  // cdefghij: 30952867, 60357289, 06357289
  // no remaining constraints, remaining digits 1, 4 can be put in any order
  // ab = 14, 41
  
  var prefixes = ["14", "41"];
  var suffixes = ["30952867", "60357289", "06357289"];
  var res = 0;
  for (let prefix of prefixes){
    for (let suffix of suffixes){
      res += Number(prefix + suffix);
    }
  }
  return res;
}

console.log(euler43());
