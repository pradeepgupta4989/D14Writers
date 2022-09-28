package com.d14.writers.Writer;

import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;

@Slf4j
@Getter
@Component
public class FileWriter implements IWriter {
    public static final String FILE_NAME = "sample.txt";
    protected String name = "file_writer";
    static boolean closed =false;
    public static java.io.FileWriter fileWriter;

    FileWriter() throws IOException {
        fileWriter = new java.io.FileWriter(FILE_NAME);
    }

    @Override
    public void write(String content) {
        try {
            if (!closed) {
                fileWriter = new java.io.FileWriter(FILE_NAME, true);
                fileWriter.write(content);
                fileWriter.close();
                log.info("Text written to File writer : {}", content);
            }else{
                log.info("File writer closed, can not write to file");
            }
        }catch (IOException ioException){
            log.error("Error while writing text to file :"+ioException.getMessage());
        }
    }

    @Override
    public String read(){
        String content = "";
        try{
            content = new String(Files.readAllBytes(Paths.get(FILE_NAME)));
            log.info("Text read from File :: {}", content);
        }catch (IOException ioException) {
            log.error("Error while reading text from file :"+ioException.getMessage());
        }
        return content;
    }

    @Override
    public void close() {
        closed = true;
    }

    @Override
    public String getWriterName(){
        return getName();
    }
}
