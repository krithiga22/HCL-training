//package Day2.src;

public class MonthlyUsageAnalyser {

    public static void main(String[] args) {
        int[] monthlyUsage = {120, 150, 180, 200, 175, 220, 250, 270, 230, 190, 160, 140};
        long total = 0;
        int max = monthlyUsage[0];
        int min = monthlyUsage[0];
        for (int usage : monthlyUsage) {
            total += usage;
            if (usage > max) {
                max = usage;
            }
            if (usage < min) {
                min = usage;
            }
        }
        double average = (double) total / monthlyUsage.length;
        char grade = average <= Constants.LOW_USAGE_LIMIT ?
         Constants.GRADE_A : average <= Constants.MEDIUM_USAGE_LIMIT ? Constants.GRADE_B : Constants.GRADE_C;
        int[][] houseUsage = {{120, 150, 180, 200},{100, 130, 170, 190},{200, 220, 250, 270}};
        System.out.println("===== Monthly Usage Analyser =====");
        System.out.println("Number of months: " + monthlyUsage.length);
        System.out.println("Total usage: " + total);
        System.out.println("Average usage: " + average);
        System.out.println("Maximum usage: " + max);
        System.out.println("Minimum usage: " + min);
        System.out.println("Usage grade: " + grade);
        System.out.println();
        System.out.println("===== 3-House Usage Data =====");
        for (int house = 0; house < houseUsage.length; house++) {
            System.out.print("House " + (house + 1) + ": ");
            for (int month = 0; month < houseUsage[house].length; month++) {
                System.out.print(houseUsage[house][month] + " ");
            }
            System.out.println();
        }
        int maxInt = Integer.MAX_VALUE;
        System.out.println();
        System.out.println("===== Integer Overflow Demonstration =====");
        System.out.println("Maximum int value: " + maxInt);
        System.out.println("Maximum int + 1: " + (maxInt + 1));
        long safeValue = (long) maxInt + 1;
        System.out.println("Using long: " + safeValue);
        double precisionExample = 0.1 + 0.2;
        System.out.println();
        System.out.println("===== Floating-Point Precision =====");
        System.out.println("0.1 + 0.2 = " + precisionExample);
    }
}