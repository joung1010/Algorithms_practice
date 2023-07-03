function solution(n) {
    if (n === 1) return 1;
    let num = n;
    let count = 0;
    while (num > 0) {
        if (num % 2 !== 0) {
            num -= 1;
            count++;
        }
        num /= 2;
    }
    return count;
}