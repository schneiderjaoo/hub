package com.room.hub.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/financeiro")
public class FinanceiroController {

    @GetMapping("/recibo")
    public String exibirReciboFinanceiro() {
        return "recibo";
    }
}