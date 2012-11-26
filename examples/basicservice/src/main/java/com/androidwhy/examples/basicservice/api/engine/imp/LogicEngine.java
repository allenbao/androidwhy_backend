package com.androidwhy.examples.basicservice.api.engine.imp;

import com.androidwhy.examples.basicservice.api.engine.ILogicEngine;
import com.androidwhy.examples.basicservice.api.request.BaseRequest;
import com.androidwhy.examples.basicservice.api.response.BaseResponse;
import com.androidwhy.examples.basicservice.utils.gp.GpConstants;
import com.androidwhy.examples.basicservice.utils.md5.MD5Util;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

/**
 * AndroidWhy.com All Rights Reserved.
 * User: gordon
 * Date: 10/19/12
 * Time: 2:35 PM
 * Description：
 */
public class LogicEngine implements ILogicEngine<BaseRequest> {

    @Override
    public ResponseEntity logicHandler(BaseRequest baseRequest) {

        //基础协议解析出错
        if (baseRequest == null) {
            BaseResponse response = new BaseResponse();
            response.setRetCode("-1000");
            response.setErrorInfo("请求协议解析出错");  //或者 您的操作ActionCode不支持
            response.setCurrentActionCode(baseRequest.getActionCode());
            return new ResponseEntity(response, HttpStatus.OK);
        }

        String actionCode = baseRequest.getActionCode();

        String secretKeyBeforMd5 = baseRequest.getActionCode() + baseRequest.getAppVersionCode()
                + baseRequest.getTimestamp() + GpConstants.KEY;
        String secretKeyAfterMd5 = MD5Util.getMD5Str(secretKeyBeforMd5);

        if (!secretKeyAfterMd5.equals(baseRequest.getSecretKey())){//非法请求
            BaseResponse response = new BaseResponse();
            response.setRetCode("-1001");
            response.setErrorInfo("非法请求");
            response.setCurrentActionCode(baseRequest.getActionCode());
            return new ResponseEntity(response, HttpStatus.OK);
        }

        return null;
    }
}
