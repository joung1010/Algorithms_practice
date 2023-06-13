function solution(s){
    if(s.length > 100_000) return false
    const stack = [];
    for (const char of s) {
        if(!(char === '(' || char === ')')) return false;
        if (char === '(') {
            stack.push(char);
        } else {
            if(stack.length === 0) return false;
            stack.pop();
        }
    }
    return stack.length === 0;
}