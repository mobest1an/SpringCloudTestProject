package com.mobest1an.mathmicro.controller;

import com.mobest1an.mathmicro.model.Question;
import com.mobest1an.mathmicro.service.MathService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class MathController {

    private final MathService mathService;

    @GetMapping("/questions")
    public List<Question> getRandomQuestions(@RequestParam int amount) {
        List<Question> questions = new ArrayList<>();

        for (int i = 0; i < amount; i++) {
            questions.add(mathService.getRandom());
        }

        return questions;
    }
}
