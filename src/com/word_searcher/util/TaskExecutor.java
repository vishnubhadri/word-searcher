package com.word_searcher.util;

import com.word_searcher.aggregator.Aggregator;
import com.word_searcher.matcher.Matcher;
import com.word_searcher.result.Result;

import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class TaskExecutor {
    private final ExecutorService executor;

    public TaskExecutor() {
        this.executor = Executors.newCachedThreadPool();
    }

    public void executeTasks(List<List<String>> chunks, String[] names) {
        Map<String, List<Result>> results = new ConcurrentHashMap<>();
        long cumulativeLineOffset = 0;
        for (List<String> chunk : chunks) {
            executor.execute(new Matcher(chunk, names, results, cumulativeLineOffset));
            cumulativeLineOffset += chunk.size();
        }
        shutdown();
        Aggregator.printResults(results);
    }

    private void shutdown() {
        executor.shutdown();
        while (!executor.isTerminated()) {
            // Wait for all tasks to finish
        }
    }
}