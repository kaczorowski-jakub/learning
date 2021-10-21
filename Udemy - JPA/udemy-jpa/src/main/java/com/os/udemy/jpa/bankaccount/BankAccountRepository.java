package com.os.udemy.jpa.bankaccount;

import org.springframework.data.repository.CrudRepository;

public interface BankAccountRepository extends CrudRepository<BankAccount, Integer> {

}
