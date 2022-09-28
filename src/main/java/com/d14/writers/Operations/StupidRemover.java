package com.d14.writers.Operations;

import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Slf4j
@Getter
@Component
public class StupidRemover implements ITextOperation {

    protected String name = "stupid_remover";

    @Override
    public String getOperationName(){return getName();}

    @Override
    public String processText(String inputText){
        return inputText.replaceAll("stupid", "s*****");
    }
}
