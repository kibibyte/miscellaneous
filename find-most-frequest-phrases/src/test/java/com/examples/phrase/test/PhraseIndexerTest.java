package com.examples.phrase.test;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import com.examples.phrase.PhraseFrequency;
import com.examples.phrase.PhraseIndexerDbImpl;

public class PhraseIndexerTest {

    private PhraseIndexerDbImpl phraseIndexer = new PhraseIndexerDbImpl(
            new File("src/test/resources/input/phrases.txt").getAbsolutePath(), new File(
                    "src/test/resources/output/index").getAbsolutePath());

    @Test
    public void shouldFindMostFrequestPhrases() {
        List<PhraseFrequency> expectedMostFrequentPhrases = new ArrayList<PhraseFrequency>();
        expectedMostFrequentPhrases.add(new PhraseFrequency("enterprise solutions", 5));
        expectedMostFrequentPhrases.add(new PhraseFrequency("video", 4));
        expectedMostFrequentPhrases.add(new PhraseFrequency("poland", 3));
        expectedMostFrequentPhrases.add(new PhraseFrequency("great", 2));

        phraseIndexer.init();
        phraseIndexer.indexMostFrequentPhrases();
        List<PhraseFrequency> mostFrequentPhrases = phraseIndexer.getMostFrequentPhrases(100, 0, 1);
        phraseIndexer.close();

        Assert.assertEquals(expectedMostFrequentPhrases, mostFrequentPhrases);
    }
}
