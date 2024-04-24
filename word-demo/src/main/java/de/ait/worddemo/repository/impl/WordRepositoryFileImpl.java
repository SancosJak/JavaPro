package de.ait.worddemo.repository.impl;

import de.ait.worddemo.model.Word;
import de.ait.worddemo.repository.WordRepository;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;

import java.io.*;
import java.util.List;
import java.util.stream.Collectors;

@Repository
public class WordRepositoryFileImpl implements WordRepository {

    private final String fileName;

    public WordRepositoryFileImpl(@Value("${words.file-name}") String fileName) {
        this.fileName = fileName;
    }

    @Override
    public List<Word> findAll() {
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            return reader.lines()
                    .map(Word::new)
                    .collect(Collectors.toList());
        } catch (IOException e) {
            throw new IllegalStateException("Problem reading from file: " + e.getMessage());
        }
    }

    @Override
    public void save(Word word) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName, true))) {
            writer.write(word.getValue());
            writer.newLine();
        } catch (IOException e) {
            throw new IllegalStateException("Problem writing to file: " + e.getMessage());
        }
    }
}