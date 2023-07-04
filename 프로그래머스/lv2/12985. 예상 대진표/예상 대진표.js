function solution(n, a, b) {
    let tournament = [];
    let cnt = 1;

    for (let i = 2; i <= n; i += 2) {
        tournament.push([i - 1, i]);
    }
    while (tournament.length > 1) {
        if (tournament.some(competition => competition.includes(a) && competition.includes(b))) return cnt;
        const round = [];
        const winners = tournament.map(competition => {
            const [c1, c2] = competition;
            if (c1 === a || c1 === b) {
                return c1
            } else if (c2 === a || c2 === b) {
                return c2;
            } else {
                return c1;
            }
        });
        for (let i = 1; i <= winners.length; i += 2) {
            round.push([winners[i - 1], winners[i]]);
        }

        cnt++;
        tournament = round;
    }

    return cnt;
}