function solution(n, computers) {
    const networkCheck = Array(n).fill(0); // 서로 연결된 네트워크 확인
    const queue = [];
    queue.push(0);
    while (queue.length) {
        const computer = queue.shift();
        computers[computer].forEach((connect, i) => {
            if (connect === 1 && !networkCheck[i]) {
                queue.push(i);
                networkCheck[i] = 1;
            }
        });
    }
    return networkCheck.filter((c, i) => networkCheck[i + 1] !== 1).length;
}