package SwimmingSchool;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;
import org.junit.jupiter.api.Test;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

class LearnerManagerTest {

    @Test
    public void testRegisterLearner() {
        LearnerManager learnerManager = new LearnerManager();
        List<Learner> learners = new ArrayList<>();

        String input = "John\nMale\n10\n123456789\n3\n";
        InputStream inputStream = new ByteArrayInputStream(input.getBytes());
        System.setIn(inputStream);

        learnerManager.registerLearner(learners);

        assertEquals(1, learners.size());
        Learner learner = learners.get(0);
        assertEquals("John", learner.getName());
        assertEquals("Male", learner.getGender());
        assertEquals(10, learner.getAge());
        assertEquals("123456789", learner.getEmergencyContact());
        assertEquals(3, learner.getGradeLevel());
    }
}
