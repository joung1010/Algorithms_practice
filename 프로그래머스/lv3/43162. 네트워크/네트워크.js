function solution(n, computers) {
    const visited = Array(n).fill(0); // 서로 연결된 네트워크 확인
    const queue = [];
    let res = 0;

    const bfs = (curr) => {
        queue.push(curr);
        while (queue.length) {
            const computer = queue.shift();
            if(!visited[computer]) res++;
            computers[computer].forEach((connect, i) => {
                if (connect === 1 && !visited[i]) {
                    queue.push(i);
                    visited[i] = true;
                }
            });
        }
    };
    for (let i = 0; i < n; i ++) {
        bfs(i);
    }

    return res;
}