package de.ait.worddemo.service;

import de.ait.worddemo.model.Word;
import java.util.List;

public interface WordService {

    Word addWord(String value);

    List<Word> getAllWords();
}