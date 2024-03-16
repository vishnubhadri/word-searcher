package com.word_searcher.matcher;

import java.util.Map;

public interface Matcher {
    Map<String, Integer> processChunk(String chunk);
}
