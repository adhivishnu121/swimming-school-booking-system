package SwimmingSchool;

import java.util.*;

public class CoachManager {
	public void monthlyReport(List<Coach> coaches) {
		Scanner scanner = new Scanner(System.in);
			System.out.print("Enter month number (e.g., 03 for March): ");
			int month = scanner.nextInt();

			System.out.println("\nMonthly Coach Report for Month " + month + ":");
		
		System.out.println("-----------------------------------------------");
		for (Coach coach : coaches) {
			double averageRating = coach.getAverageRating();
			System.out.printf("Coach: %-15s Average Rating: %.2f\n", coach.getName(), averageRating);
		}
		System.out.println("-----------------------------------------------");
	}
}
