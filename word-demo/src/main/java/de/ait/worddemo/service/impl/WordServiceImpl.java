package de.ait.worddemo.service.impl;

import de.ait.worddemo.model.Word;
import de.ait.worddemo.repository.WordRepository;
import de.ait.worddemo.service.WordService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WordServiceImpl implements WordService {

    private final WordRepository wordRepository;

//    public WordServiceImpl(@Qualifier("wordRepositoryFileImpl") WordRepository wordRepository) {
//        this.wordRepository = wordRepository;
//    }
public WordServiceImpl(WordRepository wordRepository) {
    this.wordRepository = wordRepository;
}

    @Override
    public Word addWord(String value) {
        Word word = new Word(value);
        wordRepository.save(word);
        return word;
    }

    @Override
    public List<Word> getAllWords() {
        return wordRepository.findAll();
    }
}