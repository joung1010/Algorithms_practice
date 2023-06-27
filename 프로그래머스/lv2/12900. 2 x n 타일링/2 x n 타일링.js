// 피보나치 수열
// 앞 두 항의 합이 뒤 항의 값이 되는 수열
function solution(n) {
    if(n <=1) return 1;
    if(n <=2) return 2;
    const fibonacci = [1, 1];
    
    for (let i = 2; i<=n; i++) {
        fibonacci[i] = (fibonacci[i - 1] + fibonacci[i - 2]) % 1000000007;
    }
    return fibonacci[n];
}
