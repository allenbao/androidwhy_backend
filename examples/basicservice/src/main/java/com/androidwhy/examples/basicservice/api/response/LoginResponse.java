package com.androidwhy.examples.basicservice.api.response;

/**
 * Androidwhy.com All Rights Reserved.
 * User: gordon
 * Date: 9/24/12
 * Time: 2:57 PM
 * Description：
 */
public class LoginResponse extends BaseResponse {

    private String name;
    private String sessionToken;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSessionToken() {
        return sessionToken;
    }

    public void setSessionToken(String sessionToken) {
        this.sessionToken = sessionToken;
    }

    @Override
    public String toString() {
        return super.toString() + "[sessionToken:" + sessionToken + "]";
    }
}
