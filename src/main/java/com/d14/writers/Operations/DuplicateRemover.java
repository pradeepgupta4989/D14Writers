package com.d14.writers.Operations;

import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.Set;

@Slf4j
@Getter
@Component
public class DuplicateRemover implements ITextOperation {
    protected String name = "duplicate_remover";

    @Override
    public String processText(String inputText)
    {
        final String[] strWords = inputText.split("\\s+");

        final Set<String> setOfWords = new LinkedHashSet<>(Arrays.asList(strWords));

        final StringBuilder builder = new StringBuilder();
        for (String s: setOfWords) {
            builder.append(s).append(" ");
        }
        log.info("String after removing duplicate words: {}", builder);
        return builder.toString();
    }

    @Override
    public String getOperationName(){return getName();}
}
