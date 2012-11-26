package com.androidwhy.examples.basicservice.api.request;

import com.androidwhy.examples.basicservice.utils.gp.GpConstants;

/**
 * Androidwhy.com All Rights Reserved.
 * User: gordon
 * Date: 9/24/12
 * Time: 2:53 PM
 * Description：
 */
public class LogoutRequest extends BaseRequest {

    public LogoutRequest() {
        this.actionCode = GpConstants.LOGOUT_ACTION_CODE;
    }

}
