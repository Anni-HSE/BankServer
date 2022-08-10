package com.newbankserver.entity;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "Deposits")
public class Deposit {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int depositId;
    private int userId;


    @ManyToMany(
            fetch = FetchType.LAZY,
            cascade = {
                    CascadeType.PERSIST,
                    CascadeType.MERGE
            })
    @JoinTable(
            name = "DepositAccounts",
            joinColumns = {@JoinColumn(name = "depositId")},
            inverseJoinColumns = {@JoinColumn(name = "valuteAccountId")}
            )
    private Set<ValuteAccount> valuteAccounts = new HashSet<>();

    public Deposit() {
        this.depositId = 0;
        this.userId = 0;
    }

    public Deposit(int userId) {
        this.userId = userId;
    }

    public int getDepositId() {
        return  depositId;
    }
    public void setDepositId(int depositId) {
        this.depositId = depositId;
    }

    public int getUserId() {
        return userId;
    }
    public void setUserId(int userId) {
        this.userId = userId;
    }

    @Override
    public String toString() {
        return "Deposit{" +
                "depositId=" + depositId +
                ", userId=" + userId +
                '}';
    }
}
