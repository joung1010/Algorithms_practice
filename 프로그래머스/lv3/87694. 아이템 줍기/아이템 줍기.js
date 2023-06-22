// 좌표 만들기
// y값이 동일
// const leftBottom = {x: minX, y: minY};
// const rightBottom = {x: maxX, y: minY};
// x값이 동일
// const leftTop = {x: minX, y: maxY};
// const rightTop = {x: maxX, y: maxY};
const makeBoard = (rectangle, size) => {
    const board = Array.from(Array(size), () => Array(size).fill(0));
    rectangle.forEach(([minX, minY, maxX, maxY]) => {
        // 직사각형의 y축을 기준으로 x축으로 갈수 있는 곳을 1 로 채워 넣는다
        for (let i = minY; i <= maxY; i++) {
            for (let j = minX; j <= maxX; j++) {
                // 테두리인 경우: x축과 y축의 값이 직사각형 좌표 값이랑 같은 경우
                if (j === minX || j === maxX || i === minY || i === maxY) {
                    if (board[j][i] === 1) continue;
                    board[j][i] += 1;
                } else {
                    // 테두리가 아닌경우
                    board[j][i] += 2;
                }
            }
        }
    });
    return board;
};

function solution(rectangle, characterX, characterY, itemX, itemY) {
    const queue = [];
    const MAX_LENGTH = 103;
    const moveX = [1, -1, 0, 0];
    const moveY = [0, 0, 1, -1];
    //좌표, 그림을 2배로 확장시킨다.
    // why?? 예제 1번 그림에 ㄷ 자로 파인부분을 2배로 확대시켜서 풀이해야 움푹 파인부분을 0.5 좌표로 구분이가능
    // 만약 , 확대를 안하시면, 자칫하다가 프로그램이 ㄷ자를 ㅁ자로 오해할 수 있다.
    const doubleSize = rectangle.map((positions) => positions.map((position) => position * 2));
    const board = makeBoard(doubleSize, MAX_LENGTH);

    // 모든 좌표 2배 증가
    characterX *= 2;
    characterY *= 2;
    itemX *= 2;
    itemY *= 2;
    queue.push({x: characterX, y: characterY, move: 0});

    while (queue.length) {
        const {x, y, move} = queue.shift();
        if (x === itemX && y === itemY) return move / 2;

        if (0 > x || x > MAX_LENGTH) continue;
        if (0 > y || y > MAX_LENGTH) continue;
        if (board[x][y] !== 1) continue;

        board[x][y] = 0; // 방문 처리
        // 이동한 좌표가 이동가능한 좌표인지 체크
        board[x + 1][y] === 1 && queue.push({x: x + 1, y, move: move + 1});
        board[x - 1][y] === 1 && queue.push({x: x - 1, y, move: move + 1});
        board[x][y + 1] === 1 && queue.push({x, y: y + 1, move: move + 1});
        board[x][y - 1] === 1 && queue.push({x, y: y - 1, move: move + 1});
    }
    return 0;
}