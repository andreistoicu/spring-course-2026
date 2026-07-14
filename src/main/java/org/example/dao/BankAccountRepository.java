package org.example.dao;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.example.dao.entity.BankAccount;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class BankAccountRepository {

    @PersistenceContext
    public EntityManager em;

    public void saveBankAccount(BankAccount bankAccount){
        em.persist(bankAccount);
    }

    public BankAccount findById(Long id){
        return em.find(BankAccount.class, id);
    }

    public List<BankAccount> findAll() {
        return em.createQuery("SELECT b FROM BankAccount b", BankAccount.class)
                .getResultList();
    }

    public void delete(BankAccount bankAccount){
        em.remove(bankAccount);
    }

}
