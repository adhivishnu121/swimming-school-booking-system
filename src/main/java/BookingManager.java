package SwimmingSchool;
import java.time.*;
import java.time.LocalDate;
import java.time.temporal.TemporalAdjusters;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class BookingManager {
    private List<Booking> bookings;
    private int id =2000;
    private int MAX_CAPACITY=4;
    public BookingManager() {
        this.bookings = new ArrayList<>();
        addSampleBookings();

    }

    private void addSampleBookings() {
        List<Learner> learners = getSampleLearners();
        List<Coach> coaches = getSampleCoaches();
     // Get the current date
        LocalDate currentDate = LocalDate.now();

        // Calculate the next Monday
        LocalDate nextMonday = currentDate.with(TemporalAdjusters.next(DayOfWeek.MONDAY));

        // Calculate the next Wednesday
        LocalDate nextWednesday = currentDate.with(TemporalAdjusters.next(DayOfWeek.WEDNESDAY));

        // Calculate the next Friday
        LocalDate nextFriday = currentDate.with(TemporalAdjusters.next(DayOfWeek.FRIDAY));

        // Calculate the next Saturday
        LocalDate nextSaturday = currentDate.with(TemporalAdjusters.next(DayOfWeek.SATURDAY));

     // For Monday, Wednesday, and Friday
        bookings.add(new Booking(learners.get(0), nextMonday.toString(), "16:00", coaches.get(0), 3, generateLessonId()));
        bookings.add(new Booking(learners.get(1), nextMonday.toString(), "16:00", coaches.get(0), 3, generateLessonId()));
        bookings.add(new Booking(learners.get(2), nextMonday.toString(), "16:00", coaches.get(0), 3, generateLessonId()));
        bookings.add(new Booking(learners.get(3), nextWednesday.toString(), "16:00", coaches.get(0), 1, generateLessonId()));
        bookings.add(new Booking(learners.get(4), nextWednesday.toString(), "17:00", coaches.get(1), 2, generateLessonId()));
        bookings.add(new Booking(learners.get(5), nextWednesday.toString(), "18:00", coaches.get(2), 3, generateLessonId()));
        bookings.add(new Booking(learners.get(6), nextFriday.toString(), "16:00", coaches.get(0), 4, generateLessonId()));
        bookings.add(new Booking(learners.get(7), nextFriday.toString(), "17:00", coaches.get(1), 5, generateLessonId()));
        bookings.add(new Booking(learners.get(8), nextFriday.toString(), "18:00", coaches.get(2), 1, generateLessonId()));
        bookings.add(new Booking(learners.get(9), nextSaturday.toString(), "14:00", coaches.get(0), 2, generateLessonId()));
        bookings.add(new Booking(learners.get(0), nextSaturday.toString(), "15:00", coaches.get(1), 3, generateLessonId()));
    }
    private List<Learner> getSampleLearners() {
        List<Learner> learners = new ArrayList<>();
        learners.add(new Learner("lrn1", "Male", 10, "123-456-7890", 3));
        learners.add(new Learner("lrn2", "Female", 8, "234-567-8901", 2));
        learners.add(new Learner("lrn3", "Male", 9, "345-678-9012", 4));
        learners.add(new Learner("lrn4", "Female", 7, "456-789-0123", 1));
        learners.add(new Learner("lrn5", "Male", 6, "567-890-1234", 0));
        learners.add(new Learner("lrn6", "Female", 5, "678-901-2345", 2));
        learners.add(new Learner("lrn7", "Male", 11, "789-012-3456", 5));
        learners.add(new Learner("lrn8", "Female", 4, "890-123-4567", 3));
        learners.add(new Learner("lrn9", "Male", 8, "901-234-5678", 2));
        learners.add(new Learner("lrn10", "Female", 9, "012-345-6789", 4));
        return learners;
    }

    private List<Coach> getSampleCoaches() {
        List<Coach> coaches = new ArrayList<>();
        coaches.add(new Coach("Coach1"));
        coaches.add(new Coach("Coach2"));
        coaches.add(new Coach("Coach3"));
        return coaches;
    }
	public void bookLesson(List<Learner> learners, List<Coach> coaches) {
        Scanner scanner = new Scanner(System.in);

        // Display timetable based on learner's choice
        System.out.println("Select the way to view the timetable:");
        System.out.println("1. View by day");
        System.out.println("2. View by grade level");
        System.out.println("3. View by coach's name");
        System.out.print("Enter your choice: ");
        int choice = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        switch (choice) {
            case 1:
                System.out.print("Enter the day (Monday, Wednesday, Friday, Saturday): ");
                String dayInput = scanner.nextLine();
                DayOfWeek day = DayOfWeek.valueOf(dayInput.toUpperCase());
                viewTimetableByDay(day, bookings);
                createBooking(learners, coaches);
                break;
            case 2:
                System.out.print("Enter the grade level (1, 2, 3, 4, 5): ");
                int gradeLevel = scanner.nextInt();
                viewTimetableByGrade(gradeLevel, bookings);
                createBooking(learners, coaches);

                break;
            case 3:
                System.out.print("Enter the coach's name: ");
                String coachName = scanner.nextLine();
                viewTimetableByCoach(coachName, bookings);
                createBooking(learners, coaches);

                break;
            default:
                System.out.println("Invalid choice.");
                return;
        }



    }
    
    public void createBooking(List<Learner> learners, List<Coach> coaches) {
        Scanner scanner = new Scanner(System.in);
        
        
        System.out.print("Enter your name: ");
        String learnerName = scanner.nextLine().trim();
        System.out.print("Enter your ID: ");
        int learnerId = scanner.nextInt();
        scanner.nextLine(); // Consume newline
       
        Learner learner = null;
        for (Learner l : learners) {
        	System.out.println("Debug: "+l.getId());

            if (l.getName().equalsIgnoreCase(learnerName)  && l.getId() == learnerId) {
                learner = l;
                break;
            }
        }

        if (learner == null) {
            System.out.println("Invalid learner name . Booking unsuccessful.");
            return;
        }

        System.out.print("Enter lesson date (YYYY-MM-DD): ");
        String lessonDate = scanner.nextLine();
        LocalDate date = LocalDate.parse(lessonDate);
        DayOfWeek dayOfWeek = date.getDayOfWeek();

        System.out.print("Enter lesson time (HH:MM): ");
        String lessonTime = scanner.nextLine();
        LocalTime time = LocalTime.parse(lessonTime);

        if (dayOfWeek == DayOfWeek.MONDAY || dayOfWeek == DayOfWeek.WEDNESDAY || dayOfWeek == DayOfWeek.FRIDAY) {
            if (!(time.equals(LocalTime.of(16, 0)) || time.equals(LocalTime.of(17, 0)) || time.equals(LocalTime.of(18, 0)))) {
                System.out.println("Sorry, the time slot doesn't exist for the selected day.");
                return;
            }
        } else if (dayOfWeek == DayOfWeek.SATURDAY) {
            if (!(time.equals(LocalTime.of(14, 0)) || time.equals(LocalTime.of(15, 0)))) {
                System.out.println("Sorry, the time slot doesn't exist for the selected day.");
                return;
            }
        } else {
            System.out.println("INVALID DAY OF THE WEEK.");
            return;
        }
        
        int bookingsForTimeSlot = countBookingsForTimeSlot(lessonDate, lessonTime);
        if (bookingsForTimeSlot >= 4) {
            System.out.println("Sorry, the time slot is already full. Cannot create a booking.");
            return;
        }
          System.out.print("Enter coach's name: ");
        String coachName = scanner.nextLine();
        Coach coach = findCoachByName(coaches, coachName);
        if (coach == null) {
            System.out.println("Coach not found.");
            return;
        }

        int minGradeLevel = Math.max(learner.getGradeLevel(), 1);
        int maxGradeLevel = Math.min(learner.getGradeLevel() + 1, 5); // Grade 1 learners can book Grade 1 or Grade 2

        System.out.print("Enter grade level: ");
        int gradeLevel = scanner.nextInt();
        scanner.nextLine(); 
       
        
        // Check if the selected grade level is within the allowed range
        if (!(gradeLevel == minGradeLevel || gradeLevel == maxGradeLevel)) {
            System.out.println("Grade " + learner.getGradeLevel() + " learners can only book Grade " + minGradeLevel + " or Grade " + maxGradeLevel + " lessons.");
            return;
        }
        int lessonId = generateLessonId(); // Implement your logic to generate a unique lesson ID

        // Create the new booking
        Booking newBooking = new Booking(learner, lessonDate, lessonTime, coach, gradeLevel, lessonId);

        // Add the booking to the list of bookings
        bookings.add(newBooking);

        System.out.println("Booking created successfully.");
        displayTimetable(bookings);
    }
    
    private int countBookingsForTimeSlot(String lessonDate, String lessonTime) {
        int count = 0;
        for (Booking booking : bookings) {
            if (booking.getLessonDate().equals(lessonDate) && booking.getLessonTime().equals(lessonTime)) {
                count++;
            }
        }
        return count;
    }
    
    
    public void displayTimetable(List<Booking> bookings) {
        if (bookings == null || bookings.isEmpty()) {
            System.out.println("No bookings available.");
            return;
        }

        System.out.println("-------------------------------------------------------------------------");
        System.out.printf("| %-10s | %-10s | %-10s | %-15s | %-10s |\n", "Day", "Time", "Coach", "Learner", "Grade");
        System.out.println("-------------------------------------------------------------------------");

        for (Booking booking : bookings) {
            System.out.printf("| %-10s | %-10s | %-10s | %-15s | %-10s |\n",
                    booking.getLessonDate(), booking.getLessonTime(), booking.getCoach().getName(),
                    (booking.getLearner() != null ? booking.getLearner().getName() : ""),
                    booking.getGradeLevel());
        }
        System.out.println("-------------------------------------------------------------------------");
    }

    public int getVacancies(String lessonDate, String lessonTime) {
        // Count the number of learners booked for the current time slot
        int bookedLearners = 0;
        // Loop through all bookings to find the ones with the same date and time
        for (Booking booking :bookings) {
            if (booking.getLessonDate().equals(lessonDate) && booking.getLessonTime().equals(lessonTime)) {
                bookedLearners++;
            }
        }
        // Calculate and return the available vacancies
        return MAX_CAPACITY - bookedLearners;
    }
    
    public void viewTimetableByDay(DayOfWeek day, List<Booking> bookings) {
        System.out.println("Timetable for " + day + ":");
        boolean foundBookings = false;
            for (Booking booking : bookings) {
            if (booking.getDayOfWeek() == day) {
                System.out.println("Lesson ID: " + booking.getlessonId());
                System.out.println("Grade Level: " + booking.getGradeLevel());
                System.out.println("Time: " + booking.getTime());
                System.out.println("Coach: " + booking.getCoach().getName());
                System.out.println("Vacancies: " + getVacancies(booking.getLessonDate(), booking.getLessonTime()));
                System.out.println("---------------------------");
                foundBookings = true;
            }
        }

        if (!foundBookings) {
            System.out.println("No bookings found for " + day + ".");
        }
    }

    public void viewTimetableByGrade(int gradeLevel, List<Booking> bookings) {
        System.out.println("Timetable for Grade " + gradeLevel + ":");

        boolean foundBookings = false;
        for (Booking booking : bookings) {
            if (booking.getGradeLevel() == gradeLevel) {
                System.out.println("Lesson ID: " + booking.getlessonId());
                System.out.println("Day: " + booking.getDayOfWeek());
                System.out.println("Time: " + booking.getTime());
                System.out.println("Coach: " + booking.getCoach().getName());
                System.out.println("Vacancies: " + getVacancies(booking.getLessonDate(), booking.getLessonTime()));
                System.out.println("---------------------------");
                foundBookings = true;
            }
        }

        if (!foundBookings) {
            System.out.println("No bookings found for Grade " + gradeLevel + ".");
        }
    }

    public void viewTimetableByCoach(String coachName, List<Booking> bookings) {
        System.out.println("Timetable for Coach " + coachName + ":");

        boolean foundBookings = false;
        for (Booking booking : bookings) {
            if (booking.getCoach().getName().equalsIgnoreCase(coachName)) {
                System.out.println("Lesson ID: " + booking.getlessonId());
                System.out.println("Day: " + booking.getDayOfWeek());
                System.out.println("Time: " + booking.getTime());
                System.out.println("Grade Level: " + booking.getGradeLevel());
                System.out.println("Vacancies: " + getVacancies(booking.getLessonDate(), booking.getLessonTime()));
                System.out.println("---------------------------");
                foundBookings = true;
            }
        }

        if (!foundBookings) {
            System.out.println("No bookings found for Coach " + coachName + ".");
        }
    }

    private int generateLessonId() {
		return id++;
	}

	private Coach findCoachByName(List<Coach> coaches, String name) {
        for (Coach coach : coaches) {
            if (coach.getName().equalsIgnoreCase(name)) {
                return coach;
            }
        }
        return null;
    }

    public void attendLesson() {
        // Implementation for a learner to attend a lesson and provide review/rating
    	Scanner scanner = new Scanner(System.in);
        System.out.println("\nAttend a swimming lesson:");
        System.out.print("Enter learner's name: ");
        String learnerName = scanner.nextLine();
        System.out.print("Enter lesson date (YYYY-MM-DD): ");
        String lessonDate = scanner.nextLine();
        System.out.print("Enter lesson time (HH:MM): ");
        String lessonTime = scanner.nextLine();

        Booking bookingToUpdate = null;
        for (Booking bkng : bookings) {
            if (bkng.getLearner().getName().equalsIgnoreCase(learnerName) &&
                bkng.getLessonDate().equals(lessonDate) &&
                bkng.getLessonTime().equals(lessonTime)) {
                bookingToUpdate = bkng;
                break;
            }
        }

        if (bookingToUpdate != null) {
            System.out.print("Write a review about the lesson: ");
            String review = scanner.nextLine();
            bookingToUpdate.setReview(review);

            System.out.print("Provide a numerical rating for the coach (1 to 5) (1: Very dissatisfied, 2: Dissatisfied, 3: Ok, 4: Satisfied, 5: Very Satisfied): ");
            int rating = scanner.nextInt();
            while (rating < 1 || rating > 5) {
                System.out.println("Rating must be between 1 and 5. Please try again.");
                System.out.print("Provide a numerical rating for the coach (1 to 5): ");
                rating = scanner.nextInt();
            }
            bookingToUpdate.setRating(rating);
            Coach coach = bookingToUpdate.getCoach();
            coach.addRating(rating);
            bookingToUpdate.setStatus("attended");
            
            // Update learner's grade level if necessary
            Learner learner = bookingToUpdate.getLearner();
            int currentGradeLevel = learner.getGradeLevel();
            int bookedGradeLevel = bookingToUpdate.getGradeLevel();
            if (bookedGradeLevel > currentGradeLevel) {
                // Learner attended a higher grade level lesson, update learner's grade level
                learner.setGradeLevel(bookedGradeLevel);
                System.out.println("Learner's grade level updated to: " + bookedGradeLevel);
            }
            
                 
            System.out.println("Swimming lesson attended successfully.");
        } else {
            System.out.println("Booking not found. Unable to attend lesson.");
        }

    }

    public void changeCancelBooking() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("\nChange/Cancel a booking:");
        System.out.print("Enter learner's name: ");
        String learnerName = scanner.nextLine();
        System.out.print("Enter lesson date (YYYY-MM-DD): ");
        String lessonDate = scanner.nextLine();
        System.out.print("Enter lesson time (HH:MM): ");
        String lessonTime = scanner.nextLine();

        Booking bookingToUpdate = null;
        for (Booking booking : bookings) {
            if (booking.getLearner().getName().equalsIgnoreCase(learnerName) &&
                booking.getLessonDate().equals(lessonDate) &&
                booking.getLessonTime().equals(lessonTime)) {
                bookingToUpdate = booking;
                break;
            }
        }

        if (bookingToUpdate != null) {
            System.out.println("Booking found:");
            System.out.println(bookingToUpdate);

            System.out.println("Do you want to change or cancel this booking? (C for Change, X for Cancel)");
            String choice = scanner.nextLine().trim().toUpperCase();
            switch (choice) {
                case "C":
                    // Change booking details
                    System.out.print("Enter new lesson date (YYYY-MM-DD): ");
                    String newLessonDate = scanner.nextLine();
                    System.out.print("Enter new lesson time (HH:MM): ");
                    String newLessonTime = scanner.nextLine();

                    // Update booking details
                    bookingToUpdate.setLessonDate(newLessonDate);
                    bookingToUpdate.setLessonTime(newLessonTime);
                    System.out.println("Booking updated successfully.");
                    break;
                case "X":
                    // Cancel booking
                    bookings.remove(bookingToUpdate);
                    System.out.println("Booking cancelled successfully.");
                    break;
                default:
                    System.out.println("Invalid choice. No changes made.");
            }
        } else {
            System.out.println("Booking not found. Unable to change/cancel booking.");
        }		
	}
    public List<Booking> getCurrentBookings() {
        return bookings;
    }
}
