package com.d14.writers.operations;

import com.d14.writers.Operations.StupidRemover;
import com.d14.writers.Operations.UpperCaseConverter;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;

public class StupidRemoverTest {
    @InjectMocks
    StupidRemover stupidRemover;
    @Test
    void testProcessText(){
        stupidRemover = new StupidRemover();
        String result = stupidRemover.processText("This is really really stupid");
        Assertions.assertEquals(result, "This is really really s*****");
    }
}
