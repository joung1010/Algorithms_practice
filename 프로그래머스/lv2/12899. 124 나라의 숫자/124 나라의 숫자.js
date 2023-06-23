// 3진법 과 유사 0,1,2
// 문제는 0 대신 4로 변환후 몫 -1
function solution(n) {
    const stack = [];
    while (n > 0) {
        if (n % 3 === 0) {
            stack.push(4);
            n = Math.floor(n / 3) - 1;
        } else {
            stack.push(n % 3);
            n = Math.floor(n / 3);
        }
    }
    return stack.reverse().join('');
}