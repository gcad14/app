package com.app.service.impl;

import com.app.service.IScheduledService;
import com.app.service.SendMailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class ScheduledServiceImpl implements IScheduledService {
    @Autowired
    private SendMailService sendMailService;

    @Scheduled(cron = "*/5 * * ? * *")
    public void testTaskWithDate() {
        System.out.println(LocalDateTime.now());
//        sendMailService.sendSimpleMail(new MailRequest("2011766189@qq.com","提醒","发送邮件"));
    }

}
