package solutions._1;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class Solution {
    private int solveExample() throws IOException {
        BufferedReader br = new BufferedReader(
                new FileReader("resources/_template/example.input"));
        Scanner inStream = new Scanner(br);

        int answer = Integer.MIN_VALUE;

        while (inStream.hasNextLine()) {
            String input = inStream.nextLine();
            if (input.length() > 0) {

            }

        }
        return 0;
    }

    private int solve1() throws IOException {
        BufferedReader br = new BufferedReader(
                new FileReader("resources/_template/example.input"));
        Scanner inStream = new Scanner(br);

        while (inStream.hasNextLine()) {
            String input = inStream.nextLine();
            if (input.length() > 0) {

            }

        }

        return 0;
    }

    private int solve2() {
        return 0;
    }

//    private static int readInputs() throws IOException {
//        BufferedReader br = new BufferedReader(
//                new FileReader("resources/_template/example.input"));
//        Scanner inStream = new Scanner(br);
//
//        while (inStream.hasNextLine()) {
//            String input = inStream.nextLine();
//            if (input.length() > 0) {
//
//            }
//
//        }
//
//        return 0;
//    }

    public void solve() throws IOException {
        int answer0 = solveExample();
        int answer1 = solve1();
        int answer2 = solve2();
        System.out.println("Solution1: " + answer1);
        System.out.println("Solution2: " + answer2);
    }
}

