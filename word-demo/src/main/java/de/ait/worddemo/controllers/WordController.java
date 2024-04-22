package de.ait.worddemo.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;



@Controller
public class WordController {

    @GetMapping("/")
    public String getform(){
        return "add_word.html";
    }
    private List<String> words = new ArrayList<>();
    @PostMapping("/words")

    public String addWord(@RequestParam("word") String word){
        words.add(word);
        return "redirect:/words";
    }

    @GetMapping("/words")
    public String getWordsPage(Model model){
        model.addAttribute("wordsList", words);
        return "words_page";
    }
}
