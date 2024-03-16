package com.word_searcher.importer;

import java.io.IOException;
import java.util.List;

public interface Importer {
    List<String> importData() throws IOException;
}
