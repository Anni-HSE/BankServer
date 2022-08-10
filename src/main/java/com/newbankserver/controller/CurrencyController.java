package com.newbankserver.controller;

import com.newbankserver.entity.Currency;
import com.newbankserver.entity.CurrencyDTO;
import com.newbankserver.entity.Mapper;
import com.newbankserver.service.CurrencyService;
import com.fasterxml.jackson.core.JsonProcessingException;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.util.List;

@RestController
@RequestMapping(value = "/currency")
@CrossOrigin(origins = "http:/localhost:3000/", maxAge = 3600)
@Api(tags = "CurrencyController")
public class CurrencyController {

    private final CurrencyService currencyService;
    private final Mapper mapper;

    @Autowired
    public CurrencyController(CurrencyService currencyService, Mapper mapper) {
        this.currencyService = currencyService;
        this.mapper = mapper;
    }

    @ResponseBody
    @GetMapping(path = "/getCurrencies", produces = "application/json")
    @ApiOperation(value = "Получить все курсы за все время работы сервиса", notes = "Получить подробную информацию на основе URL-адреса")
    public List<CurrencyDTO> getUsers() {
        return currencyService.getAll();
    }

    @ResponseBody
    @GetMapping(path = "/getCurrency={currencyId}", produces = "application/json")
    @ApiOperation(value = "Получить курс по индентификатору", notes = "Получить подробную информацию на основе URL-адреса")
    @ApiImplicitParam(name = "currencyId", value = "ID", readOnly = true, dataType = "int", paramType = "path")
    public CurrencyDTO getCurrencyById(@PathVariable int currencyId) {
        return currencyService.getCurrency(currencyId);
    }

    @ResponseBody
    @PostMapping(path = "/addCurrency", produces = "application/json")
    @ApiOperation(value = "Получить последний курс выбранной валюты", notes = "Создать новый курс на основе информации URL-адреса")
    @ApiImplicitParam(name = "valCursId", value = "currencyDTO", readOnly = true, dataType = "String", paramType = "path")
    public CurrencyDTO addCurrency(@RequestBody String valCursId) throws JsonProcessingException, ParseException {
        Currency currency = currencyService.getValCurs(valCursId);
        return mapper.currencyToDto(currency);
    }
}
