package com.example.demo.Scheduled;

import com.example.demo.service.AccessTokenService;
import com.example.demo.service.SignTicketService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

/**
 * Created by zhuJY on 17/8/11.
 */
@Component
public class ScheduledToken {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());
    @Value("${my.appID}")
    private String appID;
    @Value("${my.appScret}")
    private String appScret;
    private String url = null;
    private int i = 0;
    private int j = 0;

    @Autowired
    AccessTokenService accessTokenService;

    @Autowired
    SignTicketService signTicketService;

    @Scheduled(fixedDelay = (1000 * 6600))
    public void tokenScheduled() {
        logger.info("user is " + appID + " sec is " + appScret);
        url = "https://idasc.webank.com/api/oauth2/access_token?app_id=" + appID + "&secret=" + appScret + "&grant_type=client_credential&version=1.0.0";
        logger.info("url is " + url);
        accessTokenService.getAccessToken(url);
        String accessToken = AccessTokenService.ACCESS_TOKEN;
        i++;
        logger.info("ScheduledTest.executeFileDownLoadTask token定时任务" + i + ":" + accessToken);

    }

    @Scheduled(fixedDelay = (1000 * 60 * 50), initialDelay = 10000)
    public void signTicketScheduled() {
        url = "https://idasc.webank.com/api/oauth2/api_ticket?app_id=" + appID + "&access_token=" + AccessTokenService.ACCESS_TOKEN + "&type=SIGN&version=1.0.0";
        if (AccessTokenService.ACCESS_TOKEN != null) {
            signTicketService.getSignTicket(url);
        }
        j++;
        logger.info("ScheduledTest.executeFileDownLoadTask tciket定时任务" + j + ":" + SignTicketService.signTicket);

    }


}
