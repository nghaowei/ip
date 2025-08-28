package task;
// test

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import exception.GenieweenieException;
import org.junit.jupiter.api.Test;

public class DeadlineTest {

    @Test
    public void toString_validDate_success() throws GenieweenieException {
        Deadline d = new Deadline("submit ip", "2025-08-28");
        assertEquals("[D][ ] submit ip (by: Aug 28 2025)", d.toString());
    }

    @Test
    public void constructor_invalidDate_exceptionThrown() {
        assertThrows(GenieweenieException.class, () -> new Deadline("submit ip", "28-08-2025"));
    }
}
