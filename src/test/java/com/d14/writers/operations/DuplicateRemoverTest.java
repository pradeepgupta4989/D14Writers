package com.d14.writers.operations;

import com.d14.writers.Operations.DuplicateRemover;
import com.d14.writers.Operations.StupidRemover;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;

public class DuplicateRemoverTest {
    @InjectMocks
    DuplicateRemover duplicateRemover;
    @Test
    void testProcessText(){
        duplicateRemover = new DuplicateRemover();
        String result = duplicateRemover.processText("This is really really stupid");
        Assertions.assertEquals(result, "This is really stupid ");
    }
}
