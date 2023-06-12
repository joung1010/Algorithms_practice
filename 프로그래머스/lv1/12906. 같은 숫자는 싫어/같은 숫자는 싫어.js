
// 다른사람 풀이
function solution(arr)
{
    return arr.filter((val,index) => val != arr[index+1]);
}
