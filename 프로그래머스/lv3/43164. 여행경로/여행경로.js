function solution(tickets) {
    const myTickets = tickets.map((t, i) => [...t, i]);
    const queue = [];
    const used = Array(tickets.length).fill(0);
    const visited = ["ICN"];

    queue.push("ICN");
    while (queue.length) {
        const dep = queue.shift();
        const ticket = myTickets
            .filter(t => !used[t[2]] && t[0] === dep) // 사용되지 않는 티켓과 목표 출발지가 동일한 티켓
            .filter((t, _, array) => { // 티켓이 2개이상일때 티켓의 목적지가 남은 티켓의 출발지로 존재하는 체크
                if (array.length === 1) return true;
                const [src, des] = t;
                return myTickets.some((i => !used[i[2]] && i[0] === des))
            })
            .sort((a, b) => a[1].localeCompare(b[1])) // 2개 이상일때 알파벳을 기준으로 정렬
            .find((_, i) => i === 0); // 1건 추출
        if (!ticket) continue;

        used[ticket[2]] = true;
        queue.push(ticket[1]);
        visited.push(ticket[1]);
    }
    return visited;
}
