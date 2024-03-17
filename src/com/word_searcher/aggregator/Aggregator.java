package com.word_searcher.aggregator;

import com.word_searcher.result.Result;

import java.util.List;
import java.util.Map;

public class Aggregator {
    private Aggregator() {
    }

    public static void printResults(Map<String, List<Result>> results) {
        results.forEach((name, locations) -> {
            System.out.print(name + " --> ");
            System.out.println(locations);
        });
    }
}
