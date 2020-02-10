package org.example.extensible;

import java.util.List;

public interface SplitOperation {

    List<WordSplit> getWordSplits(final String word);
}
