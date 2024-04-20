import random

def monopoly_odds() -> str:
    # Approach: Simulate a large number of games for enough turns
    # and return the most common modal string generated from this sample set.
    
    # TODO: expected output for 6-sided dice is 102400 (jail, E3, go)
    # algorithm currently returns 100005 (jail, go, railway)
    
    modal_strs = {}
    
    for i in range(5_000):
        print(i)
        modal_str = simulate(6, 5_000)
        
        if modal_str not in modal_strs:
            modal_strs[modal_str] = 0
        modal_strs[modal_str] += 1
    
    print(sorted(modal_strs, key = modal_strs.get, reverse=True)[:10])
    
    return max(modal_strs, key=modal_strs.get)
    
def simulate(sides: int, turns: int) -> str:
    squares = [
        "GO",  "A1",  "CC1",  "A2",  "T1",  "R1",  "B1",  "CH1",
        "B2",  "B3",  "JAIL", "C1",  "U1",  "C2",  "C3",  "R2",
        "D1",  "CC2", "D2",   "D3",  "FP",  "E1",  "CH2", "E2", 
        "E3",  "R3",  "F1",   "F2",  "U2",  "F3",  "G2J", "G1",  
        "G2",  "CC3", "G3",   "R4",  "CH3", "H1",  "T2",  "H2"
    ]
    community_chest = [0] + [10] + ([-1] * 16)
    chance = [0, 10, 11, 24, 39, 5, -5, -5, -12, -3] + ([-1] * 6)
    
    random.shuffle(community_chest)
    random.shuffle(chance)
    
    ccs = [i for i in range(len(squares)) if squares[i][:2] == "CC"]
    chs = [i for i in range(len(squares)) if squares[i][:2] == "CH"]
    railways =  [i for i in range(len(squares)) if squares[i][0] == "R"]
    utilities = [i for i in range(len(squares)) if squares[i][0] == "U"]
    
    visited = {}
    for i in range(len(squares)):
        visited[i] = 0
    
    curr_square = 0
    doubles = 0
    
    for _ in range(turns):
        
        roll1 = random.randint(1, sides)
        roll2 = random.randint(1, sides)
        if roll1 == roll2:
            # print("Rolled a double")
            doubles += 1
        else:
            doubles = 0
        if doubles == 3:
            # print("Triple consecutive double, jail")
            doubles = 0      # reset double counter
            curr_square = 10 # Jail
            visited[10] += 1
            # print("curr: ", curr_square)
            continue
        
        # print("\tspaces moved:", roll1 + roll2)
        curr_square += roll1 + roll2
        curr_square %= len(squares)
        
        # Community Chest square
        if curr_square in ccs:
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
                curr_square -= 3
                curr_square %= len(squares)
            elif card == -5: # next railway
                curr_square = next(curr_square, railways)
            elif card == -12: # next utility
                curr_square = next(curr_square, utilities)
            
            chance.append(card) # move to bottom of stack
        
        # print("curr: ", curr_square)
        visited[curr_square] += 1
    
    return "".join([str(sq).zfill(2) for sq in sorted(visited, key=visited.get, reverse=True)[:3]])
        
def next(curr: int, squares: list):
    if curr > max(squares):
        return squares[0]
    for square in squares:
        if square > curr:
            return square

if __name__ == "__main__":
    print(monopoly_odds())
