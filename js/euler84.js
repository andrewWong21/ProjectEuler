function euler84(){
    // Monte Carlo method
    // simulate games for a specified number of turns
    // and determine the most frequent modal string generated
    let games = 2000, turns = 5000, sides = 4;
    const resultsMap = new Map();
    for (let i = 0; i < games; i++){
        const modalStr = simulate(turns, sides);
        if (!resultsMap.has(modalStr)) resultsMap.set(modalStr, 0);
        resultsMap.set(modalStr, resultsMap.get(modalStr) + 1);
    }
    const res = [...resultsMap.entries()].sort((a, b) => b[1] - a[1]);
    return res[0][0];
}

function getModalString(seen){
    // organize visited square array into index-value pairs,
    // sort in descending order by times visited,
    // and get top 3 most visited squares
    const sorted = seen
        .map((val, idx) => ({ square : idx, count : val }))
        .sort((a, b) => b.count - a.count)
        .slice(0, 3);
    let res = "";
    for (let pair of sorted){
        // pad single digit numbers
        if (pair.square < 10) res += '0';
        res += pair.square;
    }
    //console.log(sorted, seen[24]);
    return res;
}

const squares = [
    "GO", "A1", "CC1", "A2", "T1", "R1", "B1", "CH1", "B2", "B3",
    "JAIL", "C1", "U1", "C2", "C3", "R2", "D1", "CC2", "D2", "D3",
    "FP", "E1", "CH2", "E2", "E3", "R3", "F1", "F2", "U2", "F3",
    "G2J", "G1", "G2", "CC3", "G3", "R4", "CH3", "H1", "T2", "H2"
];
const railways = [5, 15, 25, 35];
const utilities = [12, 28];
const communitySquares = [2, 17, 33];
const chanceSquares = [7, 22, 36];
let cc = [
    0, 10, -1, -1, -1, -1, -1, -1, 
    -1, -1, -1, -1, -1, -1, -1, -1
];
let ch = [
    0, 10, 11, 24, 39, 5, -5, -5, 
    -12, -3, -1, -1, -1, -1, -1, -1
];
function simulate(turns, sides){
    // initialize community and chest cards
    const communityCards = shuffle(cc.slice());
    const chanceCards = shuffle(ch.slice());
    let doubles = 0;
    let currSquare = 0;
    const seen = new Array(squares.length).fill(0);
    // loop through game logic for n turns
    for (let i = 0; i < turns; i++){
        // determine next square with random dice roll
        const roll1 = Math.floor(Math.random() * sides + 1);
        const roll2 = Math.floor(Math.random() * sides + 1);
        if (roll1 == roll2){
            // handle triple double sending player to jail square
            if (++doubles == 3){
                doubles = 0;
                currSquare = 10;
                seen[currSquare]++;
                continue;
            }
        }
        else doubles = 0;
        currSquare = (currSquare + roll1 + roll2) % squares.length;
        
        // handle logic for squares with special effects upon landing
        if (currSquare == 30) currSquare = 10; // go to jail
        if (communitySquares.includes(currSquare)){
            const card = communityCards.shift();
            if (card >= 0) currSquare = card;
            communityCards.push(card);
        }
        else if (chanceSquares.includes(currSquare)){
            const card = chanceCards.shift();
            if (card >= 0) currSquare = card;
            else if (card == -3){
                currSquare = (currSquare - 3) % squares.length;
            }
            else if (card == -5){
                currSquare = nextSquare(currSquare, railways);
            }
            else if (card == -12){
                currSquare = nextSquare(currSquare, utilities);
            }
            chanceCards.push(card);
        }
        seen[currSquare]++;
    }
    return getModalString(seen);
}

function shuffle(nums){
    for (let i = nums.length - 1; i > 0; i--){
        const j = Math.floor(Math.random() * (i + 1));
        const temp = nums[j];
        nums[j] = nums[i];
        nums[i] = temp;
    }
    return nums;
}

// update current square to next square of a given type
// used for cards that move player to next railway or utility
function nextSquare(curr, squares){
    for (let sq of squares){
        if (sq > curr) return sq;
    }
    return squares[0];
}

console.log(euler84());
