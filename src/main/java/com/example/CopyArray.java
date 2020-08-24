package com.example;

import org.openjdk.jmh.annotations.*;

import java.util.concurrent.TimeUnit;
import java.util.stream.IntStream;

@BenchmarkMode(Mode.AverageTime)
@Fork(1)
@State(Scope.Thread)
@Warmup(iterations = 5, time = 1)
@OutputTimeUnit(TimeUnit.NANOSECONDS)
@Measurement(iterations = 10, time = 1)
public class CopyArray {

    private int[] inputArray = IntStream.range(0, 1000).toArray();
    private int[] outputArray = new int[inputArray.length];

    @Benchmark
    public void system() {
        System.arraycopy(inputArray, 0, outputArray, 0, inputArray.length);
    }

    @Benchmark
    public void manual() {
        for (int i=0; i < inputArray.length; i++) {
            outputArray[i] = inputArray[i];
        }
    }
}