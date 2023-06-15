function solution(operations) {
    const queue = [];
    operations.forEach(operation => {
        const command = operation.split(' ');
        if (command[0] === 'I') {
            queue.push(parseInt(command[1]));
            queue.sort((a, b) => b - a);
            return;
        }
        if (!queue.length) return;

        if (command[1] === '1') {
            queue.shift();
        } else {
            queue.pop();
        }
    })
    return queue.length ? [queue[0], queue[queue.length-1]] : [0, 0];
}