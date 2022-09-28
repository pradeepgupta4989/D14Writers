package com.d14.writers.controller;

import com.d14.writers.Service.OperationService;
import com.d14.writers.model.CloseWriterReq;
import com.d14.writers.model.WriteTextReq;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyList;
import static org.mockito.Mockito.*;

public class RestApiControllerTest {
    @InjectMocks
    RestApiController restApiController;
    @InjectMocks
    OperationService operationService;

    @BeforeEach
    public void setup(){
        operationService = mock(OperationService.class);
        restApiController = new RestApiController(operationService);
    }

    @Test
    void testWriteTextToFileWithValidTextAndValidOperation(){
        when(operationService.processTextAndWrite(any())).thenReturn("sample s*****");
        List<String> operationList = new ArrayList<>(Arrays.asList("lower_case", "stupid_remover"));
        List<String> writerList = new ArrayList<>(Arrays.asList("file_writer", "string_writer"));
        String result = restApiController.writeText(WriteTextReq.builder().text("Sample Stupid")
                .operations(operationList).writers(writerList).build());
        Assertions.assertEquals(result, "sample s*****");
    }

    @Test
    void testWriteTextToFileWithValidTextAndInValidOperation(){
        List<String> operationList = new ArrayList<>();
        List<String> writerList = new ArrayList<>(Arrays.asList("file_writer", "string_writer"));
        String result = restApiController.writeText(WriteTextReq.builder().text("Sample Stupid")
                .operations(operationList).writers(writerList).build());
        Assertions.assertEquals(result, "Please provide input text or list of operations");
    }

    @Test
    void testWriteTextToFileWithEmptyTextAndInValidOperation(){
        List<String> operationList = new ArrayList<>();
        List<String> writerList = new ArrayList<>();
        String result = restApiController.writeText(WriteTextReq.builder().text("Sample Stupid")
                .operations(operationList).writers(writerList).build());
        Assertions.assertEquals(result, "Please provide input text or list of operations");
    }

    @Test
    void testCloseWriteWithValidWriters(){
        doNothing().when(operationService).closeWrite(anyList());
        List<String> writerList =new ArrayList<>(Arrays.asList("file_writer", "string_writer"));
        String result = restApiController.closeWrite(CloseWriterReq.builder().writers(writerList).build());
        Assertions.assertEquals(result, "Writer Closed successfully");
    }
    @Test
    void testCloseWriteWithNoWriters(){
        doNothing().when(operationService).closeWrite(anyList());
        List<String> writerList =new ArrayList<>();
        String result = restApiController.closeWrite(CloseWriterReq.builder().writers(writerList).build());
        Assertions.assertEquals(result, "Please provide writer name in request");
    }

    @Test
    void testReadContent(){
        when(operationService.readFile(anyString())).thenReturn("sample s*****");
        String result = restApiController.readContent("string_writer");
        Assertions.assertEquals(result, "sample s*****");
    }
}
