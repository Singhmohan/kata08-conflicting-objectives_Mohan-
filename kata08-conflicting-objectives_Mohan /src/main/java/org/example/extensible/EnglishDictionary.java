package org.example.extensible;

import com.google.common.collect.ImmutableSet;
import org.example.file.DictionaryFile;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class EnglishDictionary implements Dictionary {

    private final Set<String> englishWords;

    public EnglishDictionary() {
        try {
            englishWords = ImmutableSet.copyOf(com.google.common.io.Files.readLines(DictionaryFile.get(), StandardCharsets.UTF_8));
        } catch (IOException e) {
            throw new RuntimeException("Could not read dictionary! Reason: " + e.getMessage(), e);
        }
    }

    public boolean isWordExisting(final String word) {
        return englishWords.contains(word);
    }

    public List<String> getWordsWithLength(final int wordLength) {
        return englishWords.stream().parallel()
                .filter((String word) -> word.length() == wordLength)
                .collect(Collectors.toList());
    }
}
