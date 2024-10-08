function euler54(games){
    var res = 0;
    for (let game of games){
        if (isWinner1(game) res++;
    }
    return res;
}

function isWinner1(game){
	var cards = game.split(" ");
	let score1 = evaluate(cards.slice(0, 5);
	let score2 = evaluate(cards.slice(5, 10);
	return 0;
}

console.log(euler53([]));
