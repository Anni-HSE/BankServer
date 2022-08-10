package com.newbankserver.entity;

import java.util.Date;

public class Currency {

    private String valCursId;
    private Date dateRange1;
    private Date dateRange2;
    private String name;
    private Date recordDate;
    private int nominal;
    private double value;

    public Currency() {
        this.valCursId = "";
        this.dateRange1 = new Date();
        this.dateRange2 = new Date();
        this.name = "";
        this.recordDate = new Date();
        this.nominal = 1;
        this.value = 0;
    }

    public Currency(String valCursId, Date dateRange1, Date dateRange2, String name, Date recordDate, int nominal, double value) {
        this.valCursId = valCursId;
        this.dateRange1 = dateRange1;
        this.dateRange2 = dateRange2;
        this.name = name;
        this.recordDate = recordDate;
        this.nominal = nominal;
        this.value = value;
    }

    public String getValCursId() {
        return valCursId;
    }
    public void setValCursId(String valCursId) {
        this.valCursId = valCursId;
    }

    public Date getDateRange1() {
        return dateRange1;
    }
    public void setDateRange1(Date dateRange1) {
        this.dateRange1 = dateRange1;
    }

    public Date getDateRange2() {
        return dateRange2;
    }
    public void setDateRange2(Date dateRange2) {
        this.dateRange2 = dateRange2;
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
    public void setRecordDate(Date recordDate) {
        this.recordDate = recordDate;
    }

    public int getNominal() {
        return nominal;
    }
    public void setNominal(int nominal) {
        if (nominal > 0)
            this.nominal = nominal;
        else
            this.nominal = 1;
    }

    public double getValue() {
        return value;
    }
    public void setValue(double value) {
        if(value > 0) {
            this.value = value;
        }
        else {
            value = 0;
        }
    }

    @Override
    public String toString() {
        return "Currency{" +
                "valCursId='" + valCursId + '\'' +
                ", dateRange1=" + dateRange1 +
                ", dateRange2=" + dateRange2 +
                ", name='" + name + '\'' +
                ", recordDate=" + recordDate +
                ", nominal=" + nominal +
                ", value=" + value +
                '}';
    }
}
