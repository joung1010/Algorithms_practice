const countNumber = (number) => {
    const binary = number.toString(2);
    let numCnt = 0;
    [...binary].forEach(n => {
        if (n === '1') numCnt++;
    })
    return numCnt;
};
function solution(n) {
    const count = countNumber(n);
    let answer = 0;
    let targetNumber = n;
    while (!answer) {
        targetNumber += 1;
        if(count === countNumber(targetNumber)) answer = targetNumber;
    }
    return answer;
}