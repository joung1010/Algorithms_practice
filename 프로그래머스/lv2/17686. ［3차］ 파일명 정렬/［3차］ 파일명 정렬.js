function solution(files) {
    const regx = /(\D+)|(\d{1,5})/g;
    return  files.map(file => {
        let [head, number] = file.match(regx);
        head = head.toUpperCase();
        number = Number(number);
        return {head, number, file};
    }).sort((a,b)=> {
        if (a.head > b.head) {
            return 1;
        }else if (a.head < b.head) {
            return -1;
        } else {
            return a.number - b.number;
        }
    }).map(file => file.file);
}