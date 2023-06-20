function solution(begin, target, words) {
    if (!words.every(word => word.length === begin.length)) return 0;
    const smallLetters = words.map(word => word.toLowerCase());
    const queue = [{word:begin,cnt:0}];
    const changes = [begin];
    
    while (queue.length) {
        const {word,cnt} = queue.shift();
        if (word === target) return cnt; //changes.length;
        for (const letter of smallLetters) {
            if (changes.includes(letter)) continue;
            let sameWords = [...letter].filter((c,i)=> c !== word[i]).length;
            if(sameWords !== 1) continue;
            queue.push({word: letter, cnt: cnt + 1});
            changes.push(letter);
        }
    }
    return 0;
}