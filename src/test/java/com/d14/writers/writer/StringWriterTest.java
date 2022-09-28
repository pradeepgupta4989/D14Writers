package com.d14.writers.writer;

import com.d14.writers.Writer.StringWriter;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class StringWriterTest {

    @Test
    void testWriteWithClosedFalse(){
        StringWriter stringWriter = new StringWriter();
        stringWriter.write("This is sample text");
        Assertions.assertEquals(stringWriter.read(), "This is sample text");
    }

    @Test
    void testWriteWithClosedTrue(){
        StringWriter stringWriter = new StringWriter();
        stringWriter.close();
        stringWriter.write("New text after close");
        Assertions.assertEquals(stringWriter.read(), "");
    }
}
