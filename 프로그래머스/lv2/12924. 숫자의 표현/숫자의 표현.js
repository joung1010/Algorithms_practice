// n에서 /2 한 값을 다음으로 더하면 본래 숫자보다 커짐
function solution(n) {
    if(n === 1) return 1;

    const MAX_NUM = Math.floor(n / 2);
    let cnt = 1;

    for (let i = 1; i <= MAX_NUM; i++) {
        let increaseNum = i; //1
        let target = i; //1

        while (true) {
            increaseNum++; //2
            
            
            target = target + increaseNum;// 1 + 2
            if (target > n) break;
            if (target === n) {
                cnt++;
                break;
            }
        }
    }

    return cnt;
}