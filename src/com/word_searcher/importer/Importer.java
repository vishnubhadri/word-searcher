package com.word_searcher.importer;


import java.util.LinkedList;
import java.util.List;

public class Importer {
    protected List<String> lines;

    public void importData() throws Exception {
        throw new Exception("Method not implemented");
    }

    public List<List<String>> process(int chunkSize) {
        List<List<String>> chunks = new LinkedList<>();
        int numberOfChunks = (int) Math.ceil((double) lines.size() / chunkSize);
        for (int i = 0; i < numberOfChunks; i++) {
            int fromIndex = i * chunkSize;
            int toIndex = Math.min(fromIndex + chunkSize, lines.size());
            chunks.add(lines.subList(fromIndex, toIndex));
        }
        return chunks;
    }
}

