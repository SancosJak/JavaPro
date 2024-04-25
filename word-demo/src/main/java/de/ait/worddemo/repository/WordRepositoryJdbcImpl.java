package de.ait.worddemo.repository;

import de.ait.worddemo.model.Word;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

@RequiredArgsConstructor
@Repository
public class WordRepositoryJdbcImpl implements WordRepository{
    @Override
    public List<Word> findAll() {
        return null;
    }

    @Override
    public void save(Word model) {

    }
}
