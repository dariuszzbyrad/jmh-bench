package com.example;

import org.openjdk.jmh.annotations.*;
import org.openjdk.jmh.infra.Blackhole;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.TimeUnit;

@BenchmarkMode(Mode.AverageTime)
@Fork(1)
@State(Scope.Thread)
@Warmup(iterations = 10, time = 1)
@OutputTimeUnit(TimeUnit.NANOSECONDS)
@Measurement(iterations = 20, time = 1)
public class AddToList {

    @Benchmark
    public void addAllToLinkedList(AddToListExecutionPlan addToCollectionExecutionPlan, Blackhole blackhole) {
        List<Integer> output = new LinkedList<>();
        output.addAll(addToCollectionExecutionPlan.getInputList());
        blackhole.consume(output);
    }

    @Benchmark
    public void addManuallyToLinkedList(AddToListExecutionPlan addToCollectionExecutionPlan, Blackhole blackhole) {
        List<Integer> output = new LinkedList<>();

        for (int i = 0; i < addToCollectionExecutionPlan.getInputList().size(); i++) {
            output.add(addToCollectionExecutionPlan.getInputList().get(i));
        }

        blackhole.consume(output);
    }

    @Benchmark
    public void addAllToArrayList(AddToListExecutionPlan addToCollectionExecutionPlan, Blackhole blackhole) {
        List<Integer> output = new ArrayList<>();
        output.addAll(addToCollectionExecutionPlan.getInputList());
        blackhole.consume(output);
    }

    @Benchmark
    public void addManuallyToArrayList(AddToListExecutionPlan addToCollectionExecutionPlan, Blackhole blackhole) {
        List<Integer> output = new ArrayList<>();

        for (int i = 0; i < addToCollectionExecutionPlan.getInputList().size(); i++) {
            output.add(addToCollectionExecutionPlan.getInputList().get(i));
        }

        blackhole.consume(output);
    }
}

