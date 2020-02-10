package org.example.extensible;

public class Options {

    private final Dictionary dictionary;
    private final int wordLength;
    private final SplitOperation splitOperation;

    public Options(final Dictionary dictionary, final int wordLength, final SplitOperation splitOperation) {
        this.dictionary = dictionary;
        this.wordLength = wordLength;
        this.splitOperation = splitOperation;
    }

    public Dictionary getDictionary() {
        return dictionary;
    }

    public int getWordLength() {
        return wordLength;
    }

    public SplitOperation getSplitOperation() {
        return splitOperation;
    }
}
