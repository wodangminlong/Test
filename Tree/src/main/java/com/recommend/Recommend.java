package com.recommend;

import java.util.List;
import java.util.stream.IntStream;

/**
 * @author Administrator
 * @date 2021-12-17 16:15
 */
public class Recommend {

    private Recommend() {

    }

    /**
     * 皮尔森相关系数计算
     *
     * @param xs    xs
     * @param ys    ys
     * @return  double
     */
    public static double getRelate(List<Integer> xs, List<Integer> ys) {
        int n = xs.size();
        double ex = xs.stream().mapToDouble(x-> x).sum();
        double ey = ys.stream().mapToDouble(y-> y).sum();
        double ex2 = xs.stream().mapToDouble(x-> Math.pow(x, 2)).sum();
        double ey2 = ys.stream().mapToDouble(y-> Math.pow(y, 2)).sum();
        double exy = IntStream.range(0, n).mapToDouble(i-> xs.get(i) * ys.get(i)).sum();

        double numerator = exy - ex * ey / n;

        double denominator = Math.sqrt((ex2 - Math.pow(ex, 2) / n) * (ey2 - Math.pow(ey, 2) / n));

        if (denominator == 0) {
            return 0.0;
        }
        return numerator / denominator;
    }

}
