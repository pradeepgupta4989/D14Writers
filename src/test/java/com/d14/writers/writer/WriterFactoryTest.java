package com.d14.writers.writer;

import com.d14.writers.Writer.FileWriter;
import com.d14.writers.Writer.IWriter;
import com.d14.writers.Writer.StringWriter;
import com.d14.writers.Writer.WriterFactory;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class WriterFactoryTest {
    @InjectMocks
    WriterFactory writerFactory;
    @Test
    void testGetStringWriter(){
        List<IWriter> writers = new ArrayList<>();
        IWriter stringWriter = new StringWriter();
        writers.add(stringWriter);
        writerFactory = new WriterFactory(writers);
        IWriter result = writerFactory.getWriter("string_writer");
        Assertions.assertEquals(result.getWriterName(), "string_writer");
    }

    @Test
    void testGetFileWriter() throws IOException {
        List<IWriter> writers = new ArrayList<>();
        IWriter fileWriter = new FileWriter();
        writers.add(fileWriter);
        writerFactory = new WriterFactory(writers);
        IWriter result = writerFactory.getWriter("file_writer");
        Assertions.assertEquals(result.getWriterName(), "file_writer");
    }
}
