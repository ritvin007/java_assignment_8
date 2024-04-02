import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class TestScoreAnalyzer {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> testScores = new ArrayList<>();

        System.out.print("Enter the number of students: ");
        int numStudents = scanner.nextInt();
        scanner.nextLine();

        for (int i = 0; i < numStudents; i++) {
            System.out.print("Enter test score for student " + (i + 1) + ": ");
            int score = scanner.nextInt();
            testScores.add(score);
        }

        int sum = 0;
        for (int score : testScores) {
            sum += score;
        }
        double averageScore = (double) sum / numStudents;

        Collections.sort(testScores);

        double medianScore;
        if (numStudents % 2 == 0) {
            medianScore = (testScores.get(numStudents / 2 - 1) + testScores.get(numStudents / 2)) / 2.0;
        } else {
            medianScore = testScores.get(numStudents / 2);
        }

        int aboveAverageCount = 0;
        int atAverageCount = 0;
        int belowAverageCount = 0;

        for (int score : testScores) {
            if (score > averageScore) {
                aboveAverageCount++;
            } else if (score == averageScore) {
                atAverageCount++;
            } else {
                belowAverageCount++;
            }
        }

        System.out.println("\nTest Score Analysis:");
        System.out.println("Number of students who scored above the average: " + aboveAverageCount + " (Median score: " + medianScore + ")");
        System.out.println("Number of students who scored at the average: " + atAverageCount + " (Median score: " + medianScore + ")");
        System.out.println("Number of students who scored below the average: " + belowAverageCount + " (Median score: " + medianScore + ")");

        scanner.close();
    }
}
