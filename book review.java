import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class BookReviewAnalyzer {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<String, Integer> ratingRangeCount = new HashMap<>();
        Map<String, Integer> reviewSentimentCount = new HashMap<>();

        ratingRangeCount.put("1-5 Stars", 0);
        ratingRangeCount.put("6-10 Stars", 0);
        reviewSentimentCount.put("Positive", 0);
        reviewSentimentCount.put("Neutral", 0);
        reviewSentimentCount.put("Negative", 0);

        System.out.print("Enter the number of book reviews: ");
        int numReviews = scanner.nextInt();
        scanner.nextLine();

        for (int i = 0; i < numReviews; i++) {
            System.out.println("\nEnter details for Book Review " + (i + 1) + ":");
            System.out.print("Rating (out of 10): ");
            int rating = scanner.nextInt();
            scanner.nextLine();

            if (rating >= 1 && rating <= 5) {
                ratingRangeCount.put("1-5 Stars", ratingRangeCount.get("1-5 Stars") + 1);
            } else if (rating >= 6 && rating <= 10) {
                ratingRangeCount.put("6-10 Stars", ratingRangeCount.get("6-10 Stars") + 1);
            }

            System.out.print("Sentiment (Positive, Neutral, Negative): ");
            String sentiment = scanner.nextLine();

            if (sentiment.equalsIgnoreCase("Positive")) {
                reviewSentimentCount.put("Positive", reviewSentimentCount.get("Positive") + 1);
            } else if (sentiment.equalsIgnoreCase("Neutral")) {
                reviewSentimentCount.put("Neutral", reviewSentimentCount.get("Neutral") + 1);
            } else if (sentiment.equalsIgnoreCase("Negative")) {
                reviewSentimentCount.put("Negative", reviewSentimentCount.get("Negative") + 1);
            }
        }

        System.out.println("\nBook Review Analysis:");
        System.out.println("Number of Books Reviewed (1-5 Stars): " + ratingRangeCount.get("1-5 Stars"));
        System.out.println("Number of Books Reviewed (6-10 Stars): " + ratingRangeCount.get("6-10 Stars"));
        System.out.println("Positive Reviews: " + reviewSentimentCount.get("Positive"));
        System.out.println("Neutral Reviews: " + reviewSentimentCount.get("Neutral"));
        System.out.println("Negative Reviews: " + reviewSentimentCount.get("Negative"));

        scanner.close();
    }
}
