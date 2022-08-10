package com.newbankserver.service;

import com.newbankserver.entity.Currency;
import com.newbankserver.entity.CurrencyDTO;
import com.newbankserver.interfaces.CurrencyInterface;
import com.newbankserver.repository.CurrencyRepository;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class CurrencyService implements CurrencyInterface {

    private final RestTemplate restTemplate;

    @Resource
    private CurrencyRepository repository;

    public CurrencyService() {
        this.restTemplate = new RestTemplate();
    }

    @Override
    public List<CurrencyDTO> getAll() {
        List<CurrencyDTO> currencies = new ArrayList<>();
        repository.findAll().forEach(currencies::add);
        return currencies;
    }

    @Override
    public CurrencyDTO getCurrency(int id) {
        return repository.findById(id).orElseThrow(RuntimeException::new);
    }

    @Override
    public CurrencyDTO addCurrency(CurrencyDTO currency) {
        return repository.save(currency);
    }

    public Currency getValCurs(String valCursId) throws JsonProcessingException, ParseException {

        DateFormat formatter = new SimpleDateFormat("dd/mm/yyyy");
        String recordDate = formatter.format(formatter.parse(new Date().toString()));

        String xml = restTemplate.getForObject("https://www.cbr.ru/scripts/XML_dynamic.asp?date_req1=" + recordDate +
                        "&date_req2="+ recordDate +"&VAL_NM_RQ={valCursId}", String.class, valCursId);

        XmlMapper xmlMapper = new XmlMapper();
        Currency currency = xmlMapper.readValue(xml, Currency.class);

        return currency;
    }
}