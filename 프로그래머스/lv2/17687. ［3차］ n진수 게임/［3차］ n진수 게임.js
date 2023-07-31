function solution(n, t, m, p) {
    const result = [];
    const isMyTurn = p === m ? 0 : p;
    const getNNum = (num,n) => {
        return num.toString(n);
    };

    let number = 0;
    let idx = 1;
    while (result.length <= t) {
        const numStr = getNNum(number, n).split('');

        numStr.filter((num, i) => {
            const isTrue = idx % m === isMyTurn;
            idx++;
            return isTrue;
        })
            .map(num => {
                if (/\d/.test(num)) {
                    return Number(num);
                } else {
                    return num.toUpperCase();
                }
            }).forEach(num => {
            result.push(num);
            });
        number++;
    }
    return result.slice(0, t).join('');

}
