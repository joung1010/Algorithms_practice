function solution(s) {
    const stack = [];
    for (const char of s) {
        if (!stack.length) {
            stack.push(char);
            continue;
        }
        if (stack[stack.length - 1] === char) {
            stack.pop();
        } else {
            stack.push(char);
        }
    }
    return stack.length ? 0 : 1;
}