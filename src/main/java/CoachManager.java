package SwimmingSchool;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class CoachManager {
    public void monthlyReport(List<Booking> bookings) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter month number (e.g., 03 for March): ");
        int month = scanner.nextInt();

        Map<String, Integer> coachRatingsSum = new HashMap<>();
        Map<String, Integer> coachRatingsCount = new HashMap<>();

        for (Booking booking : bookings) {
            int bookingMonth = Integer.parseInt(booking.getLessonDate().split("-")[1]);
            if (bookingMonth == month) {
                String coachName = booking.getCoach().getName();
                int rating = booking.getRating();
                int sum = coachRatingsSum.getOrDefault(coachName, 0);
                coachRatingsSum.put(coachName, sum + rating);
                int count = coachRatingsCount.getOrDefault(coachName, 0);
                if(booking.getStatus().equals("attended")) {
                coachRatingsCount.put(coachName, count + 1);}
                else {coachRatingsCount.put(coachName, count );}
            }
        }

        System.out.println("\nMonthly Coach Report for Month " + month + ":");
        System.out.println("-----------------------------------------------");
        for (String coachName : coachRatingsSum.keySet()) {
            int sum = coachRatingsSum.get(coachName);
            int count = coachRatingsCount.get(coachName);
            double averageRating = count > 0 ? (double) sum / count : 0;
            System.out.printf("Coach: %-15s Average Rating: %.2f\n", coachName, averageRating);
        }
        System.out.println("-----------------------------------------------");
    }
}
