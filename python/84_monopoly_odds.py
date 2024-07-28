import random

def monopoly_odds() -> str:
    # Approach: Simulate a large number of games for enough turns
    # and return the most common modal string generated from this sample set of games.
    
    # due to Monte Carlo approach, wrong answer may be returned a small percentage of the time
    # increasing number of games simulated and number of turns per game reduces this probability
    # smooth error by aggregating results of multiple tests and returning majority result
    
    tests, games, turns = 10, 200, 5_000
    results = []
    for _ in range(tests):
        # count frequencies of modal strings obtained from simulations
        modal_strs = {}
        for _ in range(games):
            # obtain modal string from simulation of one game
            modal_str = simulate(4, turns)
            
            if modal_str not in modal_strs:
                modal_strs[modal_str] = 0
            modal_strs[modal_str] += 1
        
        # append most common modal string obtained from simulations
        results.append(max(modal_strs, key=modal_strs.get))
        # print([(sq, modal_strs[sq]) for sq in sorted(modal_strs, key = modal_strs.get, reverse=True)[:3]])
    
    # return majority result obtained from running multiple tests
    return max(results, key=results.count)

def simulate(sides: int, turns: int) -> str:
    squares = [
        "GO",  "A1",  "CC1",  "A2",  "T1",  "R1",  "B1",  "CH1",
        "B2",  "B3",  "JAIL", "C1",  "U1",  "C2",  "C3",  "R2",
        "D1",  "CC2", "D2",   "D3",  "FP",  "E1",  "CH2", "E2", 
        "E3",  "R3",  "F1",   "F2",  "U2",  "F3",  "G2J", "G1",  
        "G2",  "CC3", "G3",   "R4",  "CH3", "H1",  "T2",  "H2"
    ]
    
    # 2/16 chance from Community Chest to move to another square
    community_chest = [0, 10] + ([-1] * 14)
    # 10/16 chance from Chance to move to another square
    chance = [0, 10, 11, 24, 39, 5, -5, -5, -12, -3] + ([-1] * 6)
    
    random.shuffle(community_chest)
    random.shuffle(chance)
    
    ccs = [i for i in range(len(squares)) if squares[i][:2] == "CC"]     # [2, 17, 33]
    chs = [i for i in range(len(squares)) if squares[i][:2] == "CH"]     # [7, 22, 36]
    railways =  [i for i in range(len(squares)) if squares[i][0] == "R"] # [5, 15, 25, 35]
    utilities = [i for i in range(len(squares)) if squares[i][0] == "U"] # [12, 28]
    
    visited = {}
    for i in range(len(squares)):
        visited[i] = 0
    
    curr_square = 0
    doubles = 0
    
    for _ in range(turns):
        roll1 = random.randint(1, sides)
        roll2 = random.randint(1, sides)
        if roll1 == roll2:
            doubles += 1
            if doubles == 3:     # triple consecutive double, jail
                doubles = 0      # reset double counter
                curr_square = 10 # Jail
                visited[10] += 1
                continue
        else: # double streak broken
            doubles = 0
        
        curr_square = (curr_square + roll1 + roll2) % len(squares)
        
        if curr_square == 30: # Go to Jail
            curr_square = 10  # Jail
        
        # Community Chest square
        elif curr_square in ccs:
            card = community_chest.pop(0)
            if card != -1:
                curr_square = card
            community_chest.append(card) # move to bottom of stack
        
        # Chance square
        elif curr_square in chs:
            card = chance.pop(0)
            if card > -1:
                curr_square = card
            elif card == -3: # go back 3
                curr_square = (curr_square - 3) % len(squares)
            elif card == -5: # next railway
                curr_square = next(curr_square, railways)
            elif card == -12: # next utility
                curr_square = next(curr_square, utilities)
            chance.append(card) # move to bottom of stack
        
        visited[curr_square] += 1
    
    # return concatenation of indices of top 3 visited squares
    return "".join([str(sq).zfill(2) for sq in sorted(visited, key=visited.get, reverse=True)[:3]])

def next(curr: int, squares: list):
    if curr > squares[-1]:
        return squares[0]
    for square in squares:
        if square > curr:
            return square

if __name__ == "__main__":
    print(monopoly_odds())
