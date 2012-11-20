package com.androidwhy.examples.basicservice.api.protocol;

import com.androidwhy.examples.basicservice.api.request.BaseRequest;
import com.androidwhy.examples.basicservice.api.request.LoginRequest;
import com.androidwhy.examples.basicservice.api.request.LogoutRequest;
import com.androidwhy.examples.basicservice.utils.gp.GpConstants;

import java.util.HashMap;
import java.util.Map;

/**
 * AndroidWhy.com All Rights Reserved.
 * User: gordon
 * Date: 10/19/12
 * Time: 9:41 AM
 * Description：
 */
public class ProtocolUtils {

    private static Map<String, Class<? extends BaseRequest>> requestMessageClasses = new HashMap<String, Class<? extends BaseRequest>>();

    static {
        requestMessageClasses.put(GpConstants.LOGIN_ACTION_CODE, LoginRequest.class);
        requestMessageClasses.put(GpConstants.LOGOUT_ACTION_CODE, LogoutRequest.class);

    }

    public static Class<BaseRequest> getRequestClassByActionCode(String actionCode) {
        return (Class<BaseRequest>) requestMessageClasses.get(actionCode);
    }
}
