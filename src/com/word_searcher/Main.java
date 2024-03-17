package com.word_searcher;

import com.word_searcher.importer.FileImporter;
import com.word_searcher.importer.Importer;
import com.word_searcher.importer.URLImporter;
import com.word_searcher.util.TaskExecutor;


public class Main {

    private static final String TEXT_URL = "http://norvig.com/big.txt";
    private static final String TEXT_FILE_PATH = "src/resources/big.txt";
    private static final String[] NAMES = {"Timothy", "computer"};

    public static void main(String[] args) {
        try {
            Importer fileImporter = new FileImporter(TEXT_FILE_PATH);
            fileImporter.importData();

            TaskExecutor FileTaskExecutor = new TaskExecutor();
            FileTaskExecutor.executeTasks(fileImporter, 1000, NAMES);


//            Importer urlImporter = new URLImporter(TEXT_URL);
//            urlImporter.importData();
//
//            TaskExecutor urlTaskExecutor = new TaskExecutor();
//            urlTaskExecutor.executeTasks(urlImporter, 1000, NAMES);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}