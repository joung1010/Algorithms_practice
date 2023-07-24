function solution(msg) {
    const arr = Array.from({length: 26}, (v, i) => String.fromCharCode(i + 65));
    const msgArr = msg.split('');

    let word = "";
    return [
        ...msgArr.map(char => {
            word += char;
            if (!arr.includes(word)) {
                arr.push(word);
                const idx = arr.indexOf(word.slice(0, -1)) + 1;
                word = char;
                return idx;
            }
        }).filter(v => v)
        ,arr.indexOf(word) + 1
    ]
}