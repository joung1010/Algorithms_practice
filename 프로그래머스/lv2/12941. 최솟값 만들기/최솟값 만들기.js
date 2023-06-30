function solution(A, B) {
    A.sort((a, b) => a - b);
    B.sort((a, b) => b - a);

    return A.map((n, i) => n * B[i]).reduce((acc, curr) => acc + curr);
}