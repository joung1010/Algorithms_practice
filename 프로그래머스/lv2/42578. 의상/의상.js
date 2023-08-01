function solution(clothes) {
    const closet = new Map();
    let result = 1;
    clothes.forEach(cloth => {
        const [name, kind] = cloth;
        if (closet.get(kind)) {
            closet.set(kind, closet.get(kind) + 1);
        } else {
            closet.set(kind, 1);
        }
    });
    for (const key of closet.keys()) {
        result *= closet.get(key) + 1;
    }
    return result - 1;

}