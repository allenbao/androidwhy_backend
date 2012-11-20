package com.androidwhy.examples.basicservice.api.engine;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

/**
 * ZhangWo All Rights Reserved.
 * User: gordon
 * Date: 9/26/12
 * Time: 11:36 AM
 * Description：
 */
@Component
public interface ILogicEngine<T> {

    public static final int HASH_INTERATIONS = 1024;

    /**
     *
     * @param baseRequest
     * @return
     */
    public ResponseEntity logicHandler(T baseRequest);
}
