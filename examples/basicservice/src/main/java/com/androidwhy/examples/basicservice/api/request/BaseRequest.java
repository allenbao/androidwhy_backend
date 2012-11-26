package com.androidwhy.examples.basicservice.api.request;

/**
 * Androidwhy.com All Rights Reserved.
 * User: gordon
 * Date: 9/21/12
 * Time: 5:25 PM
 * Description：
 */
public class BaseRequest {

    protected String actionCode;
    private String sessionToken;
    private String udid;
    private Long timestamp;
    private String secretKey;
    private String deviceCode;
    private int appVersionCode;

    public BaseRequest() {
       //just for my test
       this.justForTestInit();
    }

    private void justForTestInit(){
        this.sessionToken = "session-token-123456789";
        this.udid = "uuid-abcdefghijklmn";
        this.timestamp = System.currentTimeMillis();

        this.secretKey = "Keiflkvnei2083^&8*^%$@)(*#@$%E";
        this.deviceCode = "a device code";
        this.appVersionCode = 100;
    }

    public String getActionCode() {
        return actionCode;
    }

    public void setActionCode(String actionCode) {
        this.actionCode = actionCode;
    }

    public String getSessionToken() {
        return sessionToken;
    }

    public void setSessionToken(String sessionToken) {
        this.sessionToken = sessionToken;
    }

    public String getUdid() {
        return udid;
    }

    public void setUdid(String udid) {
        this.udid = udid;
    }

    public Long getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Long timestamp) {
        this.timestamp = timestamp;
    }

    public String getSecretKey() {
        return secretKey;
    }

    public void setSecretKey(String secretKey) {
        this.secretKey = secretKey;
    }

    public String getDeviceCode() {
        return deviceCode;
    }

    public void setDeviceCode(String deviceCode) {
        this.deviceCode = deviceCode;
    }

    public int getAppVersionCode() {
        return appVersionCode;
    }

    public void setAppVersionCode(int appVersionCode) {
        this.appVersionCode = appVersionCode;
    }
}
