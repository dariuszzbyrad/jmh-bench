package com.example;

import org.openjdk.jmh.annotations.Level;
import org.openjdk.jmh.annotations.Scope;
import org.openjdk.jmh.annotations.Setup;
import org.openjdk.jmh.annotations.State;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@State(Scope.Benchmark)
public class AddToListExecutionPlan {

    private List<Integer> inputList;

    @Setup(Level.Invocation)
    public void setUp() {
        inputList = IntStream.range(0, 100_000)
                .boxed()
                .collect(Collectors.toList());
    }

    public List<Integer> getInputList() {
        return inputList;
    }
}
