package com.itsf.tax.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

@SpringBootTest
@AutoConfigureMockMvc
public class TaxControllerTest {

    @Autowired
    private MockMvc mvc;

    @Test
    void computeInput1Test() throws Exception {
        mvc.perform(get("/tax/computeExample1"))
                .andExpect(status().isOk())
                .andExpect(content().string("1 book : 12.49<br/>" +
                        "1 music CD : 16.49<br/>" +
                        "1 chocolate bar : 0.85<br/>" +
                        "Sales Taxes : 1.50 Total : 29.83"));
    }

    @Test
    void computeInput2Test() throws Exception {
        mvc.perform(get("/tax/computeExample2"))
                .andExpect(status().isOk())
                .andExpect(content().string("1 imported box of chocolates : 10.50<br/>" +
                        "1 imported bottle of perfume : 54.65<br/>" +
                        "Sales Taxes : 7.65 Total : 65.15"));
    }

    @Test
    void computeInput3Test() throws Exception {
        mvc.perform(get("/tax/computeExample3"))
                .andExpect(status().isOk())
                .andExpect(content().string("1 imported bottle of perfume : 32.19<br/>" +
                        "1 bottle of perfume : 20.89<br/>" +
                        "1 packet of headache pills : 9.75<br/>" +
                        "1 imported box of chocolates : 11.85<br/>" +
                        "Sales Taxes : 6.70 Total : 74.68"));
    }
}
