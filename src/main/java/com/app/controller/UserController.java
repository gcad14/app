package com.app.controller;

import com.app.model.MailRequest;
import com.app.service.ExportService;
import com.app.service.SendMailService;
import com.app.service.UserService;
import fr.opensagres.xdocreport.core.XDocReportException;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@RestController
@Api(tags = "userController",description = "测试Controller")
@RequestMapping("/user")
@CrossOrigin
public class UserController {

    @Autowired
    private UserService userService;
    @Autowired
    private ExportService exportService;
    @Autowired
    private SendMailService sendMailService;

    @GetMapping("/getUserInfo")
    @ApiOperation("获取用户信息")
    public String getUser() {
        return userService.getUser();
    }

    //导出Word
    @GetMapping("/export/word")
    @ApiOperation("导出Word")
    public void exportWord(HttpServletResponse response) throws IOException, XDocReportException {
        exportService.word(response);
    }

    //发送邮件
    @GetMapping("/send/email")
    @ApiOperation("发送邮件")
    public void email(MailRequest mailRequest) {
        sendMailService.sendSimpleMail(mailRequest);
    }
}
