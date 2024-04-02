import java.util.Scanner;

public class ProjectCompletionTracker {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the number of student projects: ");
        int numProjects = scanner.nextInt();

        int onTimeCount = 0;
        int lateCount = 0;
        int earlyCount = 0;
        double totalCompletionTime = 0;

        for (int i = 1; i <= numProjects; i++) {
            System.out.println("\nEnter details for Project " + i + ":");
            System.out.print("Completion time (in days): ");
            int completionTime = scanner.nextInt();

            totalCompletionTime += completionTime;

            if (completionTime == 0) {
                onTimeCount++;
            } else if (completionTime < 0) {
                earlyCount++;
            } else {
                lateCount++;
            }
        }

        System.out.println("\nNumber of projects completed on time: " + onTimeCount);
        System.out.println("Number of projects completed late: " + lateCount);
        System.out.println("Number of projects completed early: " + earlyCount);

        double averageCompletionTime = totalCompletionTime / numProjects;
        System.out.println("Average completion time for each student: " + averageCompletionTime + " days");

        scanner.close();
    }
}
