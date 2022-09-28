package com.d14.writers.Writer;

public interface IWriter {

    void write(String text);

    void close();

    String read();

    String getWriterName();
}

