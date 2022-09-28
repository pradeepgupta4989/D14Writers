package com.d14.writers.service;

import com.d14.writers.Operations.*;
import com.d14.writers.Service.OperationService;
import com.d14.writers.Writer.FileWriter;
import com.d14.writers.Writer.IWriter;
import com.d14.writers.Writer.StringWriter;
import com.d14.writers.Writer.WriterFactory;
import com.d14.writers.model.WriteTextReq;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class OperationServiceTest {
    @InjectMocks
    OperationService operationService;
    @Mock
    OperationFactory operationFactory;
    @Mock
    WriterFactory writerFactory;
    @BeforeEach
    public void setup(){
        operationFactory = mock(OperationFactory.class);
        writerFactory = mock(WriterFactory.class);
    }
    @Test
    void testProcessTextAndWriteLowerCaseAndStupidRemover(){
        operationService = new OperationService(operationFactory, writerFactory);
        ITextOperation lowerCaseConverter = new LowerCaseConverter();
        ITextOperation stupidRemover = new StupidRemover();
        IWriter stringWriter = new StringWriter();
        when(operationFactory.getOperation("lower_case")).thenReturn(lowerCaseConverter);
        when(operationFactory.getOperation("stupid_remover")).thenReturn(stupidRemover);
        when(writerFactory.getWriter("string_writer")).thenReturn(stringWriter);

        List<String> operationList = new ArrayList<>(Arrays.asList("lower_case", "stupid_remover"));
        List<String> writerList = new ArrayList<>(Collections.singletonList("string_writer"));
        String result = operationService.processTextAndWrite(WriteTextReq.builder().text("Sample Text Stupid")
                .operations(operationList).writers(writerList).build());
        Assertions.assertEquals(result, "sample text s*****");
    }

    @Test
    void testProcessTextAndWriteUpperCaseAndDuplicateRemover(){
        operationService = new OperationService(operationFactory, writerFactory);
        ITextOperation upperCaseConverter = new UpperCaseConverter();
        ITextOperation duplicateRemover = new DuplicateRemover();
        IWriter stringWriter = new StringWriter();
        when(operationFactory.getOperation("upper_case")).thenReturn(upperCaseConverter);
        when(operationFactory.getOperation("duplicate_remover")).thenReturn(duplicateRemover);
        when(writerFactory.getWriter("file_writer")).thenReturn(stringWriter);

        List<String> operationList = new ArrayList<>(Arrays.asList("upper_case", "duplicate_remover"));
        List<String> writerList = new ArrayList<>(Collections.singletonList("file_writer"));
        String result = operationService.processTextAndWrite(WriteTextReq.builder().text("This is really really stupid")
                .operations(operationList).writers(writerList).build());
        Assertions.assertEquals(result, "THIS IS REALLY STUPID ");
    }

    @Test
    void testProcessTextReadDuplicateRemoverTest() throws IOException {
        operationService = new OperationService(operationFactory, writerFactory);
        ITextOperation duplicateRemover = new DuplicateRemover();
        IWriter fileWriter = new FileWriter();
        when(operationFactory.getOperation("duplicate_remover")).thenReturn(duplicateRemover);
        when(writerFactory.getWriter("file_writer")).thenReturn(fileWriter);

        List<String> operationList = new ArrayList<>(Collections.singletonList("duplicate_remover"));
        List<String> writerList = new ArrayList<>(Collections.singletonList("file_writer"));
        String result = operationService.processTextAndWrite(WriteTextReq.builder().text("This is really really stupid")
                .operations(operationList).writers(writerList).build());
        String readResult = operationService.readFile("file_writer");
        Assertions.assertEquals(result, readResult);
    }

    @Test
    void testProcessTextReadUpperCaseTest() throws IOException {
        operationService = new OperationService(operationFactory, writerFactory);
        ITextOperation upperCaseConverter = new UpperCaseConverter();
        IWriter fileWriter = new FileWriter();
        when(operationFactory.getOperation("upper_case")).thenReturn(upperCaseConverter);
        when(writerFactory.getWriter("file_writer")).thenReturn(fileWriter);

        List<String> operationList = new ArrayList<>(Collections.singletonList("upper_case"));
        List<String> writerList = new ArrayList<>(Collections.singletonList("file_writer"));
        String result = operationService.processTextAndWrite(WriteTextReq.builder().text("This Is Sample Text")
                .operations(operationList).writers(writerList).build());
        String readResult = operationService.readFile("file_writer");
        Assertions.assertEquals(result, readResult);
    }
}
