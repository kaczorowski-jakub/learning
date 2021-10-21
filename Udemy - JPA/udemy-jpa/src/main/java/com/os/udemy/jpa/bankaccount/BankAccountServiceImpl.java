package com.os.udemy.jpa.bankaccount;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BankAccountServiceImpl implements BankAccountService {

    @Autowired
    BankAccountRepository repository;

    @Override
    @Transactional
    public void transfer(int amount) {

        BankAccount obamasAccount = repository.findById(1).get();
        obamasAccount.setBal(obamasAccount.getBal() - amount);
        repository.save(obamasAccount);
        
        if (true) {
            throw new RuntimeException();
        }
        
        BankAccount trumpsAccount = repository.findById(2).get();
        trumpsAccount.setBal(trumpsAccount.getBal() + amount);
        repository.save(trumpsAccount);

    }

}
