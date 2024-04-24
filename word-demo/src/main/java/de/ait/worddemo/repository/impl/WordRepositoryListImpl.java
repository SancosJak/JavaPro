package de.ait.worddemo.repository.impl;

import de.ait.worddemo.model.Word;
import de.ait.worddemo.repository.WordRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class WordRepositoryListImpl implements WordRepository {

    private final List<Word> words = new ArrayList<>();

    @Override
    public List<Word> findAll() {
        return new ArrayList<>(words);
    }

    @Override
    public void save(Word word) {
        words.add(word);
    }
}