package com.d14.writers.Writer;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Slf4j
@Component
public class WriterFactory {
    private final Map<String, IWriter> writerMap;

    @Autowired
    public WriterFactory(List<IWriter> writers){
        writerMap = writers.stream().collect(Collectors.toMap(IWriter::getWriterName, c->c));
    }

    public IWriter getWriter(String writerName){
        return writerMap.get(writerName);
    }
}
