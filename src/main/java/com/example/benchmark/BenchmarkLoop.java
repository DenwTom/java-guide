package com.example.benchmark;


import org.openjdk.jmh.annotations.*;
import org.openjdk.jmh.infra.Blackhole;
import org.openjdk.jmh.runner.Runner;
import org.openjdk.jmh.runner.RunnerException;
import org.openjdk.jmh.runner.options.Options;
import org.openjdk.jmh.runner.options.OptionsBuilder;

import java.util.*;
import java.util.concurrent.TimeUnit;

@BenchmarkMode(Mode.AverageTime)
@OutputTimeUnit(TimeUnit.NANOSECONDS)
@State(Scope.Benchmark)
@Fork(value = 1, jvmArgs = {"-Xms1G", "-Xmx1G"})
@Warmup(iterations = 3)
public class BenchmarkLoop {
    @Param({"10"})
    private int N;
    private String findText = "value : " + String.valueOf(N - N / 4);
    private List<String> linkedList;
    private List<String> arrayList;
    private Set<String> hashSet;
    private Set<String> treeSet;
    private Vector<String> vector;
    private HashMap<Integer, String> hashMap;


    public static void main(String[] args) throws RunnerException {

        Options opt = new OptionsBuilder()
                .include(BenchmarkLoop.class.getSimpleName())
                .forks(1)
                .build();

        new Runner(opt).run();
    }

    @Setup
    public void setup() {
        createData();
    }


//ArrayList
    @Benchmark
    public void getMethodArrayList(Blackhole bh) {
        bh.consume(arrayList.get(N/2));
    }

    public void addMethodArrayList(Blackhole bh) {
        bh.consume(arrayList.get(N/2));

    }

    @Benchmark
    public void loopForEachArrayList(Blackhole bh) {
        for (String s : arrayList) {
            bh.consume(s);
        }
    }

    @Benchmark
    public void containMethodArrayList(Blackhole bh) {
        bh.consume(arrayList.contains(findText));
    }

    @Benchmark
    public void removeMethodArrayList(Blackhole bh) {
        arrayList.remove(N / 2);
    }



//LinkedList
    @Benchmark
    public void getMethodLinkedList(Blackhole bh) {
        bh.consume(linkedList.get(N/2));
    }

    @Benchmark
    public void addMethodLinkedList(Blackhole bh) {
        bh.consume(linkedList.get(N/2));

    }

    @Benchmark
    public void loopForEachLinkedList(Blackhole bh) {
        for (String s : arrayList) {
            bh.consume(s);
        }
    }

    @Benchmark
    public void containMethodLinkedList(Blackhole bh) {
        bh.consume(arrayList.contains(findText));
    }

    @Benchmark
    public void removeMethodLinkedList(Blackhole bh) {
        arrayList.remove(N / 2);
    }




//HashSet
    @Benchmark
    public void getMethodHashSet(Blackhole bh) {
        //bh.consume(hashSet.get(N/2));
    }

    @Benchmark
    public void addMethodHashSet(Blackhole bh) {
        //bh.consume(hashSet.get(N/2));

    }

    @Benchmark
    public void loopForEachHashSet(Blackhole bh) {
        for (String s : hashSet) {
            bh.consume(s);
        }
    }

    @Benchmark
    public void containMethodHashSet(Blackhole bh) {
        bh.consume(hashSet.contains(findText));
    }

    @Benchmark
    public void removeMethodHashSet(Blackhole bh) {
        hashSet.remove("value : 0");
    }






    private void createData() {
        arrayList = new ArrayList<>();
        linkedList = new LinkedList<>();
        hashSet = new HashSet<>();
        treeSet = new TreeSet<>();
        vector = new Vector<>();
        hashMap = new HashMap<>();
        for (int i = 0; i < N; i++) {
            arrayList.add("value : " + i);
            linkedList.add("value : " + i);
            hashSet.add("value : " + i);
            treeSet.add("value : " + i);
            vector.add("value : " + i);
            hashMap.put(i, "value : " + i);
        }
    }
}
