package com.word_searcher.datasource;

import java.io.IOException;
import java.util.List;

public interface DataSource {
    List<String> readLines() throws IOException;
}
