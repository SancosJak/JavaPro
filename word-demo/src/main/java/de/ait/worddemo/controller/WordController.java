package de.ait.worddemo.controller;

import de.ait.worddemo.model.Word;
import de.ait.worddemo.service.WordService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.stream.Collectors;

@Controller
public class WordController {

    private final WordService wordService;

    public WordController(WordService wordService) {
        this.wordService = wordService;
    }

    @GetMapping("/")
    public String getForm() {
        return "add_word.html";
    }

    @PostMapping("/words")
    public String addWord(@RequestParam("word") String word) {
        wordService.addWord(word);
        return "redirect:/words";
    }

    @GetMapping("/words")
    public String getWordsPage(Model model) {
        model.addAttribute("wordsList", wordService.getAllWords());
        return "words_page";
    }
    @GetMapping("/words/json")
    @ResponseBody
    public List<String> getWordsJson() {
        return wordService.getAllWords().stream()
                .map(Word::getValue)
                .collect(Collectors.toList());
    }
}

