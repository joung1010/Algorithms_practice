const move = (park, route, position) => {
    const MAX_WIDTH = park[0].length;
    const MAX_HEIGHT = park.length;
    let [direction, move] = route.split(' ');
    let [curX, curY] = position;

    move = parseInt(move);
    while (move > 0) {
        move--;
        switch (direction) {
            case 'N':
                curY -= 1;
                break;
            case 'S':
                curY += 1;
                break;
            case 'W':
                curX -= 1;
                break;
            case 'E':
                curX += 1;
                break;
        }
        if (0 > curX || curX >= MAX_WIDTH) return;
        if (0 > curY || curY >= MAX_HEIGHT) return;
        if ([...park[curY]][curX] === 'X') return;

    }
    position[0] = curX;
    position[1] = curY;
};

function solution(park, routes) {
    const position = [];

    park.forEach((p, i) => {
        if (p.indexOf("S") === -1) return;
        position.push(p.indexOf("S"));
        position.push(i);
    });
    routes.forEach(route => move(park, route, position));
    return position.reverse();
}