package solutions._6;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Scanner;

public class Solution {
    private final String packageName;

    public Solution() {
        String[] pkg = this.getClass().getPackage().getName().split("\\.");
        this.packageName = pkg[pkg.length - 1];
    }

    private int solveExample() throws IOException {
        final String fileName = "/part1.input";
        BufferedReader br = new BufferedReader(
                new FileReader("resources/" + this.packageName + fileName));
        Scanner inStream = new Scanner(br);

        StringBuffer sbf = new StringBuffer();
        sbf.append(inStream.nextLine());
        sbf.trimToSize();

        int markerStart = 0;
        int uniqueCounter = 0;
        HashMap<Character, Integer> freqCounter = new HashMap<>();

        for (; markerStart < sbf.length(); markerStart += 1) {
//            Found ?? checking here to compensate 0 based idx
            if (uniqueCounter == 4) {
                break;
            }

            //            remove item came off window
            if (markerStart - 4 >= 0) {
                char oldChar = sbf.charAt(markerStart - 4);
                int oldFreq = freqCounter.get(oldChar);
                if (oldFreq == 2) {
                    uniqueCounter++;
                    freqCounter.put(oldChar, oldFreq - 1);
                } else if (oldFreq == 1) {
                    freqCounter.remove(oldChar);
                    uniqueCounter--;
                } else {
                    freqCounter.put(oldChar, oldFreq - 1);
                }
            }

//            add item came into window
            char ch = sbf.charAt(markerStart);
            if (freqCounter.containsKey(ch)) {
                if (freqCounter.get(ch) == 1) {
                    uniqueCounter--;
                }
                freqCounter.put(ch, freqCounter.get(ch) + 1);
            } else {
                freqCounter.put(ch, 1);
                uniqueCounter++;
            }


        }

        inStream.close();
        return markerStart;
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
        final String fileName = "/part1.input";
        BufferedReader br = new BufferedReader(
                new FileReader("resources/" + this.packageName + fileName));
        Scanner inStream = new Scanner(br);

        StringBuffer sbf = new StringBuffer();
        sbf.append(inStream.nextLine());
        sbf.trimToSize();

        int markerStart = 0;
        int uniqueCounter = 0;
        HashMap<Character, Integer> freqCounter = new HashMap<>();

        final int COUNTER_LIMIT = 14;

        for (; markerStart < sbf.length(); markerStart += 1) {
//            Found ?? checking here to compensate 0 based idx
            if (uniqueCounter == COUNTER_LIMIT) {
                break;
            }

            //            remove item came off window
            if (markerStart - COUNTER_LIMIT >= 0) {
                char oldChar = sbf.charAt(markerStart - COUNTER_LIMIT);
                int oldFreq = freqCounter.get(oldChar);
                if (oldFreq == 2) {
                    uniqueCounter++;
                    freqCounter.put(oldChar, oldFreq - 1);
                } else if (oldFreq == 1) {
                    freqCounter.remove(oldChar);
                    uniqueCounter--;
                } else {
                    freqCounter.put(oldChar, oldFreq - 1);
                }
            }

//            add item came into window
            char ch = sbf.charAt(markerStart);
            if (freqCounter.containsKey(ch)) {
                if (freqCounter.get(ch) == 1) {
                    uniqueCounter--;
                }
                freqCounter.put(ch, freqCounter.get(ch) + 1);
            } else {
                freqCounter.put(ch, 1);
                uniqueCounter++;
            }


        }

        inStream.close();
        return markerStart;
    }

    public void solve() throws IOException {
//        int answer0 = solveExample();
//        System.out.println("Solution0: " + answer0);

//        int answer1 = solve1();
//        System.out.println("Solution1: " + answer1);
//
        int answer2 = solve2();
        System.out.println("Solution2: " + answer2);
    }
}

