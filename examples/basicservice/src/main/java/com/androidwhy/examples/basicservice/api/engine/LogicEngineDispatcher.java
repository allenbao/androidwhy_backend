package com.androidwhy.examples.basicservice.api.engine;

import com.androidwhy.examples.basicservice.api.engine.imp.LoginLogicEngine;
import com.androidwhy.examples.basicservice.api.engine.imp.LogoutLogicEngine;
import com.androidwhy.examples.basicservice.api.request.BaseRequest;
import com.androidwhy.examples.basicservice.utils.gp.GpConstants;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

/**
 * AndroidWhy.com All Rights Reserved.
 * User: gordon
 * Date: 10/19/12
 * Time: 3:35 PM
 * Description：
 */
@Component
public class LogicEngineDispatcher {

    private static Logger logger = LoggerFactory.getLogger(LogicEngineDispatcher.class);

    private BaseRequest baseRequest;

    @Autowired
    private LoginLogicEngine loginLogicEngine;

    @Autowired
    private LogoutLogicEngine logoutLogicEngine;



    public ResponseEntity dispatch(){

        ResponseEntity responseEntity = null;
        String actionCode = this.baseRequest.getActionCode();

        //TODO:优化
        if (actionCode.equals(GpConstants.LOGIN_ACTION_CODE)){
            responseEntity = loginLogicEngine.logicHandler(baseRequest);
        } else if (actionCode.equals(GpConstants.LOGOUT_ACTION_CODE)){
            responseEntity = logoutLogicEngine.logicHandler(baseRequest);
        }

        return responseEntity;
    }

    public void setBaseRequest(BaseRequest baseRequest) {
        this.baseRequest = baseRequest;
    }
}
