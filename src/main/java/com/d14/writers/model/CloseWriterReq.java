package com.d14.writers.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
public class CloseWriterReq {
    private List<String> writers;

    @Override
    public String toString(){

        return "Close Operations to be performed on writers : "+ writers.toString();
    }
}
