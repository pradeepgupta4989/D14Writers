package com.d14.writers.writer;

import com.d14.writers.Writer.FileWriter;
import com.d14.writers.Writer.StringWriter;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;

import java.io.IOException;

public class FileWriterTest {
    @InjectMocks
    FileWriter fileWriter;

    @BeforeEach
    public void setup() throws IOException {
        fileWriter = new FileWriter();
    }

    @Test
    void testWriteWithClosedFalse(){
        fileWriter.write("This is sample text");
        Assertions.assertEquals(fileWriter.read(), "This is sample text");
    }

    @Test
    void testWriteWithClosedTrue(){
        fileWriter.close();
        fileWriter.write("This is sample text");
        Assertions.assertEquals(fileWriter.read(), "");
    }
}
