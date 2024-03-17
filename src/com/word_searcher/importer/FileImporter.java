package com.word_searcher.importer;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

public class FileImporter extends Importer {
    private final String filePath;

    public FileImporter(String filePath) {
        this.filePath = filePath;
    }

    @Override
    public void importData() throws IOException {
        List<String> lines = new LinkedList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                lines.add(line);
            }
        }
        super.lines = lines;
    }
}
