package com.newbankserver.entity;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "ValuteAccounts")
public class ValuteAccount {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int valuteAccountId;
    private int valuteNameId;
    private double value;


    @ManyToMany(fetch = FetchType.LAZY,
            cascade = {
                    CascadeType.MERGE
            },
            mappedBy = "valuteAccounts")
    private Set<Deposit> depositList = new HashSet<>();

    public ValuteAccount() {
        this.valuteAccountId = 0;
        this.valuteNameId = 0;
        this.value = 0;
    }

    public ValuteAccount(int valuteNameId, int value) {
        this.valuteNameId = valuteNameId;
        this.value = value;
    }

    public int getValuteAccountId() {
        return valuteAccountId;
    }
    public void setValuteAccountId(int valuteAccountId) {
        if (valuteAccountId > 0) {
            this.valuteAccountId = valuteAccountId;
        } else {
            this.valuteAccountId = 0;
        }
    }

    public int getValuteNameId() {
        return valuteNameId;
    }
    public void setValuteNameId(int valuteNameId) {
        if (valuteNameId > 0) {
            this.valuteNameId = valuteNameId;
        } else {
            this.valuteNameId = 0;
        }
    }

    public double getValue() {
        return value;
    }
    public void setValue(double value) {
        if (value > 0) {
            this.value = value;
        } else {
            this.value = 0;
        }
    }

    @Override
    public String toString() {
        return "ValuteAccount{" +
                "valuteAccountId=" + valuteAccountId +
                ", valuteNameId=" + valuteNameId +
                ", value=" + value +
                '}';
    }
}
