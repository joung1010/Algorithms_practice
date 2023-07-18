function solution(m, musicinfos) {
    m = m.replace(/(C|D|F|G|A)#/g, (_, a) => a.toLowerCase());
    musicinfos = musicinfos
        .map((music) => {
            let [str, end, title, melody] = music.split(',');
            const [h1,m1] = str.split(":");
            const [h2,m2] = end.split(":");
            const time = (h2 - h1) * 60 + (m2 - m1);
            melody  = melody.replace(/(C|D|F|G|A)#/g, (_, a) => a.toLowerCase());
            return [time, title, melody.padEnd(time, melody).slice(0, time)];
        })
        .filter(([_, $, melody]) => melody.indexOf(m) >= 0)
        .sort(([a], [b]) => b - a);
    return musicinfos[0]?.[1] || '(None)';
}