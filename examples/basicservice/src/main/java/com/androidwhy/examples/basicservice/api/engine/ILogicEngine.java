package com.androidwhy.examples.basicservice.api.engine;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

/**
 * Androidwhy.com All Rights Reserved.
 * User: gordon
 * Date: 9/26/12
 * Time: 11:36 AM
 * Description：
 */
@Component
public interface ILogicEngine<T> {

    /**
     *
     * @param baseRequest
     * @return
     */
    public ResponseEntity logicHandler(T baseRequest);
}
