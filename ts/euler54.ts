enum CardValue {
    Deuce = 2,
    Trey,
    Four,
    Five,
    Six,
    Seven,
    Eight,
    Nine,
    Ten,
    Jack,
    Queen,
    King,
    Ace
}

enum CardSuit {
    Clubs,
    Diamonds,
    Hearts,
    Spades
}

class Card {
    value: CardValue;
    suit: CardSuit;

    constructor(str: string) {
        this.value = Card.parseValue(str[0]);
        this.suit = Card.parseSuit(str[1]);
    }

    static parseSuit(ch: string): CardSuit {
        switch(ch) {
            case "C": return CardSuit.Clubs;
            case "D": return CardSuit.Diamonds;
            case "H": return CardSuit.Hearts;
            case "S": return CardSuit.Spades;
            default: throw new Error("Invalid suit");
        }
    }

    static parseValue(ch: string): CardValue {
        switch(ch) {
            case "2": return CardValue.Deuce;
            case "3": return CardValue.Trey;
            case "4": return CardValue.Four;
            case "5": return CardValue.Five;
            case "6": return CardValue.Six;
            case "7": return CardValue.Seven;
            case "8": return CardValue.Eight;
            case "9": return CardValue.Nine;
            case "T": return CardValue.Ten;
            case "J": return CardValue.Jack;
            case "Q": return CardValue.Queen;
            case "K": return CardValue.King;
            case "A": return CardValue.Ace;
            default: throw new Error("Invalid card value");
        }
    }
}

enum Ranking{
    HighCard,
    OnePair,
    TwoPair,
    ThreeOfAKind,
    Straight,
    Flush,
    FullHouse,
    FourOfAKind,
    StraightFlush,
    RoyalFlush
}

class Hand {
    cards: Card[];
    suits: number[];
    ranks: number[];

    constructor(cards: string[]) {
        this.cards = cards.map(c => new Card(c));
        this.suits = [];
        this.ranks = [];
    }
}

function checkStraight(counts: number[]): {isStraight: boolean, high: number} {
    // check for wheel straight A-2-3-4-5
    if (counts[0] && counts[1] && counts[2] && counts[3] && counts[12]) {
        return {isStraight: true, high: 14};
    }
    
    let streak = 0;
    for (let i = 0; i < 13; i++) {
        if (counts[i] > 1) break;
        if (counts[i]) {
            streak++;
            if (streak == 5) return {isStraight: true, high: i + 2};
        }
        else streak = 0;
    }
    return {isStraight: false, high: 0};
}

function evaluateHand(hand: Hand): {ranking: Ranking, kicker: number} {
    const rankCounts = Array(13).fill(0);
    const suitCounts = Array(4).fill(0);

    for (let card of hand.cards) {
        rankCounts[card.value - 2]++;
        suitCounts[card.suit]++;
    }

    const straightInfo = checkStraight(rankCounts);
    const isStraight: boolean = straightInfo.isStraight;
    const isFlush: boolean = suitCounts.includes(5);

    if (isStraight && isFlush) {
        const highestRank = rankCounts.lastIndexOf(1) + 2;
        // royal straight T-J-Q-K-A
        if (rankCounts[8] == 1 && highestRank == CardValue.Ace) {
            return {ranking: Ranking.RoyalFlush, kicker: highestRank};
        }
        return {ranking: Ranking.StraightFlush, kicker: highestRank};
    }
    if (rankCounts.includes(4)) return {ranking: Ranking.FourOfAKind, kicker: rankCounts.indexOf(4) + 2};

    const hasThree = rankCounts.includes(3);
    const pairs = rankCounts.filter(c => c == 2).length;

    if (hasThree && pairs == 1) return {ranking: Ranking.FullHouse, kicker: rankCounts.indexOf(3) + 2};
    if (isFlush) return {ranking: Ranking.Flush, kicker: rankCounts.lastIndexOf(1) + 2};
    if (isStraight) return {ranking: Ranking.Straight, kicker: rankCounts.lastIndexOf(1) + 2};
    if (hasThree) return {ranking: Ranking.ThreeOfAKind, kicker: rankCounts.indexOf(3)};
    if (pairs == 2) return {ranking: Ranking.TwoPair, kicker: rankCounts.lastIndexOf(2) + 2};
    if (pairs == 1) return {ranking: Ranking.OnePair, kicker: rankCounts.indexOf(2) + 2};
    return {ranking: Ranking.HighCard, kicker: rankCounts.lastIndexOf(1) + 2};
}


function pokerHands(games: string[]): number {
    let res: number = 0;
    for (let game of games){//.slice(0, 1)) {
        const cards: string[] = game.split(" ");
        const hand1: Hand = new Hand(cards.slice(0, 5));
        const hand2: Hand = new Hand(cards.slice(5));

        const score1 = evaluateHand(hand1);
        const score2 = evaluateHand(hand2);
        console.log(score1, score2);
        if (score1.ranking > score2.ranking || 
            (score1.ranking == score2.ranking && score1.kicker > score2.kicker)
        ) {
            console.log("1 win");
            res++;
        }
    }
    return res;
}

const games = [
    "5H 5C 6S 7S KD 2C 3S 8S 8D TD",
    "5D 8C 9S JS AC 2C 5C 7D 8S QH", // 1
    "2D 9C AS AH AC 3D 6D 7D TD QD",
    "4D 6S 9H QH QC 3D 6D 7H QD QS", // should be 1, 7 kicker vs. 9 kicker for equal pairs
    "2H 2D 4C 4D 4S 3C 3D 3S 9S 9D"  // 1
];
console.log(pokerHands(games));
