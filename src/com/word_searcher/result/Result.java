package com.word_searcher.result;

public class Result {
    private final long lineOffset;
    private final long charOffset;

    public Result(long lineOffset, long charOffset) {
        this.lineOffset = lineOffset;
        this.charOffset = charOffset;
    }
    @Override
    public String toString() {
        return "[lineOffset=" + lineOffset + ", charOffset=" + charOffset + "]";
    }
}
