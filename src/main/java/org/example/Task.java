package org.example;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.stream.Collectors;

public class Task {
    private final HashMap<Integer, Integer> freq = new LinkedHashMap<>();
    private final HashMap<Integer, Double> freqPercentage = new LinkedHashMap<>();

    private double M = 0;
    private double Msqr = 0;
    private double D = 0;
    private double Ssqr = 0;
    private double S = 0;

    private double X = 0;

    private final Double[] interval = new Double[2];

    private final List<Double> column3 = new ArrayList<>();
    private List<Double> column4 = new ArrayList<>();
    private final List<Double> column5 = new ArrayList<>();
    private final List<Double> column6 = new ArrayList<>();
    private final List<Double> column7 = new ArrayList<>();
    private final List<Double> column8 = new ArrayList<>();

    public Task(List<Integer> source) {
        if(source.size() != 50) {
            throw new RuntimeException("Тут не 50 чисел, а " + source.size());
        }
        initFreqMap(source);
        initFeqPercentageMap();
        M = initM();
        Msqr = initM(true);

        D = Msqr - M * M;
        Ssqr = ((D * 50L) / 49L);
        S = Math.sqrt(Ssqr);

        initInterval();
        initColumn3();
    }

    public String showColumn3() {
        return "Task 8 \n" +
                "column 3: " + column3.toString();
    }

    public String showEverythingBefore8() {
        return "Task 1 = " + freq + "; \n" +
                "M = " + M + "; \n" +
                "Msqr = " + Msqr + "; \n" +
                "D = " + D + "; \n" +
                "Ssqr = " + Ssqr + "; \n" +
                "S = " + S + "; \n" +
                "task 5: " + freqPercentage.toString() + "; \n" +
                "task 7: " + interval[0] + " < Mx < " + interval[1] + "; \n" +
                "" ;
    }

    public String showLastTasks() {
        return "column 5: " + column5.toString() + "; \n" +
                "column 6: " + column6.toString() + "; \n" +
                "column 7: " + column7.toString() + "; \n" +
                "column 8: " + column8.toString() + "; \n" +
                "Xкр = " + X + "; \n" +
                "Поддтверждаем: " + (X < 9.24) + ";";
    }

    void initTask8(List<Double> column4) {
        initColumn3();
        this.column4 = column4;
        initColumn5();
        initColumn6();
        initColumn7();
        initColumn8();
    }

    private void initColumn3() {
        for (int i = 0; i < 7; i++) {
            double Xk = -1.5 + i;
            column3.add((Xk - M) / S);
        }
    }
    private void initColumn5() {
        for (int i = 0; i < 8; i++) {
            column5.add(column4.get(i + 1) - column4.get(i));
        }
    }
    private void initColumn6() {
        for (int i = 0; i < 8; i++) {
            column6.add(column5.get(i) * 50L);
        }
    }
    private void initColumn7() {
        for (int i = 0; i <8; i++) {
            column7.add(Double.valueOf(freq.get(i - 2)));
        }
    }
    private void initColumn8() {
        for (int i = 0; i < 8; i++) {
            column8.add((Math.pow (column7.get(i) - column6.get(i), 2)) / column6.get(i));
            X += column8.get(i);
        }
    }

    private void initInterval() {
        interval[0] = M - (S * 1.68)/Math.sqrt(50);
        interval[1] = M + (S * 1.68)/Math.sqrt(50);
    }

    private void initFeqPercentageMap() {
        freq.forEach((k, v) -> {
            freqPercentage.put(k, ((double) v / 50L));
        });
    }

    private void initFreqMap(List<Integer> source) {
        List<Integer> sortedList = source.stream().sorted().toList();
        for (int i: sortedList) {
            freq.merge(i, 1, Integer::sum);
        }
    }

    private double initM() {
        final double[] acc = {0};
        freq.forEach((k, v) -> {
            acc[0] += k*v;
        });
        acc[0] /= 50L;
        return acc[0];
    }

    private double initM(Boolean isScr) {
        final double[] acc = {0};
        freq.forEach((k, v) -> {
            acc[0] += Math.pow(k, 2) * v;
        });
        acc[0] /= 50L;
        return acc[0];
    }
}
