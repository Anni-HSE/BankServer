package com.newbankserver.controller;

import com.newbankserver.entity.Deposit;
import com.newbankserver.service.DepositService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/deposit")
@CrossOrigin(origins = "http:/localhost:3000/", maxAge = 3600)
@Api(tags = "DepositController")
public class DepositController {

    private final DepositService depositService;

    @Autowired
    public DepositController(DepositService depositService) {
        this.depositService = depositService;
    }

    @ResponseBody
    @GetMapping(path = "/getDeposits", produces = "application/json")
    @ApiOperation(value = "Получить все депозиты", notes = "Получить подробную информацию на основе URL-адреса")
    public List<Deposit> getDeposits() {
        return depositService.getAll();
    }

    @ResponseBody
    @GetMapping(path = "/getDeposit={depositId}", produces = "application/json")
    @ApiOperation(value = "Получить депозит по индентификатору", notes = "Получить подробную информацию на основе URL-адреса")
    @ApiImplicitParam(name = "depositId", value = "ID", readOnly = true, dataType = "int", paramType = "path")
    public Deposit getDepositById(@PathVariable int depositId) {
        return depositService.getDeposit(depositId);
    }

    @ResponseBody
    @PostMapping(path = "/createDeposit", produces = "application/json")
    @ApiOperation(value = "Создать новой депозит", notes = "Создать пользователя на основе информации URL-адреса")
    @ApiImplicitParam(name = "Deposit", value = "deposit", readOnly = true, dataType = "Deposit", paramType = "path")
    public Deposit createDeposit(@RequestBody Deposit deposit) {
        return  depositService.createDeposit(deposit);
    }

    @ResponseBody
    @PutMapping(path = "/updateDeposit={depositId}", produces = "application/json")
    @ApiOperation(value = "Обновить данные о депозите", notes = "Получить подробную информацию на основе URL-адреса и обновить их")
    @ApiImplicitParam(name = "depositId", value = "ID", readOnly = true, dataType = "int", paramType = "path")
    public Deposit replaceDeposit(@PathVariable int depositId, @RequestBody Deposit deposit) {
        return depositService.updateDeposit(depositId, deposit);
    }

    @ResponseBody
    @DeleteMapping(path = "/deleteDeposit={depositId}")
    @ApiOperation(value = "Удалить депозит", notes = "Удалить пользователя на основе информации URL-адреса")
    @ApiImplicitParam(name = "depositId", value = "depositId", readOnly = true, dataType = "int", paramType = "path")
    public void deleteDeposit(@PathVariable int depositId) {
        depositService.deleteDeposit(depositId);
    }
}
