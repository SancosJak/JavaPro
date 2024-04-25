package de.ait.worddemo.controller;

import de.ait.worddemo.model.Word;
import de.ait.worddemo.service.WordService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import io.swagger.v3.oas.annotations.tags.Tags;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.stream.Collectors;

@Tags(value = @Tag(name = "Words"))
@Controller
@RequiredArgsConstructor
public class WordController {

    private final WordService wordService;

//    public WordController(WordService wordService) {
//        this.wordService = wordService;
//    }

    @GetMapping("/")
    public String getForm() {
        return "add_word.html";
    }
    @Operation(summary = "Add new user", description = "available for administrator")
    @PostMapping("/words")
    @ResponseBody
    public String addWord(@RequestParam("word") String word) {
        wordService.addWord(word);
        return "redirect:/words";
    }

    @GetMapping("/words")
    public String getWordsPage(Model model) {
        model.addAttribute("wordsList", wordService.getAllWords());
        return "words_page";
    }
    @Operation(summary = "Get all words", description = "available for administrator")
    @GetMapping("/words/json")
    @ResponseBody
    public List<String> getWordsJson() {
        return wordService.getAllWords().stream()
                .map(Word::getValue)
                .collect(Collectors.toList());
    }
}

