package org.example.readable;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class WordSplitter {

    private final EnglishDictionary englishDictionary;
    private final int wordLength;

    public WordSplitter(final EnglishDictionary englishDictionary) {
        this.englishDictionary = englishDictionary;
        this.wordLength = 6;
    }

    public List<WordPair> getSplitWords() {
        final List<String> words = englishDictionary.getWordsWithLength(wordLength);
        return words.stream()
                .map(this::getWordPairs)
                .map(this::getExistingWordPair)
                .filter(Optional::isPresent)
                .map(Optional::get)
                .collect(Collectors.toList());
    }

    public List<WordPair> getWordPairs(final String word) {
        final List<WordPair> wordPairs = new ArrayList<>();
        final int maxSplitPosition = word.length() - 1;
        int currentSplitPosition = 0;

        while (currentSplitPosition < maxSplitPosition) {
            wordPairs.add(new WordPair(word, currentSplitPosition));
            currentSplitPosition++;
        }

        return wordPairs;
    }

    public Optional<WordPair> getExistingWordPair(final List<WordPair> wordPairs) {
        return wordPairs.stream().filter(wordPair -> wordPair.exists(englishDictionary)).findFirst();
    }
}
