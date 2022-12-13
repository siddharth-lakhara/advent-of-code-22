package solutions._3;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

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

        ArrayList<Character> priorityString = new ArrayList<>();

        while (inStream.hasNextLine()) {
            String input = inStream.nextLine();
            HashSet<Character> compartment1 = new HashSet<>();
            HashSet<Character> repeatingChars = new HashSet<>();

            for (int i=0; i< input.length()/2; i++) {
                compartment1.add(input.charAt(i));
            }
            for (int i=input.length()/2; i< input.length(); i++) {
                if (compartment1.contains(input.charAt(i))) {
                    repeatingChars.add(input.charAt(i));
                }
            }
            priorityString.addAll(repeatingChars.stream().toList());
        }

        int answer = 0;
        for (char p: priorityString) {
            if (Character.isUpperCase(p)) {
                answer += p-'A'+27;
            } else {
                answer += p-'a'+1;
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

        ArrayList<Character> priorityString = new ArrayList<>();
        while (inStream.hasNextLine()) {
            String input = inStream.nextLine();

            HashSet<Character> compartment1 = new HashSet<>();
            HashSet<Character> repeatingChars = new HashSet<>();

            for (int i=0; i< input.length()/2; i++) {
                compartment1.add(input.charAt(i));
            }
            for (int i=input.length()/2; i< input.length(); i++) {
                if (compartment1.contains(input.charAt(i))) {
                    repeatingChars.add(input.charAt(i));
                }
            }
            priorityString.addAll(repeatingChars.stream().toList());
        }

        int answer = 0;
        for (char p: priorityString) {
            if (Character.isUpperCase(p)) {
                answer += p-'A'+27;
            } else {
                answer += p-'a'+1;
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

        ArrayList<Character> priorityString = new ArrayList<>();
        while (inStream.hasNextLine()) {
            String input1 = inStream.nextLine();
            String input2 = inStream.nextLine();
            String input3 = inStream.nextLine();

            HashSet<Character> level1 = new HashSet<>();
            HashSet<Character> level2 = new HashSet<>();
            HashSet<Character> finalLevel = new HashSet<>();

            for (char ch: input1.toCharArray()) {
                level1.add(ch);
            }

            for (char ch: input2.toCharArray()) {
                if (level1.contains(ch)) {
                    level2.add(ch);
                }
            }

            for (char ch: input3.toCharArray()) {
                if (level2.contains(ch)) {
                    finalLevel.add(ch);
                }
            }

//            commonInGroups.addAll()
        }

        int answer = 0;
        for (char p: priorityString) {
            if (Character.isUpperCase(p)) {
                answer += p-'A'+27;
            } else {
                answer += p-'a'+1;
            }
        }

        inStream.close();
        return answer;
    }

    public void solve() throws IOException {
//        int answer0 = solveExample();
//        System.out.println("Solution0: " + answer0);
//
        int answer1 = solve1();
        System.out.println("Solution1: " + answer1);
//
//        int answer2 = solve2();
//        System.out.println("Solution2: " + answer2);
    }
}

