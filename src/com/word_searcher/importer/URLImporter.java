package com.word_searcher.importer;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.LinkedList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class URLImporter extends Importer {
    static Logger logger = Logger.getLogger(URLImporter.class.getName());
    private final String url;

    public URLImporter(String url) {
        this.url = url;
    }

    @Override
    public void importData() throws IOException {
        logger.log(Level.INFO,"Downloading...");
        URL fileUrl = new URL(this.url);
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(fileUrl.openStream()))) {
            List<String> lines = new LinkedList<>();
            String line;
            while ((line = reader.readLine()) != null) {
                lines.add(line);
            }
            super.lines = lines;
            logger.log(Level.INFO,"Downloaded");
        }
    }
}
