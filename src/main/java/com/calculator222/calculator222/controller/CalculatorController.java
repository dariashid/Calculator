package com.calculator222.calculator222.controller;

import com.calculator222.calculator222.service.CalculatorService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/calculator")

public class CalculatorController {
    private final CalculatorService calculatorService;

    public CalculatorController(CalculatorService calculatorService) {
        this.calculatorService = calculatorService;
    }


    @GetMapping("/plus")
    public String sumNumbers(@RequestParam int num1, @RequestParam int num2) {
        return String.valueOf(calculatorService.sum(num1, num2));
    }

    @GetMapping("/minus")
    public String subtractNumbers(@RequestParam int num1, @RequestParam int num2) {
        return String.valueOf(calculatorService.subtract(num1, num2));
    }

    @GetMapping("/multiply")
    public String multiplyNumbers(@RequestParam int num1, @RequestParam int num2) {
        return String.valueOf(calculatorService.multiply(num1, num2));
    }

    @GetMapping("/divide")
    public String divideNumbers(@RequestParam int num1, @RequestParam int num2) {
        if (num2 == 0) {
            return "На ноль делить нельзя";
        }
        return String.valueOf(calculatorService.divide(num1, num2));
    }

}
