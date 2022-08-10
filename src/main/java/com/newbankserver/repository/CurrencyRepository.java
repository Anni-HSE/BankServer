package com.newbankserver.repository;

import com.newbankserver.entity.CurrencyDTO;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CurrencyRepository extends JpaRepository<CurrencyDTO, Integer> {
}
