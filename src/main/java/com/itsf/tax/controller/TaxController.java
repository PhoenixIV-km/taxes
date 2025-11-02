package com.itsf.tax.controller;

import com.itsf.tax.example.TaxExampleGenerator;
import com.itsf.tax.factory.ItemFactory;
import com.itsf.tax.service.TaxService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/tax")
@RequiredArgsConstructor
@Slf4j
public class TaxController {

    private final TaxService taxService;
    @Autowired // enforce validation
    private final ItemFactory itemFactory;

    @GetMapping(value = "/computeExample1", produces = MediaType.TEXT_HTML_VALUE)
    public String computeExample1() {
        log.info("Computing receipt with Example 1");
        return taxService.generateReceipt(TaxExampleGenerator.generateExampleInput1(itemFactory));
    }

    @GetMapping(value = "/computeExample2", produces = MediaType.TEXT_HTML_VALUE)
    public String computeExample2() {
        log.info("Computing receipt with Example 2");
        return taxService.generateReceipt(TaxExampleGenerator.generateExampleInput2(itemFactory));
    }

    @GetMapping(value = "/computeExample3", produces = MediaType.TEXT_HTML_VALUE)
    public String computeExample3() {
        log.info("Computing receipt with Example 3");
        return taxService.generateReceipt(TaxExampleGenerator.generateExampleInput3(itemFactory));
    }
}
