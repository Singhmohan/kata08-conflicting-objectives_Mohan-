package org.example.extensible;

import java.util.ArrayList;
import java.util.List;

public class TwoSplitOperation implements SplitOperation {

    public TwoSplitOperation() {
    }

    public List<WordSplit> getWordSplits(final String word) {
        final List<WordSplit> wordSplits = new ArrayList<>();
        final int maxSplitPosition = word.length() - 1;
        int currentSplitPosition = 0;

        while (currentSplitPosition < maxSplitPosition) {
            wordSplits.add(new WordSplit(word, getSplits(word, currentSplitPosition)));
            currentSplitPosition++;
        }

        return wordSplits;
    }

    private List<String> getSplits(final String word, final int splitPosition) {
        final List<String> splits = new ArrayList<>();

        splits.add(word.substring(0, splitPosition + 1));
        splits.add(word.substring(splitPosition + 1));

        return splits;
    }
}
