package com.word_searcher.importer;


import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

public abstract class Importer {
    protected List<String> lines;

    public abstract void importData() throws UnsupportedOperationException, IOException;

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

