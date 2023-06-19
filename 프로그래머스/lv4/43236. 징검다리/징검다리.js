// 탐색 기준 선정 -> 거리의 최소값 중에서 최소 와 최대값 설정
// 중간 값을 기준으로 어떻게 범위를 좁혀 나갈지 고민
function solution(distance, rocks, n) {
    rocks.sort((a, b) => a - b);
    let left = 0;
    let right = distance;
    while (left <= right) {
        const mid = Math.floor((left + right) / 2);
        let cnt = 0;
        let prev = 0;
        // 돌 제거
        rocks.forEach((r,idx) => {
            let len = r - prev;
            if (mid > len) {// 최소 거리중에 최대값
                cnt++;
            } else {
                prev = r;
            }
        });
        if(mid > distance - prev) cnt++;
        if (cnt <= n) {
            left = mid + 1;
        } else {
            right = mid - 1;
        }
    }
    return right;
}
