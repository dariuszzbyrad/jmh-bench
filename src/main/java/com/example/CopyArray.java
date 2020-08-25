package com.example;

import org.openjdk.jmh.annotations.*;
import org.openjdk.jmh.infra.Blackhole;

import java.util.concurrent.TimeUnit;
import java.util.stream.IntStream;

@BenchmarkMode(Mode.AverageTime)
@Fork(1)
@State(Scope.Thread)
@Warmup(iterations = 10, time = 1)
@OutputTimeUnit(TimeUnit.NANOSECONDS)
@Measurement(iterations = 20, time = 1)
public class CopyArray {

    private int[] inputArray = IntStream.range(0, 1000).toArray();

    @Benchmark
    public void bySystem(Blackhole blackhole) {
        int[] outputArray = new int[inputArray.length];

        System.arraycopy(inputArray, 0, outputArray, 0, inputArray.length);

        blackhole.consume(outputArray);
    }

    @Benchmark
    public void oneByOne(Blackhole blackhole) {
        int[] outputArray = new int[inputArray.length];

        for (int i = 0; i < inputArray.length; i++) {
            outputArray[i] = inputArray[i];
        }

        blackhole.consume(outputArray);
    }
}