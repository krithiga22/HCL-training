
package com.hcl.memory;
import java.util.ArrayList;
import java.util.List;
public class MemoryLab {
    public static void main(String[] args) {
        if (args.length == 0) {
            printUsage();
            return;
        }
        switch (args[0].toLowerCase()) {
            case "stack":
                stackExperiment();
                break;
            case "heap":
                heapExperiment();
                break;
            case "string":
                stringExperiment();
                break;
            case "gc":
                gcExperiment();
                break;
            case "integer":
                integerExperiment();
                break;
            default:
                printUsage();
        }
    }

    // Experiment 1: StackOverflowError
    private static void stackExperiment() {
        System.out.println("Starting recursive calls...");
        recursiveCall(0);
    }

    private static void recursiveCall(int depth) {
        if (depth % 1000 == 0) {
            System.out.println("Depth: " + depth);
        }

        recursiveCall(depth + 1);
    }

    // Experiment 2: OutOfMemoryError
    private static void heapExperiment() {
        List<byte[]> memoryBlocks = new ArrayList<>();
        long totalMB = 0;

        try {
            while (true) {
                memoryBlocks.add(new byte[1024 * 1024]);
                totalMB++;
                System.out.println("Allocated approximately "
                        + totalMB + " MB");
            }
        } catch (OutOfMemoryError error) {
            System.out.println("OutOfMemoryError occurred.");
            System.out.println("Approximate retained MB: "
                    + totalMB);
            throw error;
        }
    }

    // Experiment 3: String concatenation vs StringBuilder
    private static void stringExperiment() {
        int count = 20_000;

        long start = System.nanoTime();
        String result = "";

        for (int i = 0; i < count; i++) {
            result += i;
        }

        long stringTime = System.nanoTime() - start;

        start = System.nanoTime();
        StringBuilder builder = new StringBuilder();

        for (int i = 0; i < count; i++) {
            builder.append(i);
        }

        String builderResult = builder.toString();
        long builderTime = System.nanoTime() - start;

        System.out.println("String length: " + result.length());
        System.out.println("Builder length: "
                + builderResult.length());
        System.out.println("String += time: "
                + stringTime / 1_000_000.0 + " ms");
        System.out.println("StringBuilder time: "
                + builderTime / 1_000_000.0 + " ms");
    }

    // Experiment 4: Garbage collection
    private static void gcExperiment() {
        List<byte[]> blocks = new ArrayList<>();

        System.out.println("Allocating temporary objects...");

        for (int i = 0; i < 20; i++) {
            blocks.add(new byte[1024 * 1024]);
        }

        System.out.println("Allocated approximately 20 MB.");

        blocks.clear();

        System.out.println("References cleared.");
        System.gc();

        try {
            Thread.sleep(2000);
        } catch (InterruptedException error) {
            Thread.currentThread().interrupt();
        }

        System.out.println("GC experiment completed.");
    }

    // Experiment 5: Integer cache
    private static void integerExperiment() {
        Integer first = 127;
        Integer second = 127;

        Integer third = 128;
        Integer fourth = 128;

        System.out.println("127 using == : "
                + (first == second));
        System.out.println("128 using == : "
                + (third == fourth));

        System.out.println("128 using equals(): "
                + third.equals(fourth));

        System.out.println("128 using intValue(): "
                + (third.intValue() == fourth.intValue()));
    }

    private static void printUsage() {
        System.out.println("Choose an experiment:");
        System.out.println("stack   - StackOverflowError");
        System.out.println("heap    - OutOfMemoryError");
        System.out.println("string  - String performance");
        System.out.println("gc      - Garbage collection");
        System.out.println("integer - Integer cache");
    }
}
