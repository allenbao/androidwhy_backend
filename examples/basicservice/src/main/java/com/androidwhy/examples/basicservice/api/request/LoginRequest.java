package com.androidwhy.examples.basicservice.api.request;

/**
 * ZhangWo All Rights Reserved.
 * User: gordon
 * Date: 9/24/12
 * Time: 2:54 PM
 * Description：
 */
public class LoginRequest extends BaseRequest {

    private String username;
    private String password;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
