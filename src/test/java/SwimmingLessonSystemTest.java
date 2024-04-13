package SwimmingSchool;
import org.junit.jupiter.api.Test;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SwimmingLessonSystemTest {
	 @Test
	    public void testDisplayMenu() {
	        // Redirect standard output to capture printed text
	        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
	        System.setOut(new PrintStream(outputStream));

	        // Create an instance of your SwimmingLessonSystem class
	        SwimmingLessonSystem lessonSystem = new SwimmingLessonSystem();

	        // Call the displayMenu() method
	        lessonSystem.displayMenu();

	        // Expected menu text
	        String expectedMenu = "Welcome to the Swimming Lesson System!\n" +
	                "1. Book a swimming lesson\n" +
	                "2. Change/Cancel a booking\n" +
	                "3. Attend a swimming lesson\n" +
	                "4. Monthly learner report\n" +
	                "5. Monthly coach report\n" +
	                "6. Register a new learner\n" +
	                "7. Exit\n" +
	                "8. TimeTable\n" +
	                "Enter your choice:";

	        // Get the actual printed text
	        String actualMenu = outputStream.toString().trim();

	        // Compare expected and actual menu
	        assertEquals(expectedMenu, actualMenu);
	    }
	}