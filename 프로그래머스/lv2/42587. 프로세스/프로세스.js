function solution(priorities, location) {
    if(priorities.length === 1) return 1;
    const processes = priorities.map((priority, order) => ({priority, order:order}));
    const excJob = [];
    while (processes.length) {
        if (processes.every(process => processes[0].priority >= process.priority)) {
            excJob.push(processes.shift());
        } else {
            processes.push(processes.shift());
        }
    }
    return excJob.findIndex(job => job.order === location) + 1;
}