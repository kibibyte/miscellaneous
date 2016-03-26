package com.examples.phrase.test;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.junit.Assert;
import org.junit.Test;

import com.examples.phrase.PhraseAnalyzer;

public class PhraseAnalyzerTest {

    private PhraseAnalyzer phraseAnalyzer = new PhraseAnalyzer(new File(
            "src/test/resources/results/input/valid_phrases.txt").getAbsolutePath(), new File(
            "src/test/resources/results").getAbsolutePath());

    @Test
    public void shouldFindMostFrequestPhrases() throws IOException {
        phraseAnalyzer.indexMostFrequentPhrases(100, 2);
        Assert.assertTrue(FileUtils.contentEquals(new File(
                "src/test/resources/results/expected_most_frequent_phrases.txt"), new File(
                "src/test/resources/results/most_frequent_phrases.txt")));
    }
}
