package com.androidwhy.examples.basicservice.api.engine.imp;

import com.androidwhy.examples.basicservice.api.request.BaseRequest;
import com.androidwhy.examples.basicservice.api.request.LoginRequest;
import com.androidwhy.examples.basicservice.api.response.LoginResponse;
import com.androidwhy.examples.basicservice.service.account.AccountService;
import com.androidwhy.examples.basicservice.utils.gp.GpConstants;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import java.util.UUID;

/**
 * Androidwhy.com All Rights Reserved.
 * User: gordon
 * Date: 9/26/12
 * Time: 11:50 AM
 * Description：登录逻辑引擎
 */
@Component
public class LoginLogicEngine extends LogicEngine {

    private static Logger logger = LoggerFactory.getLogger(LoginLogicEngine.class);

    @Autowired
    private AccountService accountService;

    @Override
    public ResponseEntity logicHandler(BaseRequest baseRequest) {
        ResponseEntity responseEntity = super.logicHandler(baseRequest);
        if (responseEntity != null) {
            return super.logicHandler(baseRequest);
        }

        LoginRequest request = (LoginRequest)baseRequest;
        LoginResponse loginResponse = new LoginResponse();

        if (request.getPassword().equals("admin")) { //密码正确
            //设置response
            loginResponse.setRetCode(GpConstants.OK);
            loginResponse.setErrorInfo("");
            loginResponse.setCurrentActionCode(request.getActionCode());
            loginResponse.setSessionToken(UUID.randomUUID().toString());
            loginResponse.setName("admin");

        } else { //提示用户名或密码不正确
            loginResponse.setRetCode("1013");
            loginResponse.setErrorInfo("用户名或者密码不正确");
            loginResponse.setCurrentActionCode(request.getActionCode());
            loginResponse.setSessionToken("");
        }

        return new ResponseEntity(loginResponse, HttpStatus.OK);
    }
}
