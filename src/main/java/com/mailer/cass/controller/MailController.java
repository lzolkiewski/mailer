package com.mailer.cass.controller;

import com.mailer.cass.exception.EntityNotFoundException;
import com.mailer.cass.model.MagicNumberReceiver;
import com.mailer.cass.model.Mail;
import com.mailer.cass.service.MailService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.http.MediaType;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.annotation.RequestScope;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api")
public class MailController {
    private final Logger logger = LoggerFactory.getLogger(MailController.class);

    @Autowired
    private MailService mailService;

    @PostMapping("/message")
    public Mail storeMessage(@RequestBody Mail mail){
        return mailService.storeMessage(mail);
    }

    @PostMapping(value = "/send")
    public List<Mail> sendMessages(@RequestParam MultiValueMap<String, String> paraMap) {
        Map<String, String> map = paraMap.toSingleValueMap();
        // get numeric value from from map
        return mailService.sendMessages(Integer.parseInt(map.toString().replaceAll("[\\D]", "")));
    }

    @GetMapping(value = "/messages/{emailValue}", params = "page")
    public List<Mail> messagesByMail(@PathVariable(value="emailValue") String email,
                                     @RequestParam(value = "page", defaultValue = "1") Integer page) {
        return mailService.mailsByEmail(email, page);
    }
}
