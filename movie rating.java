import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class MovieRatingAnalyzer {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<String, Double> categoryTotalRatings = new HashMap<>();
        Map<String, Integer> categoryMovieCount = new HashMap<>();

        System.out.print("Enter the number of movies: ");
        int numMovies = scanner.nextInt();
        scanner.nextLine();

        for (int i = 0; i < numMovies; i++) {
            System.out.println("\nEnter details for Movie " + (i + 1) + ":");
            System.out.print("Category (e.g., PG, PG-13, R): ");
            String category = scanner.nextLine();
            System.out.print("Rating (out of 10): ");
            double rating = scanner.nextDouble();
            scanner.nextLine();

            categoryTotalRatings.put(category, categoryTotalRatings.getOrDefault(category, 0.0) + rating);
            categoryMovieCount.put(category, categoryMovieCount.getOrDefault(category, 0) + 1);
        }

        System.out.println("\nMovie Ratings Analysis:");

        for (Map.Entry<String, Integer> entry : categoryMovieCount.entrySet()) {
            String category = entry.getKey();
            int movieCount = entry.getValue();
            double totalRating = categoryTotalRatings.get(category);
            double averageRating = totalRating / movieCount;

            System.out.println("Category: " + category);
            System.out.println("Number of Movies: " + movieCount);
            System.out.println("Average Rating: " + averageRating);
            System.out.println();
        }

        scanner.close();
    }
}
