package solutions._5;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Solution {
    private final String packageName;
    private final String ptString = "move (\\d+) from (\\d+) to (\\d+)";
    private final Pattern pattern;

    public Solution() {
        String[] pkg = this.getClass().getPackage().getName().split("\\.");
        this.packageName = pkg[pkg.length - 1];
        this.pattern = Pattern.compile(ptString);
    }

    private String solveExample() throws IOException {
        final String fileName = "/part1.input";
        BufferedReader br = new BufferedReader(
                new FileReader("resources/" + this.packageName + fileName));
        Scanner inStream = new Scanner(br);

        ArrayList<String> drawing = new ArrayList<>();

        while (true) {
            String input = inStream.nextLine();
            if (input.length() == 0) {
                break;
            } else {
                drawing.add(input);
            }
        }

        String[] lastLine = drawing.get(drawing.size()-1).split(" ");
        int totalStacks = Integer.parseInt(lastLine[lastLine.length-1]);
        ArrayList<Deque<String>> stacks = new ArrayList<>(totalStacks);
        for (int idx = 0; idx < totalStacks; idx++) {
            stacks.add(new LinkedList<>());
        }
        drawing.remove(drawing.size()-1);

        for (String d: drawing) {
            for (int idx = 1; idx < d.length(); idx += 4) {
                char ch = d.charAt(idx);
                if (ch != ' ') {
                    int crateNum = (idx-1)/4;
                    stacks.get(crateNum).add(Character.toString(ch));
                }
            }
        }

        while (inStream.hasNextLine()) {
            String cmd = inStream.nextLine();
            Matcher m = pattern.matcher(cmd);
            m.find(0);
            int numStacks = Integer.parseInt(m.group(1));
            int fromStack = Integer.parseInt(m.group(2));
            int toStack = Integer.parseInt(m.group(3));
            while (numStacks > 0) {
                numStacks -= 1;
                stacks.get(toStack-1).addFirst(stacks.get(fromStack-1).pop());
            }
        }

        String answer = "";
        for (Deque<String> dq: stacks) {
            String crate = dq.peekFirst();
            if (crate != null) {
                answer += crate;
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

        while (inStream.hasNextLine()) {
            String input = inStream.nextLine();
            if (input.length() > 0) {

            }

        }

        inStream.close();
        return 0;
    }

    private String solve2() throws IOException {
        final String fileName = "/part1.input";
        BufferedReader br = new BufferedReader(
                new FileReader("resources/" + this.packageName + fileName));
        Scanner inStream = new Scanner(br);

        ArrayList<String> drawing = new ArrayList<>();

        while (true) {
            String input = inStream.nextLine();
            if (input.length() == 0) {
                break;
            } else {
                drawing.add(input);
            }
        }

        String[] lastLine = drawing.get(drawing.size()-1).split(" ");
        int totalStacks = Integer.parseInt(lastLine[lastLine.length-1]);
        ArrayList<LinkedList<String>> stacks = new ArrayList<>(totalStacks);
        for (int idx = 0; idx < totalStacks; idx++) {
            stacks.add(new LinkedList<>());
        }
        drawing.remove(drawing.size()-1);

        for (String d: drawing) {
            for (int idx = 1; idx < d.length(); idx+=4) {
                char ch = d.charAt(idx);
                if (ch != ' ') {
                    int crateNum = (idx-1)/4;
                    stacks.get(crateNum).add(Character.toString(ch));
                }
            }
        }

        while (inStream.hasNextLine()) {
            String cmd = inStream.nextLine();
            Matcher m = pattern.matcher(cmd);
            m.find(0);
            int numStacks = Integer.parseInt(m.group(1));
            int fromStack = Integer.parseInt(m.group(2));
            int toStack = Integer.parseInt(m.group(3));

            List<String> subList = stacks.get(fromStack-1).subList(0, numStacks);
            stacks.get(toStack-1).addAll(0, subList);
            subList.clear();
        }

        String answer = "";
        for (Deque<String> dq: stacks) {
            String crate = dq.peekFirst();
            if (crate != null) {
                answer += crate;
            }
        }

        inStream.close();
        return answer;
    }

    public void solve() throws IOException {
//        String answer0 = solveExample();
//        System.out.println("Solution0: " + answer0);

//        int answer1 = solve1();
//        System.out.println("Solution1: " + answer1);
//
        String answer2 = solve2();
        System.out.println("Solution2: " + answer2);
    }
}

