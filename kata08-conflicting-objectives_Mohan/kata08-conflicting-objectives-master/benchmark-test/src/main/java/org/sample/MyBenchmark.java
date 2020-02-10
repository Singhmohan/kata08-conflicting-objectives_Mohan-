

package org.sample;

import org.example.extensible.Options;
import org.example.extensible.TwoSplitOperation;
import org.example.extensible.WordSplit;
import org.example.extensible.WordSplitter;
import org.example.extensible.EnglishDictionary;
import org.example.performance.WordPair;
import org.openjdk.jmh.annotations.Benchmark;

import java.util.List;

public class MyBenchmark {

    private static final EnglishDictionary ENGLISH_DICTIONARY_E = new EnglishDictionary();
    private static final org.example.performance.EnglishDictionary ENGLISH_DICTIONARY_P = new org.example.performance.EnglishDictionary();
    private static final org.example.readable.EnglishDictionary ENGLISH_DICTIONARY_R = new org.example.readable.EnglishDictionary();

    @Benchmark
    public void testExtensible() {
        final Options options = new Options(ENGLISH_DICTIONARY_E, 6, new TwoSplitOperation());
        final WordSplitter wordSplitter = new WordSplitter(options);
        final List<WordSplit> wordSplits = wordSplitter.getSplitWords();
        int counter = 1;

        if (0 < wordSplits.size()) {
            counter = 2;
        }
    }

    @Benchmark
    public void testPerformance() {
        final org.example.performance.WordSplitter wordSplitter = new org.example.performance.WordSplitter(ENGLISH_DICTIONARY_P);
        final List<WordPair> wordSplits = wordSplitter.getSplitWords();
        int counter = 1;

        if (0 < wordSplits.size()) {
            counter = 2;
        }
    }

    @Benchmark
    public void testReadable() {
        final org.example.readable.WordSplitter wordSplitter = new org.example.readable.WordSplitter(ENGLISH_DICTIONARY_R);
        final List<org.example.readable.WordPair> wordSplits = wordSplitter.getSplitWords();
        int counter = 1;

        if (0 < wordSplits.size()) {
            counter = 2;
        }
    }

}
