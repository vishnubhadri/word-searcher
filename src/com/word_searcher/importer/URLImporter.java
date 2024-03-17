package com.word_searcher.importer;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.LinkedList;
import java.util.List;

public class URLImporter extends Importer {
    private final String url;

    public URLImporter(String url) {
        this.url = url;
    }

    @Override
    public void importData() throws IOException {
        System.out.println("Downloading...");
        URL fileUrl = new URL(this.url);
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(fileUrl.openStream()))) {
            List<String> lines = new LinkedList<>();
            String line;
            while ((line = reader.readLine()) != null) {
                lines.add(line);
            }
            super.lines = lines;
            System.out.println("Downloaded");
        }
    }
}
