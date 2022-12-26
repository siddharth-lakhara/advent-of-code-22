package solutions._7;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;
import java.util.stream.IntStream;

enum FileType {
    DIR,
    FILE
}

class FileSystemNode {
    public FileType type;
    public int size = -1;
    public String name;
    public FileSystemNode parentRef;
    public ArrayList<FileSystemNode> children = new ArrayList<>();

    FileSystemNode(FileType type, String name, FileSystemNode parentRef) {
        this.type = type;
        this.name = name;
        this.parentRef = parentRef;
    }

    public void addChild(FileSystemNode child) {
        this.children.add(child);
    }
}

public class Solution {

    private final String packageName;
    private HashMap<String, FileSystemNode> fileSystem;
    private FileSystemNode currentFileRef = null;
    private PriorityQueue<Integer> top3FileSize = new PriorityQueue<>();

    public Solution() {
        String[] pkg = this.getClass().getPackage().getName().split("\\.");
        this.packageName = pkg[pkg.length - 1];
    }

    private int solveExample() throws IOException {
        final String fileName = "/example.input";
        BufferedReader br = new BufferedReader(
                new FileReader("resources/" + this.packageName + fileName));
        Scanner inStream = new Scanner(br);

        this.fileSystem = new HashMap<>();

//        Build Filesystem
        while (inStream.hasNextLine()) {
            String input = inStream.nextLine();
            String[] cmdArr = input.split(" ");
            if (cmdArr[0].equals("$")) {
                if (cmdArr[1].equals("cd")) {
                    if (cmdArr[2].equals("..")) {
                        currentFileRef = currentFileRef.parentRef;
                    } else if (!fileSystem.containsKey(cmdArr[2])) {
                        fileSystem.put(cmdArr[2], new FileSystemNode(FileType.DIR, cmdArr[2], currentFileRef));
                        currentFileRef = fileSystem.get(cmdArr[2]);
                    } else {
                        currentFileRef = fileSystem.get(cmdArr[2]);
                    }
                }
            } else { // ls command output
                FileSystemNode newFileNode;
                if (cmdArr[0].equals("dir")) {
                    newFileNode = new FileSystemNode(FileType.DIR, cmdArr[1], currentFileRef);
                    fileSystem.put(cmdArr[1], newFileNode);
                } else {
                    newFileNode = new FileSystemNode(FileType.FILE, cmdArr[1], currentFileRef);
                    newFileNode.size = Integer.parseInt(cmdArr[0]);
                }
                currentFileRef.addChild(newFileNode);
            }
        }

        inStream.close();
        return calculateTop3Size();
    }

    private int calculateTop3Size() {
        calculateTop3Size("/");
        int sum = 0;
        while (top3FileSize.size() > 0) {
            sum += top3FileSize.remove();
        }
        return sum;
    }

    private void calculateTop3Size(String fileName) {
        currentFileRef = this.fileSystem.get(fileName);

        if (currentFileRef.size == -1) {
            currentFileRef.size = 0;
            for (FileSystemNode f: currentFileRef.children) {
                if (f.type == FileType.DIR && f.size == -1) {
                    calculateTop3Size(f.name);
                } else {
//                  handle FileType.FILE
                    currentFileRef.size += f.size;
                }

            }
        }

        if (currentFileRef.size <= 100000) {
            top3FileSize.add(currentFileRef.size);
            if (top3FileSize.size() > 3) {
                top3FileSize.remove();
            }
        }
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

