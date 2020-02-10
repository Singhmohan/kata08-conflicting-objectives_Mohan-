package org.example.extensible;

import org.junit.Test;

public class WordSplitterTests {

    private static final EnglishDictionary ENGLISH_DICTIONARY = new EnglishDictionary();

    @Test
    public void testReadableWordSplit() {
        final Options options = new Options(ENGLISH_DICTIONARY, 6, new TwoSplitOperation());
        final WordSplitter wordSplitter = new WordSplitter(options);

        wordSplitter.getSplitWords().stream().forEach(System.out::println);
    }
}
