package com.newbankserver.entity;

import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class Mapper {

    public CurrencyDTO currencyToDto(Currency currency) {

        String name = "";

        switch (currency.getValCursId()) {
            case "R01235": {
                name = "Американский доллар";
                break;
            }
            case "R01239": {
                name = "Евро";
                break;
            }
            case "R01375": {
                name = "Китайский Юань";
                break;
            }
        }

        Date recordDate = currency.getRecordDate();
        double value = currency.getValue();

        return new CurrencyDTO(name, recordDate, value);
    }
}
