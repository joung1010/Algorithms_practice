function solution(N, road, K) {
    const delivery = Array(N + 1).fill(Number.POSITIVE_INFINITY);
    const cost = Array.from({length: N + 1}, () => []);
    const queue = [];

    road.forEach((r, i) => {
        const [from, to, time] = r;
        cost[from].push({to, time});
        cost[to].push({to: from, time});
    })
    delivery[1] = 0;
    queue.push(1);

    while (queue.length) {
        const node = queue.shift();

        cost[node].forEach((c, i) => {
            if (delivery[c.to] > c.time + delivery[node]) {
                delivery[c.to] = c.time + delivery[node];
                queue.push(c.to);
            }

        });
    }
    return delivery.filter(v => v<=K).length;
}