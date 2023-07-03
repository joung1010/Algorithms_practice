function solution(n) {
    const setQueen = (visited, row) => {
        const MAX_LEN = visited.length;
        let cnt = 0;
        if (MAX_LEN === row) return 1;

        // 가로이동
        for (let i = 0; i < MAX_LEN; i++) {
            visited[row] = i;
            if (isMove(visited, row)) {
                cnt += setQueen(visited, row + 1);
            }
        }
        return cnt;
    };
    const isMove = (visited,row) => {
        for (let i = 0; i < row; i++) {
            //대각선을 제외한 위치가 같으면 안됨,대각선의 위치가 같으면 안됨(열의 차와 행의 차가 동일해야됨)
            if (visited[row] === visited[i] || Math.abs(visited[row] - visited[i]) === row - i) {
                return false;
            }
        }
        return true;
    };
    return setQueen(Array.from({length:n},()=>0), 0);
}
