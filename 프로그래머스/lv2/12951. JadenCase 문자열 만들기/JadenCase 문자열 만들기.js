function solution(s) {
    
    return s.split(" ").map(str => {
        const strArray = [...str];
        strArray.forEach((char, i) => {
            if (i === 0 && char !== ' ' && typeof Number(char) === "number") {
                strArray[i] = char.toUpperCase();
            } else {
                strArray[i] = char.toLowerCase();
            }
        });
        return strArray.join('');
    }).join(' ');
}