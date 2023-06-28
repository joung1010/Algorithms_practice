// 1. 이전 에 밟은 행을 제외한 최대값을 구해서 합 -> 모두 실패
// -> 문제는 최대값을 구하는 문제  [1,2,3,4],[2,3,4,7] 1의 방법으로 풀면 8 , 최대값을 구하가면서 풀면 10


function solution(land) {
    const MAX_Y = land.length;
    const MAX_X = land[0].length;
    const myLand = Array.from({length: MAX_Y}, () => Array(MAX_X).fill(0));

    for (let i = 0; i < MAX_X; i++) {
        myLand[0][i] = land[0][i];
    }
    for (let i = 1; i < MAX_Y; i++) {
        for (let j = 0; j < MAX_X; j++) {
            for (let k = 0; k < MAX_X; k++) {
                if (j === k) continue; // 같은 인덱스 제외 -> 열을 연속해서 밟을 수 없는 특수 규칙
                myLand[i][j] = Math.max(myLand[i][j], myLand[i - 1][k] + land[i][j]);
                // myland 배열 : 이전 땅의값과 현재땅의 값을 더한 값중 최대 값을 누적
                // 현재 위치 = 최대값 ( 현재위치, 이전 행의 밟은 땅의 값 + 현재 행의 밟은 땅의 값 )
            }
        }
    }
    
    return Math.max(...myLand[MAX_Y-1]);

}
