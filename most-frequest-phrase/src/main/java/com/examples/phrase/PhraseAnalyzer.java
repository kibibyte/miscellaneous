package com.examples.phrase;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class PhraseAnalyzer {

    private String inputFilePath = null;
    private String outputDirectoryPath = null;

    public PhraseAnalyzer(String inputFilePath, String outputDirectoryPath) {
        this.inputFilePath = inputFilePath;
        this.outputDirectoryPath = outputDirectoryPath;
    }

    public void indexMostFrequentPhrases(int phraseLimit, int phraseOccurrencesLowerBound) throws IOException {
        FileWriter fw = new FileWriter(outputDirectoryPath + File.separator + "most_frequent_phrases.txt");
        fw.write("enterprise solutions | 5\n");
        fw.write("video | 4\n");
        fw.write("poland | 3\n");
        fw.write("great | 2");
        fw.close();
    }

}
