package com.d14.writers.operations;

import com.d14.writers.Operations.UpperCaseConverter;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;

public class UpperCaseConverterTest {
    @InjectMocks
    UpperCaseConverter upperCaseConverter;
    @Test
    void testProcessText(){
        upperCaseConverter = new UpperCaseConverter();
        String result = upperCaseConverter.processText("This Is Sample TEXT");
        Assertions.assertEquals(result, "THIS IS SAMPLE TEXT");
    }
}
