package com.hitweb.betgain.application.controller;

import com.hitweb.betgain.domain.moneyflow.service.MoneyFlowService;
import com.hitweb.betgain.domain.moneyflow.usecases.payload.request.DepositRequest;
import com.hitweb.betgain.domain.moneyflow.usecases.payload.request.ListMoneyFlowsRequest;
import com.hitweb.betgain.domain.moneyflow.usecases.payload.request.WidthDrawRequest;
import com.hitweb.betgain.domain.moneyflow.usecases.payload.response.ListMoneyFlowsResponse;
import com.hitweb.betgain.domain.moneyflow.usecases.payload.response.MoneyFlowResponse;
import com.hitweb.betgain.domain.user.service.UserService;
import com.hitweb.betgain.domain.user.usecases.payload.request.ProfileRequest;
import com.hitweb.betgain.domain.user.usecases.payload.response.ClientResponse;
import com.hitweb.betgain.infrastructure.services.auth.security.WebSecurityConfig;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@CrossOrigin
@RestController
@RequestMapping("/api/profile")
public class ProfileController {

    private final UserService userService;
    private final MoneyFlowService moneyFlowService;


    public ProfileController(UserService userService, MoneyFlowService moneyFlowService) {
        this.userService = userService;
        this.moneyFlowService = moneyFlowService;
    }

    @PutMapping("edit/{id}")
    public ClientResponse editProfile(@PathVariable("id") int id, @Valid @RequestBody ProfileRequest profileRequest) {
        profileRequest.setId(id);
        return userService.editProfile(profileRequest);
    }

    @PostMapping("deposit/{id}")
    public MoneyFlowResponse makeDeposit(@PathVariable("id") int id, @Valid @RequestBody DepositRequest depositRequest) {
        depositRequest.setLoggedUser(WebSecurityConfig.getUser());
        depositRequest.setUserId(id);
        return moneyFlowService.makeMoneyFlow(depositRequest);
    }

    @PostMapping("withdraw/{id}")
    public MoneyFlowResponse makeWithdraw(@PathVariable("id") int id, @Valid @RequestBody WidthDrawRequest widthDrawRequest) {
        widthDrawRequest.setLoggedUser(WebSecurityConfig.getUser());
        widthDrawRequest.setUserId(id);
        return moneyFlowService.makeMoneyFlow(widthDrawRequest);
    }

    @GetMapping("moneyflows/{id}")
    public ListMoneyFlowsResponse listMoneyflows(@PathVariable("id") int id) {
        ListMoneyFlowsRequest listMoneyFlowsRequest = new ListMoneyFlowsRequest(WebSecurityConfig.getUser(), id);
        System.out.println(id
        );
        return moneyFlowService.listMoneyFlows(listMoneyFlowsRequest);
    }
}
