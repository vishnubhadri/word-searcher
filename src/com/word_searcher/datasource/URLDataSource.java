package com.word_searcher.datasource;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class URLDataSource implements DataSource {
    private final String url;

    public URLDataSource(String url) {
        this.url = url;
    }

    @Override
    public List<String> readLines() throws IOException {
        URL fileUrl = new URL(url);
        BufferedReader reader = new BufferedReader(new InputStreamReader(fileUrl.openStream()));

        List<String> lines = new ArrayList<>();
        String line;
        while ((line = reader.readLine()) != null) {
            lines.add(line);
        }

        return lines;
    }
}
