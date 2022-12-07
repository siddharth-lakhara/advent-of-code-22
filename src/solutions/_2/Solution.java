package solutions._2;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Scanner;

public class Solution {
    private final String packageName;
    private final HashMap<String, String> winMap = new HashMap<>();
    private final HashMap<String, String> loseMap = new HashMap<>();
    private final HashMap<String, Integer> myChoiceScores = new HashMap<>();
    private final HashMap<String, String> myChoiceMap = new HashMap<>();
    private final HashMap<String, String> opponentChoiceMap = new HashMap<>();

    public Solution() {
        String[] pkg = this.getClass().getPackage().getName().split("\\.");
        this.packageName = pkg[pkg.length - 1];

        winMap.put("R", "S");
        winMap.put("S", "P");
        winMap.put("P", "R");

        loseMap.put("R", "P");
        loseMap.put("S", "R");
        loseMap.put("P", "S");


        myChoiceScores.put("R", 1);
        myChoiceScores.put("S", 3);
        myChoiceScores.put("P", 2);

        myChoiceMap.put("X", "R");
        myChoiceMap.put("Y", "P");
        myChoiceMap.put("Z", "S");

        opponentChoiceMap.put("A", "R");
        opponentChoiceMap.put("B", "P");
        opponentChoiceMap.put("C", "S");
    }

    private int solveExample() throws IOException {
        final String fileName = "/example.input";
        BufferedReader br = new BufferedReader(
                new FileReader("resources/" + this.packageName + fileName));
        Scanner inStream = new Scanner(br);

        int score = 0;
        while (inStream.hasNextLine()) {
            String[] input = inStream.nextLine().split(" ");
            String opponentChoice = opponentChoiceMap.get(input[0]);
            String myChoice = myChoiceMap.get(input[1]);

//            add score for shape chosen
            score += myChoiceScores.get(myChoice);

//            decide game result
            if (opponentChoice.equals(myChoice)) { // draw
                score += 3;
            } else if (winMap.get(myChoice).equals(opponentChoice)) { // win
                score += 6;
            }
        }

        inStream.close();
        return score;
    }

    private int solve1() throws IOException {
        final String fileName = "/part1.input";
        BufferedReader br = new BufferedReader(
                new FileReader("resources/" + this.packageName + fileName));
        Scanner inStream = new Scanner(br);

        int score = 0;
        while (inStream.hasNextLine()) {
            String[] input = inStream.nextLine().split(" ");
            String opponentChoice = opponentChoiceMap.get(input[0]);
            String myChoice = myChoiceMap.get(input[1]);

//            add score for shape chosen
            score += myChoiceScores.get(myChoice);

//            decide game result
            if (opponentChoice.equals(myChoice)) { // draw
                score += 3;
            } else if (winMap.get(myChoice).equals(opponentChoice)) { // win
                score += 6;
            }
        }

        inStream.close();
        return score;
    }

    private int solve2() throws IOException {
        final String fileName = "/part1.input";
        BufferedReader br = new BufferedReader(
                new FileReader("resources/" + this.packageName + fileName));
        Scanner inStream = new Scanner(br);

        int score = 0;
        while (inStream.hasNextLine()) {
            String[] input = inStream.nextLine().split(" ");
            String opponentChoice = opponentChoiceMap.get(input[0]);
            String myChoice;

//            evaluate game decision
            if (input[1].equals("X")) { // lose
                myChoice = winMap.get(opponentChoice);
            } else if (input[1].equals("Y")) { // draw
                myChoice = opponentChoice;
            } else { // win
                myChoice = loseMap.get(opponentChoice);
            }
//            add score for shape chosen
            score += myChoiceScores.get(myChoice);

//            decide game result
            if (opponentChoice.equals(myChoice)) { // draw
                score += 3;
            } else if (winMap.get(myChoice).equals(opponentChoice)) { // win
                score += 6;
            }
        }

        inStream.close();
        return score;
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

