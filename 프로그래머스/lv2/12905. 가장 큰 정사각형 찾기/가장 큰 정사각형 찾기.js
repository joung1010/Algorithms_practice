function solution(board) {
    let width = board[0].reduce((acc, curr) => acc + curr, 0);

    board.forEach((rows, y) => {
        const positionX = rows.reduce((acc, curr) => acc + curr, 0);
        if (!positionX) return;
        if (positionX === 1) return;
        if (positionX - width === 0) return;

        const diff = Math.floor(positionX - width);
        if (positionX > width) {
            width = positionX - diff;
        } else {
            width -= diff;
        }
    });
    return width * width;

}