package com.d14.writers.operations;

import com.d14.writers.Operations.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;

import java.util.ArrayList;
import java.util.List;

public class OperationFactoryTest {
    @InjectMocks
    OperationFactory operationFactory;
    @Test
    void testGetOperationLowerCase(){
        List<ITextOperation> operations = new ArrayList<>();
        ITextOperation lowerCaseConverter = new LowerCaseConverter();
        operations.add(lowerCaseConverter);
        operationFactory = new OperationFactory(operations);
        ITextOperation result = operationFactory.getOperation("lower_case");
        Assertions.assertEquals(result.getOperationName(), "lower_case");
    }

    @Test
    void testGetOperationUpperCase(){
        List<ITextOperation> operations = new ArrayList<>();
        ITextOperation upperCaseConverter = new UpperCaseConverter();
        operations.add(upperCaseConverter);
        operationFactory = new OperationFactory(operations);
        ITextOperation result = operationFactory.getOperation("upper_case");
        Assertions.assertEquals(result.getOperationName(), "upper_case");
    }

    @Test
    void testGetOperationStupidRemover(){
        List<ITextOperation> operations = new ArrayList<>();
        ITextOperation stupidRemover = new StupidRemover();
        operations.add(stupidRemover);
        operationFactory = new OperationFactory(operations);
        ITextOperation result = operationFactory.getOperation("stupid_remover");
        Assertions.assertEquals(result.getOperationName(), "stupid_remover");
    }

    @Test
    void testGetOperationDuplicateRemover(){
        List<ITextOperation> operations = new ArrayList<>();
        ITextOperation duplicateRemover = new DuplicateRemover();
        operations.add(duplicateRemover);
        operationFactory = new OperationFactory(operations);
        ITextOperation result = operationFactory.getOperation("duplicate_remover");
        Assertions.assertEquals(result.getOperationName(), "duplicate_remover");
    }
}
