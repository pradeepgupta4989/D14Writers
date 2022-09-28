package com.d14.writers.Operations;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Slf4j
@Component
public class OperationFactory {
    private final Map<String, ITextOperation> operationsMap;

    @Autowired
    public OperationFactory(List<ITextOperation> operations){
        operationsMap = operations.stream().collect(Collectors.toMap(ITextOperation::getOperationName, c->c));
    }

    public ITextOperation getOperation(String operationName){
        return operationsMap.get(operationName);
    }
}
