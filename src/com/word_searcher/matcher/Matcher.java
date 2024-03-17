package com.word_searcher.matcher;

import com.word_searcher.result.Result;

import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class Matcher implements Runnable {
    private final List<String> lines;
    private final String[] names;
    private final Map<String, List<Result>> results;
    private final long cumulativeLineOffset;

    public Matcher(List<String> lines, String[] names, Map<String, List<Result>> results, long cumulativeLineOffset) {
        this.lines = lines;
        this.names = names;
        this.results = results;
        this.cumulativeLineOffset = cumulativeLineOffset;
    }

    @Override
    public void run() {
        long lineOffset = this.cumulativeLineOffset;
        for (String line : lines) {
            for (String name : names) {
                int index = -1;
                while ((index = line.indexOf(name, index + 1)) != -1) {
                    Result location = new Result(lineOffset, index + 1);
                    results.computeIfAbsent(name, k -> new LinkedList<>()).add(location);
                }
            }
            lineOffset++;
        }
    }
}
