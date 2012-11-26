package com.androidwhy.examples.basicservice.api;

import com.androidwhy.examples.basicservice.api.request.LoginRequest;
import com.androidwhy.examples.basicservice.api.response.LoginResponse;
import com.androidwhy.examples.basicservice.utils.gp.GpConstants;
import com.androidwhy.examples.basicservice.utils.md5.MD5Util;
import com.androidwhy.modules.mapper.JsonMapper;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import static org.junit.Assert.assertEquals;

/**
 * 
 * @author Gordon
 */
public class ApiFT {

    private final RestTemplate restTemplate = new RestTemplate();

    private final JsonMapper jsonMapper = new JsonMapper();

    private static String resourceUrl;

    @BeforeClass
    public static void initUrl() {
        resourceUrl = "http://localhost:9999/api/v1/hello.gp";
    }

    // --------------- Test Start ---------------------------- //

    @Test
    public void testLoginRequest() {
        LoginRequest request = new LoginRequest();
        request.setUsername("gordon");
        request.setPassword("admin");

        String secretKeyBeforMd5 = request.getActionCode() + request.getAppVersionCode()
                + request.getTimestamp() + GpConstants.KEY;
        String secretKeyAfterMd5 = MD5Util.getMD5Str(secretKeyBeforMd5);

        request.setSecretKey(secretKeyAfterMd5);


        ResponseEntity<LoginResponse> responseEntity = null;
        responseEntity = restTemplate.postForEntity(resourceUrl, request, LoginResponse.class);
        LoginResponse response = responseEntity.getBody();

        assertEquals("0000", response.getRetCode());
    }

}
