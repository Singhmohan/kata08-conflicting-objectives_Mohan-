package org.example.performance;

import org.junit.Test;

public class WordSplitterTests {

    private static final EnglishDictionary ENGLISH_DICTIONARY = new EnglishDictionary();

    @Test
    public void testReadableWordSplit() {
        final WordSplitter wordSplitter = new WordSplitter(ENGLISH_DICTIONARY);

        wordSplitter.getSplitWords().stream().forEach(System.out::println);
    }
}
