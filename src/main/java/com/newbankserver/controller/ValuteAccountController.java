package com.newbankserver.controller;

import com.newbankserver.entity.ValuteAccount;
import com.newbankserver.service.ValuteAccountService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/valuteAccount")
@CrossOrigin(origins = "http:/localhost:3000/", maxAge = 3600)
@Api(tags = "ValuteAccountController")
public class ValuteAccountController {

    private final ValuteAccountService service;

    public ValuteAccountController(ValuteAccountService service) {
        this.service = service;
    }

    @ResponseBody
    @GetMapping(path = "/getValuteAccounts", produces = "application/json")
    @ApiOperation(value = "Получить все cчета", notes = "Получить подробную информацию на основе URL-адреса")
    public List<ValuteAccount> getAll() {
        return service.getAll();
    }

    @ResponseBody
    @GetMapping(path = "/getValuteAccount={valuteAccountId}", produces = "application/json")
    @ApiOperation(value = "Получить cчет по индентификатору", notes = "Получить подробную информацию на основе URL-адреса")
    @ApiImplicitParam(name = "valuteAccountId", value = "ID", readOnly = true, dataType = "int", paramType = "path")
    public ValuteAccount getValuteAccountById(@PathVariable int valuteAccountId) {
        return service.getValuteAccount(valuteAccountId);
    }

    @ResponseBody
    @PostMapping(path = "/createValuteAccount", produces = "application/json")
    @ApiOperation(value = "Создать новой счет", notes = "Создать счет на основе информации URL-адреса")
    @ApiImplicitParam(name = "ValuteAccount", value = "valuteAccount", readOnly = true, dataType = "ValuteAccount", paramType = "path")
    public ValuteAccount createValuteAccount(@RequestBody ValuteAccount valuteAccount) {
        return  service.createValuteAccount(valuteAccount);
    }
}
