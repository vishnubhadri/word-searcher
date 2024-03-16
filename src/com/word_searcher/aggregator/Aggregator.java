package com.word_searcher.aggregator;

import java.util.Map;

public interface Aggregator {
    void aggregate(Map<String, Integer> results);

    void printResults();
}
