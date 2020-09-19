package th.ac.ku.atm.service;

import org.springframework.stereotype.Service;
import th.ac.ku.atm.model.BankAccount;

import java.util.ArrayList;
import java.util.List;

@Service
public class BankAccountService {
    private List<BankAccount> bankAccountList = new ArrayList<>();

    public void createBankAccount(BankAccount bankAccount) {
        bankAccountList.add(bankAccount);
    }

    public List<BankAccount> getBankAccounts() {
        return new ArrayList<>(bankAccountList);
    }

}