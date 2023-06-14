function solution(operations) {
    const queue = [];
    while (operations.length) {
        const operation = operations.shift().split(' ');
        if (operation.some(word => word === 'I')) {
            queue.push(parseInt(operation[1]));
            queue.sort((a, b) => b - a);
            continue;
        }
        if (!queue.length) continue;

        if (operation[1] === '1') {
            queue.shift();
        } else {
            queue.pop();
        }
    }
    return queue.length ? [queue[0], queue[queue.length-1]] : [0, 0];
}