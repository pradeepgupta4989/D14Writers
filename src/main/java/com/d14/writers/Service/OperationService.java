package com.d14.writers.Service;

import com.d14.writers.Operations.OperationFactory;
import com.d14.writers.Writer.WriterFactory;
import com.d14.writers.model.WriteTextReq;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@AllArgsConstructor
@Service
public class OperationService {
    private final OperationFactory operationFactory;
    private final WriterFactory writerFactory;

    public String processTextAndWrite(WriteTextReq request){

        String processedText = request.getText();

        for(String op : request.getOperations()) {
            processedText = operationFactory.getOperation(op).processText(processedText);
        }
        for(String wr : request.getWriters()) {
           writerFactory.getWriter(wr).write(processedText);
        }
        log.info("Final processed text after performing operations : {}", processedText);
        return processedText;
    }

    public void closeWrite(List<String> writers){
        for(String wr : writers) {
            writerFactory.getWriter(wr).close();
        }
    }
    public String readFile(String writerName){
        return writerFactory.getWriter(writerName).read();
    }
}
