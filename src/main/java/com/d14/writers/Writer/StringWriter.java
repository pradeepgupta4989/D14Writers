package com.d14.writers.Writer;

import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Slf4j
@Getter
@Component
public class StringWriter implements IWriter {
    protected String name = "string_writer";
    static boolean closed =false;

    private static final StringBuilder content = new StringBuilder();

    public void write(String text){
        if (!closed){
            content.append(text);
            log.info("Text written to String writer : {}", content);
        }else{
            log.info("String writer closed, can not write to String");
        }
    }

    @Override
    public String getWriterName(){
        return getName();
    }

    @Override
    public String read(){
        return content.toString();
    }

    @Override
    public void close() {
        closed = true;
    }
}