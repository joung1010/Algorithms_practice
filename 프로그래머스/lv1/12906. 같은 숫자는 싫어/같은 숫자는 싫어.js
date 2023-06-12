function solution(arr) {
    const stack = [];
    arr.forEach((item, idx) => {
        if (stack[stack.length - 1] === item) return;
        stack.push(item);
    });
    return stack;
}
