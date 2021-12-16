package com.wetghtrandom;

import javafx.util.Pair;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class WeightRandomTest {

    List<Pair<String, Integer>> list;
    private WeightRandom<String, Integer> random;

    public void random() {
        Map<String, Integer> countMap = new HashMap<>(6);
        int num = 100000000;
        for (int i = 0; i < num; i++) {
            String randomKey = random.random();
            countMap.put(randomKey, countMap.getOrDefault(randomKey, 0) + 1);
        }

        list.forEach(stringIntegerPair -> {
            String key = stringIntegerPair.getKey();
            Integer count = countMap.get(key);
            BigDecimal i = BigDecimal.valueOf(count).divide(BigDecimal.valueOf(num), 10, RoundingMode.HALF_UP).multiply(BigDecimal.valueOf(100));
            BigDecimal result = BigDecimal.valueOf(stringIntegerPair.getValue()).multiply(BigDecimal.valueOf(10));
            BigDecimal s = result.subtract(i);
            System.out.printf("%s: %s range: %s%s difference: %s;%n", key, count, i, "%", s);
        });
    }

    private void init() {
        list = new ArrayList<>();
        Pair<String, Integer> aPair = new Pair<>("A", 1);
        Pair<String, Integer> bPair = new Pair<>("B", 2);
        Pair<String, Integer> cPair = new Pair<>("C", 3);
        Pair<String, Integer> dPair = new Pair<>("D", 4);
        list.add(aPair);
        list.add(bPair);
        list.add(cPair);
        list.add(dPair);

        random = new WeightRandom<>(list);
    }

    public static void main(String[] args) {
        long startTime = System.currentTimeMillis();
        System.out.println("================start time: " + startTime);
        WeightRandomTest weightRandomTest = new WeightRandomTest();
        weightRandomTest.init();

        weightRandomTest.random();
        System.out.println("================use time: " + (System.currentTimeMillis() - startTime) + " ms");
    }

}
