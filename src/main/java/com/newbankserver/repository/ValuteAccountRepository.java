package com.newbankserver.repository;

import com.newbankserver.entity.ValuteAccount;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ValuteAccountRepository extends JpaRepository<ValuteAccount, Integer> {
}
