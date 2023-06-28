function solution(n) {
    if (n === 1) return 1;
    if (n === 2) return 2;
    const fibonacci = [1, 1];

    for (let i = 2; i <= n; i++) {
        fibonacci[i] = (fibonacci[i - 1] + fibonacci[i - 2]) % 1234567;
    }
    return fibonacci[n];
}
