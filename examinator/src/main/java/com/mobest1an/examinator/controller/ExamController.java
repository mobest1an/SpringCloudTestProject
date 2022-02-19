package com.mobest1an.examinator.controller;

import com.mobest1an.examinator.model.Exam;
import com.mobest1an.examinator.model.Question;
import com.mobest1an.examinator.model.Section;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@RestController
@RequiredArgsConstructor
public class ExamController {

    private final RestTemplate restTemplate;

    @PostMapping("/exam")
    public Exam getExam(@RequestBody Map<String, Integer> spec) {
        List<Section> sections = spec.entrySet().stream()
                .map(this::getUrl)
                .map(url -> restTemplate.getForObject(url, Question[].class))
                .map(Arrays::asList)
                .map(Section::new)
                .collect(Collectors.toList());

        return Exam.builder()
                .title("EXAM")
                .sections(sections).build();
    }

    private String getUrl(Map.Entry<String, Integer> entry) {
        return "http://" + entry.getKey() + "/api/questions?amount=" + entry.getValue();
    }
}
