package SwimmingSchool;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import org.junit.jupiter.api.Test;
import java.time.DayOfWeek;

class BookingTest {

    @Test
    public void testGetDayOfWeek() {
        // Creating a booking for Monday
        Booking bookingMonday = new Booking(null, "2024-04-08", "10:00", null, 0, 0);
        assertEquals(DayOfWeek.MONDAY, bookingMonday.getDayOfWeek());

        // Creating a booking for Wednesday
        Booking bookingWednesday = new Booking(null, "2024-04-10", "12:00", null, 0, 0);
        assertEquals(DayOfWeek.WEDNESDAY, bookingWednesday.getDayOfWeek());

        // Creating a booking for Friday
        Booking bookingFriday = new Booking(null, "2024-04-12", "14:00", null, 0, 0);
        assertEquals(DayOfWeek.FRIDAY, bookingFriday.getDayOfWeek());

        // Creating a booking for Saturday between 2 PM and 4 PM
        Booking bookingSaturday = new Booking(null, "2024-04-13", "15:00", null, 0, 0);
        assertEquals(DayOfWeek.SATURDAY, bookingSaturday.getDayOfWeek());

        // Creating a booking for Saturday before 2 PM
        Booking bookingSaturdayBefore = new Booking(null, "2024-04-13", "13:00", null, 0, 0);
        assertNull(bookingSaturdayBefore.getDayOfWeek());

        // Creating a booking for Saturday after 4 PM
        Booking bookingSaturdayAfter = new Booking(null, "2024-04-13", "16:30", null, 0, 0);
        assertNull(bookingSaturdayAfter.getDayOfWeek());
    }
}
