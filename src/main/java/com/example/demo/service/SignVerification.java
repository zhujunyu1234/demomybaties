package com.example.demo.service;

import com.example.demo.util.SignUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by zhuJY on 17/8/14.
 */
@Service
public class SignVerification {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Value("${my.appID}")
    private String appID;

    public boolean signVerificationMode1(String SDKresult, String orderNo) {
        List<String> data = new ArrayList<String>();
        data.add(appID);
        data.add(orderNo);
        String sign = SignUtil.sign(data, SignTicketService.signTicket);
        logger.info("SignVerification is {}" + sign);
        if (SDKresult.equals(sign)) {
            return true;
        } else {
            return false;
        }
    }
}
