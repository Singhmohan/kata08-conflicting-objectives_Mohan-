package org.example.extensible;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class WordSplitter {

    private final Options options;

    public WordSplitter(final Options options) {
        this.options = options;
    }

    public List<WordSplit> getSplitWords() {
        final List<String> words = options.getDictionary().getWordsWithLength(options.getWordLength());
        return words.stream()
                .map(options.getSplitOperation()::getWordSplits)
                .map(this::getExistingWordPair)
                .filter(Optional::isPresent)
                .map(Optional::get)
                .collect(Collectors.toList());
    }

    public Optional<WordSplit> getExistingWordPair(final List<WordSplit> wordSplits) {
        return wordSplits.stream().filter(wordPair -> wordPair.exists(options.getDictionary())).findFirst();
    }
}
