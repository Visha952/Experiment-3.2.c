package com.example.bank.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.example.bank.dao.AccountDAO;
import com.example.bank.entity.Account;

@Service
public class BankService {
 @Autowired private AccountDAO dao;

 @Transactional
 public void transfer(int from, int to, double amt){
     Account a = dao.get(from);
     Account b = dao.get(to);
     a.setBalance(a.getBalance() - amt);
     b.setBalance(b.getBalance() + amt);
     dao.update(a);
     dao.update(b);
     System.out.println("Transfer complete!");
 }
}
