package SwimmingSchool;

import java.util.*;

class LearnerManager {
	private static final int MIN_AGE = 4;
	private static final int MAX_AGE = 11;

	public LearnerManager() {
	}

	public void registerLearner(List<Learner> learners) {
		Scanner scanner = new Scanner(System.in);
			System.out.println("\nRegister a new learner:");
			System.out.print("Enter name: ");
			String name = scanner.nextLine();
			System.out.print("Enter gender: ");
			String gender = scanner.nextLine();
			System.out.print("Enter age: ");
			int age = scanner.nextInt();
			while (age < MIN_AGE || age > MAX_AGE) {
				System.out.println("Age must be between 4 and 11. Please try again.");
				System.out.print("Enter age: ");
				age = scanner.nextInt();
			}
			scanner.nextLine(); 
			System.out.print("Enter emergency contact phone number: ");
			String emergencyContact = scanner.nextLine();
			System.out.print("Enter grade level (0 to 5): ");
			int gradeLevel = scanner.nextInt();
			while (gradeLevel < 0 || gradeLevel > 5) {
				System.out.println("Grade level must be between 0 and 5. Please try again.");
				System.out.print("Enter grade level: ");
				gradeLevel = scanner.nextInt();
			}
			Learner learner = new Learner(name, gender, age, emergencyContact, gradeLevel);
			learners.add(learner);
		
		System.out.println("Learner registered successfully!");
}
		
		public void monthlyReport(List<Booking> bookings) {
		Scanner scanner = new Scanner(System.in);
			System.out.print("Enter month number (e.g., 03 for March): ");
			int month = scanner.nextInt();

			Map<String, List<String>> learnerBookings = new HashMap<>();

			for (Booking booking : bookings) {
				int bookingMonth = Integer.parseInt(booking.getLessonDate().split("-")[1]);
				if (bookingMonth == month) {
					String learnerName = booking.getLearner().getName();
					String status = booking.getStatus();
					String bookingDetails = String.format("%s lesson on %s at %s with coach %s", status,
							booking.getLessonDate(), booking.getLessonTime(), booking.getCoach().getName());

					List<String> learnerBookingList = learnerBookings.getOrDefault(learnerName, new ArrayList<>());
					learnerBookingList.add(bookingDetails);
					learnerBookings.put(learnerName, learnerBookingList);
				}
			}

			System.out.println("\nMonthly Learner Report for Month " + month + ":");
			System.out.println("-----------------------------------------------------------");
			System.out.println("Learner Name   | Booked | Cancelled | Attended | Details");
			System.out.println("-----------------------------------------------------------");
			for (String learnerName : learnerBookings.keySet()) {
				int totalBooked = 0;
				int totalCancelled = 0;
				int totalAttended = 0;
				List<String> bookingsList = learnerBookings.get(learnerName);
				for (String bookingDetails : bookingsList) {

					if (bookingDetails.startsWith("booked")) {
						totalBooked++;
					} else if (bookingDetails.startsWith("cancelled")) {
						totalCancelled++;
					} else if (bookingDetails.startsWith("attended")) {
						totalAttended++;
					}
				}
				System.out.printf("%-14s | %-6d | %-9d | %-8d | %s\n", learnerName, totalBooked, totalCancelled,
						totalAttended, bookingsList);

			}
		
		System.out.println("-----------------------------------------------------------");
	}
}