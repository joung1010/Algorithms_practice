function solution(targets) {
    let rocketCount = 0;
    let target = -1;
    targets.sort((a, b) => a[1] - b[1])
        .forEach(([str, end], i) => {
            if (target <= str) {
                target = end;
                rocketCount++;
            }
        });
    return rocketCount;
}