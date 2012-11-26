package com.androidwhy.examples.basicservice.api;

import com.androidwhy.examples.basicservice.api.engine.LogicEngineDispatcher;
import com.androidwhy.examples.basicservice.api.protocol.IRequestProtocol;
import com.androidwhy.examples.basicservice.api.request.BaseRequest;
import com.androidwhy.modules.mapper.JsonMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Androidwhy.com All Rights Reserved.
 * User: gordon
 * Date: 9/26/12
 * Time: 10:48 AM
 * Description：
 */
@Controller
@RequestMapping(value = "/api/v1/hello.gp")
public class GpApiController {

    private static Logger logger = LoggerFactory.getLogger(GpApiController.class);

    @Autowired
    private IRequestProtocol<BaseRequest, String> requestProtocol;

    @Autowired
    private LogicEngineDispatcher logicEngineDispatcher;


    @RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public ResponseEntity<?> api(@RequestBody String requestBody) {

        //协议解析
        BaseRequest baseRequest = requestProtocol.decode(requestBody);

        //执行请求处理逻辑
        logicEngineDispatcher.setBaseRequest(baseRequest);
        ResponseEntity responseEntity = logicEngineDispatcher.dispatch();

        //记录响应日志
        JsonMapper normalBinder = new JsonMapper();
        logger.info("Response:{}",normalBinder.toJson(responseEntity.getBody()));

        return responseEntity;
    }
}
