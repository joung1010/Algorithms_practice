// ?? 문법
// 거짓의 판단을 유연하게 판단. 그냥 심플하게 값이 있고 없고로 판단
function solution(name, yearning, photo) {
    return photo.map((v)=> v.reduce((a, c)=> a += yearning[name.indexOf(c)] ?? 0, 0))
}