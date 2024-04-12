package SwimmingSchool;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import org.junit.jupiter.api.Test;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

class BookingManagerTest {

    @Test
    public void testCreateBooking() {
        BookingManager bookingManager = new BookingManager();
        List<Learner> learners = bookingManager.getSampleLearners();
        List<Coach> coaches = bookingManager.getSampleCoaches();

        // Prepare input for test
        String input = "lrn1\n1011\n2024-05-01\n16:00\nCoach1\n3\n";
        InputStream inputStream = new ByteArrayInputStream(input.getBytes());
        System.setIn(inputStream);

        // Execute the method
        bookingManager.createBooking(learners, coaches);

        // Validate if the booking is created
        List<Booking> bookings = bookingManager.getCurrentBookings();
        assertNotNull(bookings);
        Booking booking = bookings.get(bookings.size()-1);
        assertEquals("lrn1", booking.getLearner().getName());
        assertEquals("2024-05-01", booking.getLessonDate());
        assertEquals("16:00", booking.getLessonTime());
        assertEquals("Coach1", booking.getCoach().getName());
        assertEquals(3, booking.getGradeLevel());
    }
}
