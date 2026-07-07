package org.example.dao;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.example.dto_model.Customer;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class CustomerRepository {

    @PersistenceContext
    private EntityManager entityManager;

    public void save(Customer customer) {
        if(customer.getId() == null){
            entityManager.persist(customer);
        } else {
            //metoda de tip update in baza de date
            entityManager.merge(customer);
        }

    }

    public Customer findById(Long id) {
        return entityManager.find(Customer.class, id);
    }

    //JPQL method
    public List<Customer> findAll() {
        return entityManager.createQuery("SELECT c FROM Customer c", Customer.class)
                .getResultList();
    }

}
