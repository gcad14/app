package com.app;

import com.app.model.MailRequest;
import com.app.service.SendMailService;
import com.app.service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class TestExport {

    @Autowired
    private SendMailService sendMailService;
    @Autowired
    private UserService userService;

    @Test
    public void testEmal() {
//        sendMailService.sendSimpleMail(new MailRequest("2011766189@qq.com", "通知", "测试"));
//        sendMailService.sendSimpleMail(new MailRequest("gc13721656451@163.com", "通知", "哈哈哈"));
        String user = userService.getUser("张三");
        System.out.println(user);
    }


}
