package org.example.extensible;


import java.util.List;

public interface Dictionary {

    boolean isWordExisting(final String word);

    List<String> getWordsWithLength(final int wordLength);
}
