package org.example.extensible;

import java.util.List;

public class WordSplit {

    private final String originalWord;
    private final List<String> parts;

    public WordSplit(final String originalWord, final List<String> parts) {
        this.originalWord = originalWord;
        this.parts = parts;
    }

    public boolean exists(final Dictionary dictionary) {
        return parts.stream().allMatch(dictionary::isWordExisting);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        WordSplit wordSplit = (WordSplit) o;

        return originalWord.equals(wordSplit.originalWord) && parts.equals(wordSplit.parts);

    }

    @Override
    public int hashCode() {
        int result = originalWord.hashCode();
        result = 31 * result + parts.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "WordPair (" + "originalWord='" + originalWord + '\'' + " split in '" + parts + '\'';
    }
}
