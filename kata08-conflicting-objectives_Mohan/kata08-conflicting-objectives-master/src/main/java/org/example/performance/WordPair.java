package org.example.performance;

public class WordPair {

    private final String originalWord;
    private final String firstPart;
    private final String secondPart;

    public WordPair(String originalWord, String firstPart, String secondPart) {
        this.originalWord = originalWord;
        this.firstPart = firstPart;
        this.secondPart = secondPart;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        WordPair wordPair = (WordPair) o;

        return originalWord.equals(wordPair.originalWord) && firstPart.equals(wordPair.firstPart) && secondPart.equals(wordPair.secondPart);

    }

    @Override
    public int hashCode() {
        int result = originalWord.hashCode();
        result = 31 * result + firstPart.hashCode();
        result = 31 * result + secondPart.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "WordPair{" + "originalWord='" + originalWord + '\'' + ", firstPart='" + firstPart + '\'' + ", secondPart='" + secondPart + '\'' + '}';
    }
}
