package com.d14.writers.operations;

import com.d14.writers.Operations.LowerCaseConverter;
import com.d14.writers.Operations.UpperCaseConverter;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;

public class LowerCaseConverterTest {
    @InjectMocks
    LowerCaseConverter lowerCaseConverter;
    @Test
    void testProcessText(){
        lowerCaseConverter = new LowerCaseConverter();
        String result = lowerCaseConverter.processText("This Is Sample TEXT");
        Assertions.assertEquals(result, "this is sample text");
    }
}
