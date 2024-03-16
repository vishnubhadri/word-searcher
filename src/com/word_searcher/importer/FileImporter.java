package com.word_searcher.importer;

import com.word_searcher.datasource.DataSource;
import com.word_searcher.datasource.FileDataSource;

import java.io.IOException;
import java.util.List;

public class FileImporter implements Importer {
    private final String url;

    public FileImporter(String url) {
        this.url = url;
    }

    @Override
    public List<String> importData() throws IOException {
        DataSource dataSource = new FileDataSource(url);
        return dataSource.readLines();
    }
}
