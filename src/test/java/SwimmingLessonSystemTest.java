package SwimmingSchool;
import org.junit.jupiter.api.Test;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SwimmingLessonSystemTest {
	 @Test
	    public void testDisplayMenu() {

	        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
	        System.setOut(new PrintStream(outputStream));

	        SwimmingLessonSystem lessonSystem = new SwimmingLessonSystem();

	        lessonSystem.displayMenu();

	        String expectedMenu ="-------------------------------------------------------------------------\n"+"Welcome to the Swimming Lesson System!\n" +
	                "1. Book a swimming lesson\n" +
	                "2. Change/Cancel a booking\n" +
	                "3. Attend a swimming lesson\n" +
	                "4. Monthly learner report\n" +
	                "5. Monthly coach report\n" +
	                "6. Register a new learner\n" +
	                "7. Exit\n" +
	                "8. TimeTable\n" +
	                "Enter your choice:";

	        String actualMenu = outputStream.toString().trim();

	        assertEquals(expectedMenu, actualMenu);
	    }
	}