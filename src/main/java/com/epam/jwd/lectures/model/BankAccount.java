package com.epam.jwd.lectures.model;

public interface BankAccount extends Comparable<BankAccount> {

    int getBalance();

    void debit(int amount);

    void credit(int amount);

}
