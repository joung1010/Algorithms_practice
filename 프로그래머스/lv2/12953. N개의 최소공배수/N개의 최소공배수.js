function solution(arr) {
    const gcd = (a, b) => {
        let result = 0;
        while (b !== 0) {
            r = a % b;
            a = b;
            b = r;
        }
        return a;
    }
    return arr.sort((a, b) => a - b).reduce((acc, curr) => (acc * curr) / gcd(acc, curr));
}