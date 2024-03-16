package com.word_searcher.chunker;

import java.util.ArrayList;
import java.util.List;

public class Chunker {
    private int chunkSize = 100;

    public Chunker(int chunkSize) {
        this.chunkSize = chunkSize;
    }

    public List<List<String>> chunkLines(List<String> lines) {
        List<List<String>> chunks = new ArrayList<>();
        int numberOfChunks = (int) Math.ceil((double) lines.size() / this.chunkSize);
        for (int i = 0; i < numberOfChunks; i++) {
            int fromIndex = i * this.chunkSize;
            int toIndex = Math.min(fromIndex + this.chunkSize, lines.size());
            chunks.add(lines.subList(fromIndex, toIndex));
        }
        return chunks;
    }

}
