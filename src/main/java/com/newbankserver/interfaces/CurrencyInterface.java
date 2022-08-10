package com.newbankserver.interfaces;

import com.newbankserver.entity.CurrencyDTO;

import java.util.List;

public interface CurrencyInterface {

    List<CurrencyDTO> getAll();
    CurrencyDTO getCurrency(int id);
    CurrencyDTO addCurrency(CurrencyDTO currency);
}
