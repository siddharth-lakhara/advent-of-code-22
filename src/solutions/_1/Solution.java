package solutions._1;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Solution {
    private final String packageName;

    public Solution() {
        String[] pkg = this.getClass().getPackage().getName().split("\\.");
        this.packageName = pkg[pkg.length - 1];
    }

    private int solveExample() throws IOException {
        final String fileName = "/example.input";
        BufferedReader br = new BufferedReader(
                new FileReader("resources/" + this.packageName + fileName));
        Scanner inStream = new Scanner(br);

        int answer = Integer.MIN_VALUE;
        int currentValue = 0;

        while (inStream.hasNextLine()) {
            String input = inStream.nextLine();
            if (input.length() > 0) {
                currentValue += Integer.parseInt(input);
            } else {
                answer = Math.max(currentValue, answer);
                currentValue = 0;
            }
        }
        inStream.close();
        return answer;
    }

    private int solve1() throws IOException {
        final String fileName = "/part1.input";
        BufferedReader br = new BufferedReader(
                new FileReader("resources/" + this.packageName + fileName));
        Scanner inStream = new Scanner(br);

        int answer = Integer.MIN_VALUE;
        int currentValue = 0;

        while (inStream.hasNextLine()) {
            String input = inStream.nextLine();
            if (input.length() > 0) {
                currentValue += Integer.parseInt(input);
            } else {
                answer = Math.max(currentValue, answer);
                currentValue = 0;
            }
        }
        inStream.close();
        return answer;
    }

    private int solve2() throws IOException {
        final String fileName = "/part1.input";
        BufferedReader br = new BufferedReader(
                new FileReader("resources/" + this.packageName + fileName));
        Scanner inStream = new Scanner(br);

        final int MAX_CAPACITY = 3;
        PriorityQueue<Integer> max3Integers = new PriorityQueue<>();

        int currentValue = 0;
        while (inStream.hasNextLine()) {
            String input = inStream.nextLine();
            if (input.length() > 0) {
                currentValue += Integer.parseInt(input);
            } else {
                max3Integers.add(currentValue);
                if (max3Integers.size() > MAX_CAPACITY) {
                    max3Integers.poll();
                }
                currentValue = 0;
            }
        }
//        handle last elf
        max3Integers.add(currentValue);
        if (max3Integers.size() > MAX_CAPACITY) {
            max3Integers.poll();
        }

        inStream.close();
        return max3Integers.stream().reduce(0, Integer::sum);
    }

    public void solve() throws IOException {
//        int answer0 = solveExample();
//        System.out.println("Solution0: " + answer0);

//        int answer1 = solve1();
//        System.out.println("Solution1: " + answer1);

        int answer2 = solve2();
        System.out.println("Solution2: " + answer2);
    }
}

