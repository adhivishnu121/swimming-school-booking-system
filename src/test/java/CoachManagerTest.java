package SwimmingSchool;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.List;

import org.junit.jupiter.api.Test;

class CoachManagerTest {
	private List<Booking> bookings;


	@Test
	void testMonthlyReport() {
        BookingManager bookingManager = new BookingManager();
		this.bookings = bookingManager.getCurrentBookings(); 

        CoachManager coachManager = new CoachManager();
        String input = "04\n";
        InputStream inputStream = new ByteArrayInputStream(input.getBytes());
        System.setIn(inputStream);

        coachManager.monthlyReport(bookings);
	}

}
