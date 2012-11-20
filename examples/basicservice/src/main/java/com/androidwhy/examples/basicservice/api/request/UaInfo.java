package com.androidwhy.examples.basicservice.api.request;

/**
 * ZhangWo All Rights Reserved.
 * User: gordon
 * Date: 9/26/12
 * Time: 10:13 AM
 * Description：
 */
public class UaInfo {

    private String systemName;
    private String systemVersion;
    private String band;

    public String getSystemName() {
        return systemName;
    }

    public void setSystemName(String systemName) {
        this.systemName = systemName;
    }

    public String getSystemVersion() {
        return systemVersion;
    }

    public void setSystemVersion(String systemVersion) {
        this.systemVersion = systemVersion;
    }

    public String getBand() {
        return band;
    }

    public void setBand(String band) {
        this.band = band;
    }
}
