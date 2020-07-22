package com.example.rxjavaapp;

import java.math.BigDecimal;
import java.util.Date;

public class Entry {

    private final String entryName;
    private final BigDecimal entryPrice;
    private final Date entryDate;

    public Entry(String entryName, BigDecimal entryPrice, Date entryDate) {
        this.entryName = entryName;
        this.entryPrice = entryPrice;
        this.entryDate = entryDate;
    }

    public String getEntryName() {
        return entryName;
    }

    public BigDecimal getEntryPrice() {
        return entryPrice;
    }

    public Date getEntryDate() {
        return entryDate;
    }
}
