function solution(n, words) {
    const people = Array.from({length: n}, () => []);
    const visited = [];
    const queue = [];

    queue.push(words.splice(0, n));
    let preV;
    while (queue.length) {
        const game = queue.pop();
        if (!game.length) break;

        for (let i = 0; i < n; i++) {
            const word = game[i];
            if (visited.includes(word)) return [i + 1, people[i].length + 1];
            if (preV && preV[preV.length - 1] !== word[0]) return [i + 1, people[i].length + 1];

            people[i].push(word);
            preV = word;
            visited.push(word);
        }
        queue.push(words.splice(0, n));
    }
    return [0, 0];
}
