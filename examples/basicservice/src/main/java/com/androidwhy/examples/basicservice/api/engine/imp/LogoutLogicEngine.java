package com.androidwhy.examples.basicservice.api.engine.imp;

import com.androidwhy.examples.basicservice.api.request.BaseRequest;
import com.androidwhy.examples.basicservice.api.request.LogoutRequest;
import com.androidwhy.examples.basicservice.api.response.LogoutResponse;
import com.androidwhy.examples.basicservice.utils.gp.GpConstants;
import org.apache.commons.lang3.StringUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

/**
 * Androidwhy.com All Rights Reserved.
 * User: gordon
 * Date: 9/26/12
 * Time: 11:56 AM
 * Description：登出逻辑引擎
 */
@Component
public class LogoutLogicEngine extends LogicEngine {

    @Override
    public ResponseEntity logicHandler(BaseRequest baseRequest) {
        ResponseEntity responseEntity = super.logicHandler(baseRequest);
        if (responseEntity != null) {
            return super.logicHandler(baseRequest);
        }

        LogoutRequest request = (LogoutRequest)baseRequest;
        LogoutResponse logoutResponse = null;

        String requestSessionToken = request.getSessionToken();
        if (StringUtils.isNotBlank(requestSessionToken)) {

            logoutResponse = new LogoutResponse();
            logoutResponse.setRetCode(GpConstants.OK);
            logoutResponse.setErrorInfo("");
            logoutResponse.setCurrentActionCode(request.getActionCode());
        }

        return new ResponseEntity(logoutResponse, HttpStatus.OK);
    }
}
