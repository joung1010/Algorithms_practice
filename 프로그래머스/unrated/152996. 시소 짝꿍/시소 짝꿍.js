// 시소 배치 경우의 수 : (1,1) (1,2) (2,1) (2,3)(3,2)(3,4)(4,3)
//  즉, 시소 배치는: 1,2,3/2,4/3 -> 기준값에 시소 배치값을 곱해서 나온값이 무게 배열에 존재하면 페어 가능
// 1. 배열을 내림차순을 정렬
// 2. weights 배열을 순회하면서 순회한 값을 별도의 기록테이블에 보관
// 3. 모든 무게가 같을 수도 있기 때문에 보관테이블에 기존값이 존재하면 값증가

// 360, 270, 180, 100
// 1
// 360 : 360, 540, 720 , 270
// 보관 테이블 : 값없음 , 추가 {360: 1}

//2
//270: 270, 405 ,540 ,360(테이블에 존재) result += 테이블[360]
// 보관테이블 : {360:1,270:1}
// ....
function solution(weights) {
    let result = 0;
    const table = {}; 
    const distance = [1, 3/2, 2, 4/3]; 

    weights.sort((a,b)=> b - a)
        .forEach((weight) => { //내림차순 정렬 후, 전체 돌면서
        distance.forEach((calc)=>{
            let pair = weight * calc;
            if(table[pair] ){ //해당 비율을 곱한 값이 store에 존재할 경우
                result += table[pair];
            }
        });
        if (!table[weight]) table[weight] = 1;
        else table[weight]++;
    });
    return result;
}