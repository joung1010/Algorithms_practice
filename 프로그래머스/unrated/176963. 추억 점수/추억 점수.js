function solution(name, yearning, photo) {
    const cost = new Map();
    name.forEach((n,i) => {
        cost.set(n, yearning[i]);
    });
    
   return  photo.map(people => {
        let score = 0;
        people.filter(p => cost.has(p)).forEach(person => score += cost.get(person));
        return score;
    });
}