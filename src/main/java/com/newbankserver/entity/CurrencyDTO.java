package com.newbankserver.entity;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "Сurrencies")
public class CurrencyDTO {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int currencyId;

    private String name;
    private Date recordDate;
    private double value;

    public CurrencyDTO() {
        this.currencyId = 0;
        this.name = "";
        this.recordDate = new Date();
        this.value = 0;
    }

    public CurrencyDTO(int currencyId, String name, Date recordDate, double value) {
        this.currencyId = currencyId;
        this.name = name;
        this.recordDate = recordDate;
        this.value = value;
    }

    public CurrencyDTO(String name, Date recordDate, double value) {
        this.name = name;
        this.recordDate = recordDate;
        this.value = value;
    }

    public int getCurrencyId() {
        return currencyId;
    }
    public void setCurrencyId(int currencyId) {
        if (currencyId > 0) {
            this.currencyId = currencyId;
        }
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public Date getRecordDate() {
        return recordDate;
    }
    public void setRecordDate(Date date) {
        int result = date.compareTo(new Date());
        if (result <= 0) {
            if (date.compareTo(new Date(1,1,1990)) >= 0) {
                this.recordDate = date;
            }
            else {
                this.recordDate = new Date();
            }
        }
        else if (result > 0) {
            this.recordDate = new Date();
        }
    }

    public double getValue() {
        return value;
    }
    public void setValue(double value) {
        if (value >= 0) {
            this.value = value;
        }
    }

    public String toString() {
        return "Валюта '" + this.getName() + "', курс на " + this.getRecordDate() + ": 1 " + this.getName() + " = " + this.getValue() + " рубля";
    }
}
