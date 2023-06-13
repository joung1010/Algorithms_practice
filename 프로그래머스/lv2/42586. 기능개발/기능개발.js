//진도가 100% 일때 반영가능
// 개발속도가 다르기때문에 작업 배포가 함께 이루어질 수 있음
// 배포 순서가 있음

function solution(progresses, speeds) {
    const jobs = progresses.map((progresse, priority) => ({priority,progresse, speed: speeds[priority]}));
    const works = jobs.map(work => ({day:Math.ceil((100 - work.progresse) / work.speed),priority:work.priority}));

}
