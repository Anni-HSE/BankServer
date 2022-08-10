package com.newbankserver.interfaces;

import com.newbankserver.entity.Deposit;

import java.util.List;

public interface DepositInterface {

    List<Deposit> getAll();
    Deposit getDeposit(int depositId);
    Deposit createDeposit(Deposit deposit);
    Deposit updateDeposit(int depositId, Deposit newDeposit);
    void deleteDeposit(int depositId);
}
