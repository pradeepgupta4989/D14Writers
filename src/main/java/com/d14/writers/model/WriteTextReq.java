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
public class WriteTextReq {
    private String text;
    private List<String> operations;
    private List<String> writers;

    @Override
    public String toString(){

        return "Input text : "+this.text + "===>>> Operations to be performed: "+ operations.toString();
    }
}
