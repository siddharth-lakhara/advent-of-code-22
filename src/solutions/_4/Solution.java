package solutions._4;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

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

        int answer = 0;
        while (inStream.hasNextLine()) {
            String input = inStream.nextLine();
            String[] rangeString = input.split(",");
            int[] range1 = Arrays.stream(rangeString[0].split("-")).mapToInt(s -> Integer.parseInt(s)).toArray();
            int[] range2 = Arrays.stream(rangeString[1].split("-")).mapToInt(s -> Integer.parseInt(s)).toArray();

//            is range 1 inside range 2
            boolean cond1 = range1[0] >= range2[0] && range1[1] <= range2[1];
//            is range 2 inside range 1
            boolean cond2 = range2[0] >= range1[0] && range2[1] <= range1[1];
            if (cond1 || cond2) {
                answer += 1;
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

        int answer = 0;
        while (inStream.hasNextLine()) {
            String input = inStream.nextLine();
            String[] rangeString = input.split(",");
            int[] range1 = Arrays.stream(rangeString[0].split("-")).mapToInt(s -> Integer.parseInt(s)).toArray();
            int[] range2 = Arrays.stream(rangeString[1].split("-")).mapToInt(s -> Integer.parseInt(s)).toArray();

//            is range 1 inside range 2
            boolean cond1 = range1[0] >= range2[0] && range1[1] <= range2[1];
//            is range 2 inside range 1
            boolean cond2 = range2[0] >= range1[0] && range2[1] <= range1[1];
            if (cond1 || cond2) {
                answer += 1;
            }
        }

        inStream.close();
        return answer;
    }

    private int solve2() throws IOException {
        final String fileName = "/part2.input";
        BufferedReader br = new BufferedReader(
                new FileReader("resources/" + this.packageName + fileName));
        Scanner inStream = new Scanner(br);

        while (inStream.hasNextLine()) {
            String input = inStream.nextLine();
            if (input.length() > 0) {

            }

        }

        inStream.close();
        return 0;
    }

    public void solve() throws IOException {
//        int answer0 = solveExample();
//        System.out.println("Solution0: " + answer0);

        int answer1 = solve1();
        System.out.println("Solution1: " + answer1);
//
//        int answer2 = solve2();
//        System.out.println("Solution2: " + answer2);
    }
}

