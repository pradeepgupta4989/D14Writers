package com.d14.writers.Operations;

import lombok.Getter;
import org.springframework.stereotype.Component;

@Getter
@Component
public class UpperCaseConverter implements ITextOperation {

    protected String name = "upper_case";

    @Override
    public String getOperationName(){return getName();}

    @Override
    public String processText(String inputText)
    {
        return inputText.toUpperCase();
    }
}
