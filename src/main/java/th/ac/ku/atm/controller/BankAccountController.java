package th.ac.ku.atm.controller;

import org.dom4j.rule.Mode;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import th.ac.ku.atm.model.BankAccount;
import th.ac.ku.atm.model.Money;
import th.ac.ku.atm.service.BankAccountService;

@Controller
@RequestMapping("/bankaccount")
public class BankAccountController {

    private BankAccountService accountService;

    public BankAccountController(BankAccountService accountService) {
        this.accountService = accountService;
    }

    @GetMapping
    public String getBankAccountPage(Model model) {
        model.addAttribute("bankaccounts", accountService.getBankAccounts());
        return "bankaccount";
    }

    @PostMapping
    public String openAccount(@ModelAttribute BankAccount bankAccount, Model model) {
        accountService.openAccount(bankAccount);
        model.addAttribute("bankaccounts",accountService.getBankAccounts());
        return "redirect:bankaccount";
    }

    @GetMapping("/edit/{id}")
    public String getEditBankAccountPage(@PathVariable int id, Model model) {
        BankAccount account = accountService.getBankAccount(id);
        model.addAttribute("bankAccount", account);
        return "bankaccount-edit";
    }

    @PostMapping("/edit/{id}")
    public String editAccount(@PathVariable int id,
                              @ModelAttribute BankAccount bankAccount,
                              Model model) {

        accountService.editBankAccount(bankAccount);
        model.addAttribute("bankaccounts",accountService.getBankAccounts());
        return "redirect:/bankaccount";
    }

    @PostMapping("/deposit/{id}")
    public String depositAccount(@PathVariable int id,
                                 @ModelAttribute Money money,
                                 Model model) {
        accountService.depositBankAccount(id, money);
        model.addAttribute("bankaccounts",accountService.getBankAccounts());
        return "redirect:/bankaccount";
    }

    @PostMapping("/withdraw/{id}")
    public String withdrawBankAccount(@PathVariable int id,
                                 @ModelAttribute Money money,
                                 Model model) {
        accountService.withdrawBankAccount(id, money);
        model.addAttribute("bankaccounts",accountService.getBankAccounts());
        return "redirect:/bankaccount";
    }

    @PostMapping("/delete/{id}")
    public String deleteAccount(@PathVariable int id,
                                @ModelAttribute BankAccount bankAccount,
                                Model model) {
        accountService.deleteBankAccount(id);
        model.addAttribute("bankaccounts",accountService.getBankAccounts());
        return "redirect:/bankaccount";
    }

//    @GetMapping
//    public String getBankAccountPage(Model model) {
//        model.addAttribute("allBankAccounts", bankAccountService.getBankAccounts());
//        return "bankaccount";
//    }
//
//    @PostMapping
//    public String registerBankAccount(@ModelAttribute BankAccount bankAccount, Model model) {
//        bankAccountService.createBankAccount(bankAccount);
//        model.addAttribute("allBankAccounts", bankAccountService.getBankAccounts());
//        return "redirect:bankaccount";
//    }
}
