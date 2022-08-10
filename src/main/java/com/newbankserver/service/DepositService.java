package com.newbankserver.service;

import com.newbankserver.entity.Deposit;
import com.newbankserver.interfaces.DepositInterface;
import com.newbankserver.repository.DepositRepository;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class DepositService implements DepositInterface
{
    @Resource
    private DepositRepository repository;

    @Override
    public List<Deposit> getAll(){
        return repository.findAll();
    }

    @Override
    public Deposit getDeposit(int depositId) {
        return repository.findById(depositId).orElseThrow(RuntimeException::new);
    }

    @Override
    public Deposit createDeposit(Deposit deposit) {
        return repository.save(deposit);
    }

    @Override
    public Deposit updateDeposit(int depositId, Deposit newDeposit) {
        return repository.findById(depositId)
                .map(deposit -> {
                    deposit.setUserId(newDeposit.getUserId());
                    return repository.save(deposit);
                })
                .orElseGet(() -> {
                    newDeposit.setUserId(depositId);
                    return repository.save(newDeposit);
                });
    }

    @Override
    public void deleteDeposit(int depositId) {
        repository.deleteById(depositId);
    }
}