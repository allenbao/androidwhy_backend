package com.androidwhy.examples.basicservice.api.protocol.imp;

import com.androidwhy.examples.basicservice.api.protocol.IRequestProtocol;
import com.androidwhy.examples.basicservice.api.protocol.ProtocolUtils;
import com.androidwhy.examples.basicservice.api.request.BaseRequest;
import com.androidwhy.modules.mapper.JsonMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * AndroidWhy.com All Rights Reserved.
 * User: gordon
 * Date: 10/19/12
 * Time: 11:21 AM
 * Description：
 */
@Component
public class RequestProtocol implements IRequestProtocol<BaseRequest, String> {

    private static Logger logger = LoggerFactory.getLogger(RequestProtocol.class);

    /**
     *
     * @param s
     * @return
     */
    @Override
    public BaseRequest decode(String s) {
        BaseRequest br = null;
        logger.info("Request:{}", s);

        JsonMapper normalBinder = new JsonMapper();
        BaseRequest baseRequest = normalBinder.fromJson(s, BaseRequest.class);

        //基础协议解析出错
        if (baseRequest == null) {
            logger.info("BaseRequest fromJson is Error.");
            return null;
        }

        String actionCode = baseRequest.getActionCode();
        logger.info("ActionCode key is:{}.", actionCode);

        Class<? extends BaseRequest> requestClass = ProtocolUtils.getRequestClassByActionCode(actionCode);
        if (null == requestClass) {
            logger.info("ActionCode {} is NOT support.", actionCode);
            return null;
        } else {
            br = normalBinder.fromJson(s, requestClass);
        }
        return br;
    }
}
