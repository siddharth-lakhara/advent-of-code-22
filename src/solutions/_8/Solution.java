package solutions._8;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

enum TruthMapValue {
    UNKNOWN(-1),
    TRUE(1),
    FALSE(0),
    PROCESSING(2);

    private int value;

    TruthMapValue(int value) {
        this.value = value;
    }

    public int getValue() { return value; }
}

public class Solution {
    private final String packageName;
    private ArrayList<ArrayList<Integer>> treeMap = new ArrayList<>();
    private ArrayList<ArrayList<TruthMapValue>> truthMap = new ArrayList<>();

    public Solution() {
        String[] pkg = this.getClass().getPackage().getName().split("\\.");
        this.packageName = pkg[pkg.length - 1];
    }

    private boolean isTreeVisible(int rowIdx, int colIdx) {
        if (truthMap.get(rowIdx).get(colIdx) == TruthMapValue.UNKNOWN) {
            truthMap.get(rowIdx).set(colIdx, TruthMapValue.PROCESSING);
            if (rowIdx == 0 || rowIdx == treeMap.size()-1) {
                truthMap.get(rowIdx).set(colIdx, TruthMapValue.TRUE);
                return true;
            }
            if (colIdx == 0 || colIdx == treeMap.get(0).size()-1) {
                truthMap.get(rowIdx).set(colIdx, TruthMapValue.TRUE);
                return true;
            }

            int currTreeHt = treeMap.get(rowIdx).get(colIdx);
            boolean isUpVisible = isTreeVisible(rowIdx-1, colIdx) && (treeMap.get(rowIdx-1).get(colIdx) < currTreeHt);
            boolean isBottomVisible = isTreeVisible(rowIdx+1, colIdx) && (treeMap.get(rowIdx+1).get(colIdx) < currTreeHt);
            boolean isLeftVisible = isTreeVisible(rowIdx, colIdx-1) && (treeMap.get(rowIdx).get(colIdx-1) < currTreeHt);
            boolean isRightVisible = isTreeVisible(rowIdx, colIdx+1) && (treeMap.get(rowIdx).get(colIdx+1) < currTreeHt);

            if (isUpVisible || isBottomVisible || isLeftVisible || isRightVisible) {
                truthMap.get(rowIdx).set(colIdx, TruthMapValue.TRUE);
                return true;
            } else {
                truthMap.get(rowIdx).set(colIdx, TruthMapValue.FALSE);
                return false;
            }
        } else if (truthMap.get(rowIdx).get(colIdx) == TruthMapValue.PROCESSING) {
            return true;
        } else {
            return truthMap.get(rowIdx).get(colIdx) == TruthMapValue.TRUE;
        }
    }

    private int solveExample() throws IOException {
        final String fileName = "/example.input";
        BufferedReader br = new BufferedReader(
                new FileReader("resources/" + this.packageName + fileName));
        Scanner inStream = new Scanner(br);

        while (inStream.hasNextLine()) {
            String[] strTreeLine = inStream.nextLine().split("");
            ArrayList<Integer> treeLine = (ArrayList<Integer>) Arrays.stream(strTreeLine).mapToInt(Integer::parseInt).boxed().collect(Collectors.toList());
            treeMap.add(treeLine);
            truthMap.add((ArrayList<TruthMapValue>) treeLine.stream().map((i) -> TruthMapValue.UNKNOWN).collect(Collectors.toList()));
        }

        int count = 0;
        int width = treeMap.get(0).size();
        for (int row = 0; row < treeMap.size(); row++) {
            for (int col = 0; col < width; col++) {
                if (isTreeVisible(row, col)) {
                    count++;
                }
            }
        }

        inStream.close();
        return count;
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
        System.out.println("Solution0: " + answer0);

//        int answer1 = solve1();
//        System.out.println("Solution1: " + answer1);
//
//        int answer2 = solve2();
//        System.out.println("Solution2: " + answer2);
    }
}

