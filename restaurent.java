import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class RestaurantRatingAnalyzer {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<String, Integer> ratingRangeCount = new HashMap<>();
        Map<String, Double> ratingRangeTotal = new HashMap<>();

        ratingRangeCount.put("1-5", 0);
        ratingRangeCount.put("6-10", 0);
        ratingRangeTotal.put("1-5", 0.0);
        ratingRangeTotal.put("6-10", 0.0);

        System.out.print("Enter the number of restaurants: ");
        int numRestaurants = scanner.nextInt();
        scanner.nextLine();

        for (int i = 0; i < numRestaurants; i++) {
            System.out.print("Enter rating for restaurant " + (i + 1) + " (out of 10): ");
            double rating = scanner.nextDouble();
            scanner.nextLine();

            if (rating >= 1 && rating <= 5) {
                ratingRangeCount.put("1-5", ratingRangeCount.get("1-5") + 1);
                ratingRangeTotal.put("1-5", ratingRangeTotal.get("1-5") + rating);
            } else if (rating >= 6 && rating <= 10) {
                ratingRangeCount.put("6-10", ratingRangeCount.get("6-10") + 1);
                ratingRangeTotal.put("6-10", ratingRangeTotal.get("6-10") + rating);
            } else {
                System.out.println("Invalid rating. Rating should be between 1 and 10.");
                i--;
            }
        }

        System.out.println("\nRestaurant Rating Analysis:");

        for (Map.Entry<String, Integer> entry : ratingRangeCount.entrySet()) {
            String range = entry.getKey();
            int count = entry.getValue();
            double totalRating = ratingRangeTotal.get(range);
            double averageRating = count == 0 ? 0.0 : totalRating / count;

            System.out.println("Number of restaurants rated " + range + ": " + count);
            System.out.println("Average rating for " + range + ": " + averageRating);
            System.out.println();
        }

        scanner.close();
    }
}
