package com.equation.EquationAnalyzer.controller;

import com.equation.EquationAnalyzer.service.EquationAnalyzer;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class EquationController {

    @PostMapping("/analyze")
    public String analyzeEquation(@RequestBody String equation) {
        return EquationAnalyzer.analyzeEquation(equation);
    }
}

