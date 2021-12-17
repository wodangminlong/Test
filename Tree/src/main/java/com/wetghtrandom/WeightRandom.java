package com.wetghtrandom;

import javafx.util.Pair;

import java.util.List;
import java.util.SortedMap;
import java.util.TreeMap;

/**
 * WeightRandom
 *
 * @author Administrator
 * @date 2021-12-17 09:21
 */
public class WeightRandom<K,V extends Number> {

    private final TreeMap<Double, K> weightMap = new TreeMap<>();

    public WeightRandom(List<Pair<K, V>> list) {
        list.forEach(kvPair -> {
            double lastWeight = weightMap.size() == 0 ? 0 : weightMap.lastKey();
            // 权重累加
            weightMap.put(kvPair.getValue().doubleValue() + lastWeight, kvPair.getKey());
        });
    }

    public K random() {
        double randomWeight = weightMap.lastKey() * Math.random();
        SortedMap<Double, K> tailMap = weightMap.tailMap(randomWeight, false);
        return weightMap.get(tailMap.firstKey());
    }

}
