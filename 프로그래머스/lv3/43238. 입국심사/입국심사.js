    function solution(n, times) {
        times.sort((a, b) => a - b);
        let left = 1; // 한명을 처리하는데 최소 1분이 소요
        let right = times[times.length - 1] * n;

        while (left <= right) {
            const mid = Math.floor((left + right) / 2);
            // 시간 / 심사시간 으로 심사관 당 처리 가능한 입국자 수를 구한다.
            // 근데 그 값들을 전부 더해야한다.
            const sum = times.reduce((acc, curr) => acc + Math.floor((mid / curr)), 0);

            if (sum < n) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return left;
}