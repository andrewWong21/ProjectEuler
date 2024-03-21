from enum import Enum
# using enums for custom comparison of types

class HandRanking(Enum):
    # hand rankings ordered by score, lowest to highest
    HIGH_CARD = 1
    PAIR = 2
    TWO_PAIR = 3
    THREE_OF_A_KIND = 4
    STRAIGHT = 5
    FLUSH = 6
    FULL_HOUSE = 7
    FOUR_OF_A_KIND = 8
    STRAIGHT_FLUSH = 9
    ROYAL_FLUSH = 10
    
    # compare hand rankings
    def __lt__(h1, h2):
        return h1.value < h2.value

def poker_hands(hands: list) -> int:
    
    count: int = 0
    
    for hand in hands:
        cards = hand.split()
        hand1 = cards[:5]
        hand2 = cards[5:]
        
        score1 = evaluate(hand1)
        score2 = evaluate(hand2)
        
        if score1["ranking"] > score2["ranking"] or (score1["ranking"] == score2["ranking"] and score1["kicker"] > score2["kicker"]):
            count += 1
        
    return count
    
    
def evaluate(hand):
    values = ["2", "3", "4", "5", "6", "7", "8", "9", "T", "J", "Q", "K", "A"]
    suits = ["C", "D", "H", "S"]
    
    val_occs_dict = {value: 0 for value in values}
    val_occs_arr = [0] * 13
    suit_occs = [0] * 4
    
    for card in hand:
        val_occs_dict[card[0]] += 1
        val_occs_arr[values.index(card[0])] += 1
        suit_occs[suits.index(card[1])] += 1
    
    # include kicker entry in res as tiebreaker for certain rankings
    streaks = "".join(str(val) for val in val_occs_arr)
    max_streak = max(len(streak) for streak in streaks.split("0"))
    is_straight = max_streak == 5 or ("1111" in streaks and streaks.index("1111") == 0 and val_occs_dict["A"] == 1) # five-high straight
    is_flush = 5 in suit_occs
    
    res = {}
    
    # Royal Flush / Straight Flush
    if is_straight and is_flush:
        if all(val_occs_dict[val] == 1 for val in values[8:]):
            print("royal flush")
            res["ranking"] = HandRanking.ROYAL_FLUSH
            return res
        else:
            print("straight flush")
            res["ranking"] = HandRanking.STRAIGHT_FLUSH
        res["kicker"] = max(idx for idx, val in enumerate(val_occs_arr[:12]) if val == 1)
        return res
    
    # Flush
    if is_flush:
        res["ranking"] = HandRanking.FLUSH
        return res
    
    # Straight
    if is_straight:
        # print("straight")
        res["ranking"] = HandRanking.STRAIGHT
        res["kicker"] = max(idx for idx, val in enumerate(val_occs_arr[:12]) if val == 1)
        return res
    
    # Four of a Kind
    if 4 in val_occs_dict.values():
        res["ranking"] = HandRanking.FOUR_OF_A_KIND
        res["kicker"] = val_occs_arr.index(4)
        return res
    
    # Full House
    if all(num in val_occs_dict.values() for num in [2, 3]):
        res["ranking"] = HandRanking.FULL_HOUSE
        res["kicker"] = val_occs_arr.index(3)
        return res
    
    # Three of a Kind
    if 3 in val_occs_dict.values():
        res["ranking"] = HandRanking.THREE_OF_A_KIND
        res["kicker"] = val_occs_arr.index(3)
        return res
    
    # Two Pair / One Pair
    if 2 in val_occs_dict.values():
        res["ranking"] = HandRanking.TWO_PAIR if list(val_occs_dict.values()).count(2) == 2 else HandRanking.PAIR
        res["kicker"] = max(idx for idx, val in enumerate(val_occs_arr) if val == 2)
        return res
    
    # High Card
    res["ranking"] = HandRanking.HIGH_CARD
    res["kicker"] = max(idx for idx, val in enumerate(val_occs_arr) if val == 1)
    return res

if __name__ == "__main__":
    f = open("54_poker.txt", 'r')
    lines = f.readlines()
    hands = [line.strip() for line in lines]
    f.close()
    
    print(poker_hands(hands))