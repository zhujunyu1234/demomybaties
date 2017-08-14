package com.example.demo.service;

import com.example.demo.util.GetMessage;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;


/**
 * Created by zhuJY on 17/8/11.
 */
@Service
public class SignTicketService {
    private final Logger logger = LoggerFactory.getLogger(SignTicketService.class);
    public static String signTicket = null;

    public void getSignTicket(String url) {
        String message = GetMessage.getMeassge(url);
        JSONObject json = JSONObject.fromObject(message);
        JSONArray tickets = json.getJSONArray("tickets");
        JSONObject ticket = tickets.getJSONObject(0);
        signTicket = ticket.getString("value");
        logger.info("signTicket is{} ", signTicket);
    }
}
