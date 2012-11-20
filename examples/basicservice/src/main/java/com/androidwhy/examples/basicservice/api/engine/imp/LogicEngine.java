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

        String secretKeyBeforMd5 = baseRequest.getActionCode() + baseRequest.getVersion().getAppVersionCode()
                + baseRequest.getTimestamp() + GpConstants.KEY + baseRequest.getClientNo();
        String secretKeyAfterMd5 = MD5Util.getMD5Str(secretKeyBeforMd5);

        if (!secretKeyAfterMd5.equals(baseRequest.getSecretKey())){//非法请求
            BaseResponse response = new BaseResponse();
            response.setRetCode("-1001");
            response.setErrorInfo("非法请求");
            response.setCurrentActionCode(baseRequest.getActionCode());
            return new ResponseEntity(response, HttpStatus.OK);
        }

        /*
        String sessionToken = baseRequest.getSessionToken();
        if (!actionCode.equals(GpConstants.LOGIN_ACTION_CODE)){
            if (actionCode.equals(GpConstants.UPDATE_ACTION_CODE)
                    || actionCode.equals(GpConstants.REGISTER_VERIFICATION_CODE_ACTION_CODE)
                    || actionCode.equals(GpConstants.REGISTER_ACTION_CODE)
                    || actionCode.equals(GpConstants.RESET_PASSWORD_VERIFICATION_CODE_ACTION_CODE)
                    || actionCode.equals(GpConstants.RESET_PASSWORD_ACTION_CODE)
                    ) {
                return null;
            }

            if (StringUtils.isBlank(sessionToken)){
                BaseResponse response = new BaseResponse();
                response.setRetCode("-1003");
                response.setErrorInfo("请您先登录");
                response.setCurrentActionCode(baseRequest.getActionCode());
                return new ResponseEntity(response, HttpStatus.OK);
            }

            User user = accountService.findUserBySessionToken(sessionToken);
            if (user == null){//异地登录
                BaseResponse response = new BaseResponse();
                response.setRetCode("-1004");
                response.setErrorInfo("您的帐户异地登录或修改过密码，请重新登录");
                response.setCurrentActionCode(baseRequest.getActionCode());
                return new ResponseEntity(response, HttpStatus.OK);
            }

            if (!user.getEnable()) {
                BaseResponse response = new BaseResponse();
                response.setRetCode("1012");
                response.setErrorInfo("用户已被锁定，请联系管理员");
                response.setCurrentActionCode(baseRequest.getActionCode());
                return new ResponseEntity(response, HttpStatus.OK);
            }
        }
        */

        return null;
    }
}
