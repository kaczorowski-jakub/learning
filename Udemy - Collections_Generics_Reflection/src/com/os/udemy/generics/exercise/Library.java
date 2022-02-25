package com.os.udemy.generics.exercise;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Library<T extends Algorithm> {
    private List<T> algorithms;

    public Library() {
        this.algorithms = new ArrayList<>();
    }

    public void add(T algorithm) {
        this.algorithms.add(algorithm);
    }

    public T getLast() {
        if (this.algorithms.size() > 0) {
            final T ret = algorithms.get(algorithms.size() - 1);
            algorithms = algorithms.stream().filter(algorithm -> algorithm != ret).collect(Collectors.toList());
            return ret;
        } else {
            return null;
        }
    }
}
