package edu.junit;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;

import java.util.Collections;
import java.util.List;

public class WagonNumberListCreatorTest {

    // empty list -> ()
    @Test
    public void testEmptyList() {
        final var listCreator = new WagonNumberListCreator(Collections.EMPTY_LIST, 5);
        var batch = listCreator.getNextBatch();
        Assertions.assertEquals("()", batch);
        batch = listCreator.getNextBatch();
        Assertions.assertNull(batch);
    }

    @Test
    public void testNormalBehaviour() {
        final var listCreator = new WagonNumberListCreator(List.of(0,1,2,3,4,5,6,7,8,9), 4);
        Assertions.assertEquals("(0,1,2,3)", listCreator.getNextBatch());
        Assertions.assertEquals("(4,5,6,7)", listCreator.getNextBatch());
        Assertions.assertEquals("(8,9)", listCreator.getNextBatch());
        Assertions.assertNull(listCreator.getNextBatch());
    }

    @Test
    public void testFullListAtOnce() {
        final var listCreator = new WagonNumberListCreator(List.of(0,1,2,3), 4);
        Assertions.assertEquals("(0,1,2,3)", listCreator.getNextBatch());
        Assertions.assertNull(listCreator.getNextBatch());
    }

    @Test
    public void testNegativeCount() {
        Assertions.assertThrows(IllegalArgumentException.class, new Executable() {
            @Override
            public void execute() throws Throwable {
                new WagonNumberListCreator(List.of(0,1,2,3), -4);
            }
        });
    }

}
