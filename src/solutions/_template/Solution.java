package solutions._template;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class Solution {
    private final String packageName;

    public Solution() {
        this.packageName = this.getClass().getPackage().getName();
    }

    private int solveExample() throws IOException {
        final String fileName = "/example.input";
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

    private int solve1() throws IOException {
        final String fileName = "/part1.input";
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
        int answer0 = solveExample();
        System.out.println("Solution1: " + answer0);

        int answer1 = solve1();
        System.out.println("Solution1: " + answer1);

        int answer2 = solve2();
        System.out.println("Solution2: " + answer2);
    }
}

