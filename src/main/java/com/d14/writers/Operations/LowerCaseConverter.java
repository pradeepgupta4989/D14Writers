package com.d14.writers.Operations;

import lombok.Getter;
import org.springframework.stereotype.Component;

@Getter
@Component
public class LowerCaseConverter implements ITextOperation {

    protected String name = "lower_case";

    @Override
    public String processText(String inputText)
    {
        return inputText.toLowerCase();
    }

    @Override
    public String getOperationName(){return getName();}
}
