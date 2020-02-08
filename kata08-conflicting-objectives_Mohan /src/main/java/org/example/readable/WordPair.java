package org.example.readable;

public class WordPair {

    private final String originalWord;
    private final String firstPart;
    private final String secondPart;

    public WordPair(final String originalWord, final int splitPosition) {
        this.originalWord = originalWord;
        this.firstPart = originalWord.substring(0, splitPosition + 1);
        this.secondPart = originalWord.substring(splitPosition + 1);
    }

    public String getFirstPart() {
        return firstPart;
    }

    public String getSecondPart() {
        return secondPart;
    }

    public boolean exists(final EnglishDictionary englishDictionary) {
        return englishDictionary.isWordExisting(firstPart) && englishDictionary.isWordExisting(secondPart);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        WordPair wordPair = (WordPair) o;
        return firstPart.equals(wordPair.firstPart) && secondPart.equals(wordPair.secondPart);
    }

    @Override
    public String toString() {
        return "WordPair (" + "originalWord='" + originalWord + '\'' + " split in '" + firstPart + '\'' + " and '" + secondPart + '\'' + ')';
    }

    @Override
    public int hashCode() {
        int result = firstPart.hashCode();
        result = 31 * result + secondPart.hashCode();
        return result;
    }
}
