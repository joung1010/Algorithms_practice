function solution(bridge_length, weight, truck_weights) {
    const bridge = [];
    const weights = [...truck_weights];
    let totalWeight = 0;
    let sec = 1;

    while (weights.length || bridge.length) {
        if (bridge_length >= bridge.length && weight >= totalWeight + weights[0]) {
            const truckWeight =  weights.shift();
            bridge.push({pass: bridge_length + sec, truckWeight});
            totalWeight += truckWeight;
            sec++;
        } else {
            const {pass,truckWeight} = bridge.shift();
            if (sec < pass) sec = pass;
            totalWeight -= truckWeight;
        }
    }
    return sec;
}