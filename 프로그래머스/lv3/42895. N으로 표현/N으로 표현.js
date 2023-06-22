// 1 -> 5
// 2 -> 55,5+5,5-5,5*5,5/5
// 3 ->  1~3
//        1 -> 3-1 = 2
//          5 -> [2]-> [55,10,0,25,1] -> 사칙연산
//        2 -> [1] -> [5] -> 사칙연산

function solution(N, number) {
    // 최소 값이 8이면 -1이기때문
    const nums = Array.from({length: 9}, () => new Set());
    for (let i = 1; i < 9; i++) {
        nums[i].add(parseInt(`${N}`.repeat(i))); //5,55,555,5555 이런식으로 추가
        for (let j = 1; j < i; j++) {
            for (const n1 of nums[j]) { 
                for (const n2 of nums[i - j]) {// 현재값과 이전 결과값들을 사칙연산으로 계산
                    nums[i].add(n1 + n2);
                    nums[i].add(n1 - n2);
                    nums[i].add(n1 * n2);
                    nums[i].add(Math.floor(n1 / n2));
                }
            }
        }
        if(nums[i].has(number)) return i;
    }
    return -1;
}