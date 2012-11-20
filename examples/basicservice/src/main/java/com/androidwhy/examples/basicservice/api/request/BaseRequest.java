package com.androidwhy.examples.basicservice.api.request;

/**
 * ZhangWo All Rights Reserved.
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
    private int activeStatus;
    private String deviceCode;
    private String clientNo;
    private UaInfo ua;
    private VersionInfo version;

    public BaseRequest() {
       //just for my test
       this.justForTestInit();
    }

    private void justForTestInit(){
        this.sessionToken = "session-token-123456789";
        this.udid = "uuid-abcdefghijklmn";
        this.timestamp = System.currentTimeMillis();

        this.secretKey = "Keiflkvnei2083^&8*^%$@)(*#@$%E";
        this.activeStatus = 1;
        this.deviceCode = "a device code";
        this.clientNo = "ZhangWo";

        UaInfo uaInfo = new UaInfo();
        uaInfo.setSystemName("Gordon iOS");
        uaInfo.setSystemVersion("V6.0.1");
        uaInfo.setBand("Gordon Band");
        this.ua = uaInfo;

        VersionInfo versionInfo = new VersionInfo();
        versionInfo.setAppVersionCode(100);
        this.version = versionInfo;
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

    public int getActiveStatus() {
        return activeStatus;
    }

    public void setActiveStatus(int activeStatus) {
        this.activeStatus = activeStatus;
    }

    public String getDeviceCode() {
        return deviceCode;
    }

    public void setDeviceCode(String deviceCode) {
        this.deviceCode = deviceCode;
    }

    public String getClientNo() {
        return clientNo;
    }

    public void setClientNo(String clientNo) {
        this.clientNo = clientNo;
    }

    public UaInfo getUa() {
        return ua;
    }

    public void setUa(UaInfo ua) {
        this.ua = ua;
    }

    public VersionInfo getVersion() {
        return version;
    }

    public void setVersion(VersionInfo version) {
        this.version = version;
    }
}
