package org.example.performance;

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
                .map(this::getWordPair)
                .filter(Optional::isPresent)
                .map(Optional::get)
                .collect(Collectors.toList());
    }

    public Optional<WordPair> getWordPair(final String word) {
        final char[] characters = word.toCharArray();
        final StringBuilder firstPart = new StringBuilder();
        final StringBuilder secondPart = new StringBuilder(word);
        Optional<WordPair> wordPair = Optional.empty();
        boolean isExistingWordPair = false;

        for (int i = 0; i < characters.length && !isExistingWordPair; i++) {
            final char currentCharacter = characters[i];
            firstPart.append(currentCharacter);
            secondPart.deleteCharAt(0);

            isExistingWordPair = englishDictionary.isWordExisting(firstPart.toString()) && englishDictionary.isWordExisting(secondPart.toString());
        }

        if (isExistingWordPair) {
            wordPair = Optional.of(new WordPair(word, firstPart.toString(), secondPart.toString()));
        }

        return wordPair;
    }
}
