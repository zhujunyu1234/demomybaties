package com.example.demo.service;

import com.example.demo.util.GetMessage;
import net.sf.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

/**
 * Created by zhuJY on 17/8/11.
 */
@Service
public class AccessTokenService {
    private final Logger logger = LoggerFactory.getLogger(AccessTokenService.class);
    public static String ACCESS_TOKEN;
    public void getAccessToken(String url) {
        String message = GetMessage.getMeassge(url);
        JSONObject json = JSONObject.fromObject(message);
        ACCESS_TOKEN = json.getString("access_token");
        String code = json.getString("code");
        logger.info("token is " + ACCESS_TOKEN+" code is "+code);
    }


}
