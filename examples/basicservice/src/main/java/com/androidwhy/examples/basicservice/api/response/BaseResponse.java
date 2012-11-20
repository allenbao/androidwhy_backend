package com.androidwhy.examples.basicservice.api.response;

/**
 * ZhangWo All Rights Reserved.
 * User: gordon
 * Date: 9/21/12
 * Time: 8:34 PM
 * Description：
 */
public class BaseResponse {

    private String retCode;
    private String errorInfo;
    private String currentActionCode;

    public String getRetCode() {
        return retCode;
    }

    public void setRetCode(String retCode) {
        this.retCode = retCode;
    }

    public String getErrorInfo() {
        return errorInfo;
    }

    public void setErrorInfo(String errorInfo) {
        this.errorInfo = errorInfo;
    }

    public String getCurrentActionCode() {
        return currentActionCode;
    }

    public void setCurrentActionCode(String currentActionCode) {
        this.currentActionCode = currentActionCode;
    }

    @Override
    public String toString() {
        return "[retcode:" + retCode + " , errorInfo:" + errorInfo + " , currentActionCode:" + "]";
    }
}
