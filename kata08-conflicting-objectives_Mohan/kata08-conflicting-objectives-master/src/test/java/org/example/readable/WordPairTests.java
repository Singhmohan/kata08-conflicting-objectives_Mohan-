package org.example.readable;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class WordPairTests {

    @Test
    public void testWordPairAbcWithZeroSplit() {
        WordPair wordPair = new WordPair("abc", 0);
        assertThat(wordPair.getFirstPart()).isEqualTo("a");
        assertThat(wordPair.getSecondPart()).isEqualTo("bc");
    }

    @Test
    public void testWordPairAbcWithOneSplit() {
        WordPair wordPair = new WordPair("abc", 1);
        assertThat(wordPair.getFirstPart()).isEqualTo("ab");
        assertThat(wordPair.getSecondPart()).isEqualTo("c");
    }
}
