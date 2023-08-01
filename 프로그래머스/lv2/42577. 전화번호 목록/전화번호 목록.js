function solution(phone_book) {
    const phoneTable = {};
    phone_book.forEach(num => phoneTable[num] = true);

    for (const phoneNum of phone_book) {
        for (let i =0; i<phoneNum.length; i++) {
            const prefix = phoneNum.slice(0, i);
            if(phoneTable[prefix]) return false;
        }
    }
    return true;
}
