class Node {
    constructor(value = "",cnt = 0) {
        this.value = value;
        this.cnt = cnt;
        this.children = new Map();
    }
}

class Trie {
    constructor() {
        this.root = new Node();
    }

    insert(string) {
        let currNode = this.root;

        for (const char of string) {
            let count = 0;
            if (!currNode.children.has(char)) {
                count++;
                currNode.children.set(char, new Node(currNode.value + char,count));
            }
            currNode = currNode.children.get(char);
            if(!count) currNode.cnt += ++count;
        }
    }
    autoCompletion(word) {
        let len = 0;
        let currNode = this.root;
        for (const char of word) {
            if(!currNode.children.has(char)) return len;
            len++;
            currNode = currNode.children.get(char);
            if(currNode.cnt === 1) return len;
        }
        return len;
    }
}
function solution(words) {
    const trie = new Trie();
    words.forEach(word => trie.insert(word));
    return words.reduce((acc, curr) => acc + trie.autoCompletion(curr), 0);
}