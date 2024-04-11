package SwimmingSchool;
import java.util.*;
class SwimmingLessonSystem {
    private static Scanner scanner = new Scanner(System.in);
    private LearnerManager learnerManager;
    private CoachManager coachManager;
    private BookingManager bookingManager;
    private List<Learner> learners;
    private List<Coach> coaches;
    private List<Booking> bookings;
    
    public SwimmingLessonSystem() {
        this.learnerManager = new LearnerManager();
        this.coachManager = new CoachManager();
        this.bookingManager = new BookingManager();
        this.learners = new ArrayList<>();
        this.coaches = new ArrayList<>();
        this.bookings = bookingManager.getCurrentBookings(); // Initialize bookings list with current bookings

        
        // Add default learners
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
        coaches.add(new Coach("Coach1"));
        coaches.add(new Coach("Coach2"));
        coaches.add(new Coach("Coach3"));

    }

    public void run() {
        while (true) {
            displayMenu();
            int choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    bookingManager.bookLesson(learners,coaches);
                    break;
                case 2:
                    bookingManager.changeCancelBooking();
                    break;
                case 3:
                   bookingManager.attendLesson();
                    break;
                case 4:
                    learnerManager.monthlyReport(bookings);
                    break;
                case 5:
                    coachManager.monthlyReport(coaches);
                    break;
                case 6:
                    learnerManager.registerLearner(learners);
                    break;
                case 7:
                    exitProgram();
                    break;
                case 8:
                    bookingManager.displayTimetable(bookings);
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private void displayMenu() {
        System.out.println("\nWelcome to the Swimming Lesson System!");
        System.out.println("1. Book a swimming lesson");
        System.out.println("2. Change/Cancel a booking");
        System.out.println("3. Attend a swimming lesson");
        System.out.println("4. Monthly learner report");
        System.out.println("5. Monthly coach report");
        System.out.println("6. Register a new learner");
        System.out.println("7. Exit");
        System.out.println("8. TimeTable");
        System.out.print("Enter your choice: ");
    }

    private void exitProgram() {
        System.out.println("\nThank you!! \nHave A Great Day!!!");
        System.exit(0);
    }
}
