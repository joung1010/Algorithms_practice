function solution(numbers, target) {
    const nums = numbers.filter(n => n > 0 && Number.isInteger(n));
    const queue = [[nums[0], nums[0] * -1]];
    let str = 1;
    let res = 0;
    while (queue.length) {
        const list = queue.shift();
        if (str !== nums.length) {
            const newLst = [];
            list.forEach(n => {
                newLst.push(n + nums[str]);
                newLst.push(n - nums[str]);
            });
            queue.push(newLst);
            str++;
        } else {
            res += list.filter(n => n === target).length;
        }
    }
    return res;
}