package org.example.service;

import org.example.dao.BankAccountRepository;
import org.example.dao.entity.BankAccount;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class BankAccountService {

    public final BankAccountRepository bankAccountRepository;

    public BankAccountService(BankAccountRepository bankAccountRepository) {
        this.bankAccountRepository = bankAccountRepository;
    }

    @Transactional
    public void saveBankAccount(BankAccount bankAccount){
        bankAccountRepository.saveBankAccount(bankAccount);
    }

    public BankAccount findById(Long id){
        return bankAccountRepository.findById(id);
    }

    public List<BankAccount> findAll(){
        return bankAccountRepository.findAll();
    }
}
