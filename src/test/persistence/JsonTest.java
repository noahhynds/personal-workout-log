package persistence;

import model.*;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;
import java.util.*;

public class JsonTest {

    // EFFECTS: compares title
    protected void checkTitle(String t, Workout w) {
        assertEquals(t, w.getTitle());

    }

    // EFFECTS: compares date
    protected void checkDate(LocalDate l, Workout w) {
        assertEquals(l, w.getDate());

    }

    // EFFECTS: compares id
    protected void checkId(String id, Workout w) {
        assertEquals(id, w.getId());

    }

    // EFFECTS: compares status
    protected void checkStatus(Boolean s, Workout w) {
        assertEquals(s, w.getStatusOfWorkout());

    }

    // EFFECTS: compares exercises
    protected void checkExercises(List<String> e, Workout w) {
        assertEquals(e, w.getAllExercises());

    }

    // EFFECTS: compares comments
    protected void checkComments(List<String> c, Workout w) {
        assertEquals(c, w.getComments());

    }

}
