package com.word_searcher;

import com.word_searcher.chunker.Chunker;
import com.word_searcher.datasource.DataSource;
import com.word_searcher.datasource.FileDataSource;
import com.word_searcher.datasource.URLDataSource;
import com.word_searcher.util.TaskExecutor;

import java.io.IOException;
import java.util.List;


public class Main {

//    private static final String TEXT_URL = "http://norvig.com/big.txt";
    private static final String TEXT_FILE_PATH = "src/resources/big.txt";
    private static final String[] NAMES = {"Timothy", "Vishnu"};

    public static void main(String[] args) {
        try {
//            DataSource dataSource = new URLDataSource(TEXT_URL);
            DataSource dataSource = new FileDataSource(TEXT_FILE_PATH);
            List<String> lines = dataSource.readLines();

            int chunkSize = 1000;
            Chunker chunker = new Chunker(chunkSize);
            List<List<String>> chunks = chunker.chunkLines(lines);

            TaskExecutor taskExecutor = new TaskExecutor();
            taskExecutor.executeTasks(chunks, NAMES);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}