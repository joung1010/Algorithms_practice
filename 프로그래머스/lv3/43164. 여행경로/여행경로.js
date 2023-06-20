function solution(tickets) {
    tickets.sort();
    const used = Array(tickets.length).fill(0);
    let path = [];
    const makePath = (curr, visited) => {
        const queue = [];
        queue.push({from: curr, visited});
        while (queue.length) {
            const {from, visited} = queue.shift();
            if (visited.length === tickets.length + 1) {
                path.push(visited);
                return;
            }

            for (let i = 0; i < tickets.length; i++) {
                if (used[i]) continue;
                if (tickets[i][0] === from) {
                    used[i] = true;
                    makePath(tickets[i][1], [...visited, tickets[i][1]]);
                    used[i] = false;
                }
            }
        }
    };
    makePath("ICN", ["ICN"]);
    return path[0];
}
