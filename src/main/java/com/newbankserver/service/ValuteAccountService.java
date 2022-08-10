package com.newbankserver.service;

import com.newbankserver.entity.ValuteAccount;
import com.newbankserver.interfaces.ValuteAccountInterface;
import com.newbankserver.repository.ValuteAccountRepository;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class ValuteAccountService implements ValuteAccountInterface {

    @Resource
    private ValuteAccountRepository repository;

    @Override
    public List<ValuteAccount> getAll() {
        return repository.findAll();
    }

    @Override
    public ValuteAccount getValuteAccount(int id) {
        return repository.findById(id).orElseThrow(RuntimeException::new);
    }

    @Override
    public ValuteAccount createValuteAccount(ValuteAccount valuteAccount) {
        return  repository.save(valuteAccount);
    }
}