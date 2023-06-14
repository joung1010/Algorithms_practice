function solution(jobs) {
    // 요청 시간이 같다면 소요시간이 더 적은 순으로 정렬
    jobs.sort((a, b) => a[0] - b[0]);
    const disk = [];
    const JOBS_LENGTH = jobs.length;

    let totalRunTime = 0;
    let endSec = 0; //요청에서 종료시간
    let endPnt = 0; // 종료된 시점의 시간
    while (jobs.length || disk.length) {
        // 요청시간이 마지막 종료시점보다 작아된다. 그렇지 않으면 추가적인 대기시간이 발생
        while (jobs.length && jobs[0][0] <= endPnt) {
            disk.push([...jobs.shift()]);
        }
        // 디스크안에 있는 작업들 중에서 소요시간이 가장 적은 순으로 정렬
        // 가장 처음 로직에서 jobs 를 요청 순서대로 정렬하였기 때문에 
        // 맨처음 disk 에서 작업을 수행하게 되는 작업은 요청시간이 가장 작은 값이된다.
        // 그 이후에 들어오는 작업들은 현재 완료된 시간을 기준으로 작은 값들이 들어오고
        // 그 값중에서 작업소요 시간이 작은 순서로 정렬하게되면 요청에서 종료까지의 최소값 시간을 얻을 수 있다.
        disk.sort((a, b) => a[1] - b[1]);
        if (disk.length) {
            const [strPnt, sec] = disk.shift();
            // 요청에서 종료까지의 시간은 그전까지의 작업시간에서 소요시간을 더하고 현재 자신의 요청시간을 뺀다.
            endSec = (endPnt + sec) - strPnt;
            // 작업 종료 시점은 자신의 요청시간에서 위에서 구한 요청에서 종료시간을 더한다.
            endPnt = strPnt + endSec;
            totalRunTime += endSec;
        } else {
            endPnt = jobs[0][0];
        }
    }
    return Math.floor(totalRunTime / JOBS_LENGTH);
}
