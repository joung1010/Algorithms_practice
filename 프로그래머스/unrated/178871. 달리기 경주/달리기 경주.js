function solution(players, callings) {
    // 선수의 이름을 반복문을 통해 찾으려면 너무 오래걸린다.
    const ranks = new Map();
    const result = [...players];
    players.forEach((name, i) => {
        ranks.set(name, i);
    });

    callings.forEach(name => {
        const curRank = ranks.get(name);
        const front = result[curRank - 1];
        ranks.set(name, curRank - 1);
        ranks.set(front, curRank);
        [result[curRank - 1], result[curRank]] = [result[curRank], result[curRank - 1]];
    });
    return result;
}
