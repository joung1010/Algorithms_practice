function get_prim(num) {
    if (num === 1) return 0;
    const result = [];

    for (let i = 2; i * i <= num; i++) {
        if (num % i === 0 && num/i <= 10000000) {
            return num / i;
        }
        if (num % i === 0 && i !== num) {
            result.push(i);
        }
    }
    return result.length ? Math.max(...result) : 1;
}

function solution(begin, end) {
    const result = [];
    for (let i = begin; i <= end; i++) {
        result.push(get_prim(i));
    }
    return result;
}