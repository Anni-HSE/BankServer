package com.newbankserver.interfaces;

import com.newbankserver.entity.ValuteAccount;

import java.util.List;

public interface ValuteAccountInterface {

    List<ValuteAccount> getAll();
    ValuteAccount getValuteAccount(int id);
    ValuteAccount createValuteAccount(ValuteAccount valuteAccount);
}

