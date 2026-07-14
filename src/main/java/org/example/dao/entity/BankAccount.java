package org.example.dao.entity;

import jakarta.persistence.*;

@Entity
@Table(name="bank_account")
public class BankAccount {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name="customer_name", nullable=false)
    private String customerName;

    @Column(name="account_number")
    private String accountNumber;

    @Column(name="account_currency")
    private String accountCurrency;

    @Column(name="amount")
    private Double amount;

    @Column(name="isOpen")
    private Boolean isOpen;

    @Version
    private Long version;

    public BankAccount() {
    }

    public BankAccount(Long id, String customerName, String accountNumber, String accountCurrency, Double amount, Boolean isOpen, Long version) {
        this.id = id;
        this.customerName = customerName;
        this.accountNumber = accountNumber;
        this.accountCurrency = accountCurrency;
        this.amount = amount;
        this.isOpen = isOpen;
        this.version = version;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public String getAccountCurrency() {
        return accountCurrency;
    }

    public void setAccountCurrency(String accountCurrency) {
        this.accountCurrency = accountCurrency;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public Boolean getIsOpen() {
        return isOpen;
    }

    public void setIsOpen(Boolean open) {
        isOpen = open;
    }

    public Long getVersion() {
        return version;
    }

    public void setVersion(Long version) {
        this.version = version;
    }

    @Override
    public String toString() {
        return "BankAccount{" +
                "id=" + id +
                ", customerName='" + customerName + '\'' +
                ", accountNumber='" + accountNumber + '\'' +
                ", accountCurrency='" + accountCurrency + '\'' +
                ", amount=" + amount +
                ", isOpen=" + isOpen +
                ", version=" + version +
                '}';
    }
}
