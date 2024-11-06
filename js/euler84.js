function euler84(){
    const squares = [
        "GO", "A1", "CC1", "A2", "T1", "R1", "B1", "CH1", "B2", "B3",
        "JAIL", "C1", "U1", "C2", "C3", "R2", "D1", "CC2", "D2", "D3",
        "FP", "E1", "CH2", "E2", "E3", "R3", "F1", "F2", "U2", "F3",
        "G2J", "G1", "G2", "CC3", "G3", "R4", "CH3", "H1", "T2", "H2"
    ];
    // Monte Carlo method
    // simulate games for a specified number of turns
    let games = 1000, turns = 5000, sides = 4;
    // and determine the most frequent modal string generated
    let results = new Map();
    for (let i = 0; i < games; i++){
        
    }
}

function getModalString(seen){
    // iterate over square frequencies, find 
}

function simulate(sides, turns){
    // initialize community and chest cards
    
    // loop through game logic for n turns
    
    // determine next square with random dice roll
    
    // handle triple double sending player to jail square
    
    // handle logic for special squares with effects upon landing
    
    return getModalString();
}

console.log(euler84());
