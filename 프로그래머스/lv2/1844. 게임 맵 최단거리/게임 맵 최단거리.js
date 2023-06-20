function solution(maps) {
    const queue = [];
    const cols = maps.length - 1;
    const rows = maps[0].length - 1;

    queue.push({x: 0, y: 0, cnt: 0});
    while (queue.length) {
        const {x, y, cnt} = queue.shift();
        if (x === rows && y === cols) return cnt + 1;
        if (0 > x || x > rows) continue;
        if (0 > y || y > cols) continue;
        if (maps[y][x] !== 1) continue;

        // 이미 방문한 요소는 0처리
        maps[y][x] = 0;
        queue.push({x: x + 1, y, cnt: cnt + 1});
        queue.push({x: x - 1, y, cnt: cnt + 1});
        queue.push({x, y: y + 1, cnt: cnt + 1});
        queue.push({x, y: y - 1, cnt: cnt + 1});
    }
    return -1;
}