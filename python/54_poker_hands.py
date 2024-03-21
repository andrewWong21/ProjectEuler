from enum import Enum
# using enums for custom comparison of types

class HandRanking(Enum):
    # hand rankings ordered by score, lowest to highest
    HIGH_CARD = 1,
    PAIR = 2,
    TWO_PAIR = 3,
    THREE_OF_A_KIND = 4,
    STRAIGHT = 5,
    FLUSH = 6,
    FULL_HOUSE = 7,
    FOUR_OF_A_KIND = 8,
    ROYAL_STRAIGHT = 9,
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
        # print(hand1)
        # print(hand2)
        
        print(evaluate(hand1) < evaluate(hand2))
        # if evaluate(hand1) > evaluate(hand2):
            # count += 1
        
    return count
    
    
def evaluate(hand):
    values = ["2", "3", "4", "5", "6", "7", "8", "9", "T", "J", "Q", "K", "A"]
    suits = ["C", "D", "H", "S"]
    
    val_occs = [0] * 13
    suit_occs = [0] * 4
    for card in hand:
        val_occs[values.index(card[0])] += 1
        # TODO: keep track of consecutive values for straights
        suit_occs[suits.index(card[1])] += 1
    print(hand)
    print(val_occs)
    print(suit_occs)
    print(5 in suit_occs)
    
    
    # TODO: implement checks for card rankings
    # if hands are the same ranking, tiebreak with kicker
    # idea: output dict with ranking and kicker
    
    
    #if 5 in suit_occs and :
    
    
    return HandRanking.HIGH_CARD

if __name__ == "__main__":
    # f = open("54_poker.txt", 'r')
    # lines = f.readlines()
    # f.close()
    
    # 5H 5C 6S 7S KD # Pair of Fives
    # 2C 3S 8S 8D TD # Pair of Eights
    # Player 2

    # 5D 8C 9S JS AC # Highest card Ace
    # 2C 5C 7D 8S QH # Highest card Queen
    # Player 1

    # 2D 9C AS AH AC # Three Aces
    # 3D 6D 7D TD QD # Flush with Diamonds
    # Player 2

    # 4D 6S 9H QH QC # Pair of Queens Highest card Nine
    # 3D 6D 7H QD QS # Pair of Queens Highest card Seven
    # Player 1

    # 2H 2D 4C 4D 4S # Full House With Three Fours
    # 3C 3D 3S 9S 9D # Full House With Three Threes
    # Player 1
    hands = [
    "5H 5C 6S 7S KD 2C 3S 8S 8D TD",
    "5D 8C 9S JS AC 2C 5C 7D 8S QH",
    "2D 9C AS AH AC 3D 6D 7D TD QD",
    "4D 6S 9H QH QC 3D 6D 7H QD QS",
    "2H 2D 4C 4D 4S 3C 3D 3S 9S 9D"
    ]
    print(poker_hands(hands))