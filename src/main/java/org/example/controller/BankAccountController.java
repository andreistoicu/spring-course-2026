package org.example.controller;

import org.example.dao.entity.BankAccount;
import org.example.service.BankAccountService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class BankAccountController {

    public final BankAccountService  bankAccountService;

    public BankAccountController(BankAccountService bankAccountService) {
        this.bankAccountService = bankAccountService;
    }

    @GetMapping("/newBankAccount")
    public String bankAccountForm(Model model) {
        model.addAttribute("bankAccount", new BankAccount());
        return "bankaccount/bankAccountForm";
    }

    @PostMapping("/accounts") // save bankAccount din form
    public String submitBankAccount(Model model, @ModelAttribute BankAccount bankAccount) {
        bankAccountService.saveBankAccount(bankAccount);
        model.addAttribute("bankAccount", bankAccount);
        return "bankaccount/success";
    }

    @GetMapping("/accounts")//afiseaza toate accounts
    public String getBankAccounts(Model model){
        model.addAttribute("accounts", bankAccountService.findAll());
        return "bankaccount/bankAccountTable";
    }
}
