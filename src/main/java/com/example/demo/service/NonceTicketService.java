package com.example.demo.service;

import com.example.demo.util.GetMessage;
import com.example.demo.util.SignUtil;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 * Created by zhuJY on 17/8/11.
 */
@Service
public class NonceTicketService {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());
    public static String nonceTicket = null;
    String message = null;
    @Value("${my.appID}")
    private String appID;
    @Value("${my.appScret}")
    private String appScret;
    @Value("${my.userID}")
    private String userID;

    public String getNonceTicket() {
        logger.info("appid is"+appID+" sec is "+appScret+"user is "+userID);
        String url = "https://idasc.webank.com/api/oauth2/api_ticket?app_id=" + appID + "&access_token=" + AccessTokenService.ACCESS_TOKEN + "&type=NONCE&version=1.0.0&user_id=" + userID;
        message = GetMessage.getMeassge(url);
        JSONObject json = JSONObject.fromObject(message);
        JSONArray tickets = json.getJSONArray("tickets");
        JSONObject ticket = tickets.getJSONObject(0);
        nonceTicket = ticket.getString("value");
        logger.info("nonceTicket is{} ", nonceTicket);
        List<String> values = new ArrayList<String>();
        values.add(appID);
        values.add(userID);
        values.add("1.0.0");
        String s = UUID.randomUUID().toString();
        s = s.replace("-", "");
        values.add(s);
        String sign = SignUtil.sign(values, nonceTicket);
        return sign;
    }
}
