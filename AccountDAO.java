package com.example.bank.dao;

import jakarta.persistence.*;
import org.springframework.stereotype.Repository;
import com.example.bank.entity.Account;

@Repository
public class AccountDAO {
 @PersistenceContext
 private EntityManager em;

 public Account get(int id) {
     return em.find(Account.class, id);
 }

 public void update(Account acc) {
     em.merge(acc);
 }
}
