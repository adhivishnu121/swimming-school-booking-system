package SwimmingSchool;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.List;

import org.junit.jupiter.api.Test;

class CoachManagerTest {

	@Test
	void testMonthlyReport() {
        BookingManager bookingManager = new BookingManager();

        CoachManager coachManager = new CoachManager();
        List<Coach> coaches = bookingManager.getSampleCoaches();
        String input = "04\n";
        InputStream inputStream = new ByteArrayInputStream(input.getBytes());
        System.setIn(inputStream);

        coachManager.monthlyReport(coaches);
	}

}
